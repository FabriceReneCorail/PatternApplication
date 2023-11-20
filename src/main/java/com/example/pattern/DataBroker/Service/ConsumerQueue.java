package com.example.pattern.DataBroker.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface ConsumerQueue {
    void consumeMessages() throws IOException, TimeoutException;
}
