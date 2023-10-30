package com.example.pattern.service.Filters;

import java.util.Date;
import lombok.Data;

@Data
public class Filter {
    private Integer age;
    private Long salary;
    private Date date;
    private String company;
}
// change it to an interface an implement all the filter into a classImpl please 