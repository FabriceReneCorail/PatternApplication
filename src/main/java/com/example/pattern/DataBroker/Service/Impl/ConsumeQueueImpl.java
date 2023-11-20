package com.example.pattern.DataBroker.Service.Impl;

import com.example.pattern.DataBroker.Service.ConsumerQueue;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumeQueueImpl implements ConsumerQueue {
    private static final String QUEUE_NAME = "QueueTest";
    private final static String EXCHANGE_NAME = "ProducerToQueue";

    @Override
    public void consumeMessages() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, true, false, false, null); // Déclaration de la file d'attente
            channel.exchangeDeclare(EXCHANGE_NAME, "direct", true); // Déclare l'échange avec la durabilité
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

            System.out.println("En attente de messages...");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("Message reçu : '" + message + "'");
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
        }
    }

}
