package com.example.pattern.DataBroker.Service.Impl;

import com.example.pattern.DataBroker.Service.Consumer;
import com.example.pattern.DataBroker.Service.Producer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.springframework.stereotype.Service;

@Service
public class ProducerImpl implements Producer {
    private final ConnectionFactory connectionFactory = new ConnectionFactory();
    private static final String QUEUE_NAME = "QueueTest";
    private final static String EXCHANGE_NAME = "ProducerToQueue";
    private final Consumer consumer = new ConsumerImpl();

    public ProducerImpl() {
    }
 // https://spring.io/guides/gs/messaging-rabbitmq/
    public void publishMessage(List<String> messages) throws IOException, TimeoutException {
        connectionFactory.setHost("localhost");
        try {
            Channel channel = connectionFactory.newConnection().createChannel();
            messages.stream().map(String::getBytes).forEach(messageBytes -> {
                try {
                    channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, null, messageBytes);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            consumer.consumeMessages();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
