package com.example.pattern.DataBroker.Service;

import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;


public interface Producer {
    Channel createChannel() throws IOException, TimeoutException;
    void publishMessage(List<String> messages) throws IOException, TimeoutException;
}
