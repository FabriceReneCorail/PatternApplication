package com.example.pattern.DataBroker;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController("Producer")
public class RabbitMqController {
    private ServiceRB serviceRB;

    public RabbitMqController(ServiceRB serviceRB) {
        this.serviceRB = serviceRB;
    }
    @PostMapping("Message")
    public ResponseEntity fillRabbitMQQueue(@RequestBody @Valid SupportDto dto) throws IOException, TimeoutException {
        serviceRB.publishMessage(dto.getMessages());
        return ResponseEntity.ok().build();
    }

}
