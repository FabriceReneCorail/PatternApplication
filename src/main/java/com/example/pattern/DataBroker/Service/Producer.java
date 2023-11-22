package com.example.pattern.DataBroker.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;


public interface Producer {
    void publishMessage(List<String> messages) throws IOException, TimeoutException;
}
