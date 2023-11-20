package com.example.pattern.DataBroker;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.springframework.stereotype.Service;

@Service
public class ServiceRBImpl implements ServiceRB {
    private final ConnectionFactory connectionFactory = new ConnectionFactory();
    private static final String QUEUE_NAME = "QueueTest";
    private final static String EXCHANGE_NAME = "Producer to Queue";

    public ServiceRBImpl() {
    }

    public Channel createChannel() throws IOException, TimeoutException {
        final var host = "localhost";
        connectionFactory.setHost(host);
       return connectionFactory.newConnection().createChannel();
    }

    public void publishMessage(List<String> messages) throws IOException, TimeoutException {
        final var channel = createChannel();
        messages.stream().map(String::getBytes).forEach(messageBytes -> {
            try {
                channel.basicPublish("Producer to Queue", QUEUE_NAME, null, messageBytes);
                channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


}

