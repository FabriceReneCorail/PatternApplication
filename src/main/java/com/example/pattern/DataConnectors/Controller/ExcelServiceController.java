package com.example.pattern.DataConnectors.Controller;

import com.example.pattern.DataConnectors.Service.ExcelService;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ExcelService/")
public class ExcelServiceController {
    private ExcelService excelService;
    public ExcelServiceController(ExcelService excelService) {
        this.excelService = excelService;
    }
    @GetMapping("/readCsvFile")
    public ResponseEntity readCsvFile() throws IOException {
        excelService.readCSV();
       return ResponseEntity.ok().build();
    }
}
