package com.example.pattern.DataBroker.Api.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MessageDto {
    private String name;
    private List<String> messages;
}
