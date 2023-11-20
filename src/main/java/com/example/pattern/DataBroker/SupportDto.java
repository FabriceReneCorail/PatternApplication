package com.example.pattern.DataBroker;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupportDto {
    private String name;
    private List<String> messages;
}
