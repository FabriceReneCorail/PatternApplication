package com.example.pattern.DataBroker;


import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController ("Producer")
public class RabbitMqController {
    private ServiceRB serviceRB;
@PostMapping("Message")
    public ResponseEntity fillRabbitMQQueue(@RequestBody @Valid SupportDto dto) throws IOException, TimeoutException {
    serviceRB.publishMessage(dto.getMessages());
    return ResponseEntity.ok().build();
}

}
