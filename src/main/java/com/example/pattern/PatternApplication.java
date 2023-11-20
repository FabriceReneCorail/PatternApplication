package com.example.pattern;

import com.example.pattern.DataBroker.Service.Impl.ConsumeQueueImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class PatternApplication {

    private final ConsumeQueueImpl consumeQueue = new ConsumeQueueImpl();

    public static void main(String[] args) throws IOException, TimeoutException {
        SpringApplication.run(PatternApplication.class, args);
    }
        @PostConstruct
        public void scheduleMessageConsumption() {
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(() -> {
                try {
                    consumeQueue.consumeMessages();
                } catch (IOException | TimeoutException e) {
                    e.printStackTrace();
                }
            }, 0, 30, TimeUnit.SECONDS);
        }
    }


