package com.example.pattern.DataBroker.Api.Controller;

import com.example.pattern.DataBroker.Service.Producer;
import com.example.pattern.DataBroker.Api.Dto.MessageDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController("Producer")
public class RabbitMqController {
    private Producer producer;

    public RabbitMqController(Producer serviceRB) {
        this.producer = serviceRB;
    }
    @PostMapping("Message")
    public ResponseEntity fillRabbitMQQueue(@RequestBody @Valid MessageDto dto) throws IOException, TimeoutException {
        producer.publishMessage(dto.getMessages());
        return ResponseEntity.ok().build();
    }

}
