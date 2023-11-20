package com.example.pattern.DataBroker;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;



public class ServiceRBImpl implements ServiceRB {
    private final ConnectionFactory connectionFactory;
    private  String QUEUE_NAME = "QueueTest";

    public ServiceRBImpl(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }
    public Channel createChannel() throws IOException, TimeoutException {
        final var host = "amqp.pattern.com";
        connectionFactory.setHost(host);
        Channel channel = connectionFactory.newConnection().createChannel();
        return channel;
    }

    public void publishMessage(List<String> messages) throws IOException, TimeoutException {
    final var channel = createChannel();
    messages.stream().map(String::getBytes).forEach(messageBytes -> {
        try {
            channel.basicPublish("Controller to Queue", QUEUE_NAME, null,  messageBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    });
    }


}

