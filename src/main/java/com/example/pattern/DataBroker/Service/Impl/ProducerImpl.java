package com.example.pattern.DataBroker.Service.Impl;


import com.example.pattern.DataBroker.Service.Producer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class ProducerImpl implements Producer {
    private final ConnectionFactory connectionFactory = new ConnectionFactory();
    private static final String QUEUE_NAME = "QueueTest";
    private final static String EXCHANGE_NAME = "ProducerToQueue";
    private final ConsumerImpl consumer = new ConsumerImpl();

    public ProducerImpl() {
    }

    public Channel createChannel() throws IOException, TimeoutException {
        final var host = "localhost";
        connectionFactory.setHost(host);
       return connectionFactory.newConnection().createChannel();
    }

    public void publishMessage(List<String> messages) throws IOException, TimeoutException {
        Channel channel = null;
        try {
            channel = createChannel();
            Channel finalChannel = channel;
            messages.stream().map(String::getBytes).forEach(messageBytes -> {
                try {
                    finalChannel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, null, messageBytes);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            // Compte des messages...
        } finally {
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (IOException | TimeoutException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

