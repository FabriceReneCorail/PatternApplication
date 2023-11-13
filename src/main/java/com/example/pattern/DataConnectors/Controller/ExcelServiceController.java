package com.example.pattern.DataConnectors.Controller;

import com.example.pattern.DataConnectors.Dto.PathDto;
import com.example.pattern.DataConnectors.Service.ExcelService;
import java.io.IOException;
import java.nio.file.Path;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ExcelService/")
public class ExcelServiceController {
    private ExcelService excelService;
    public ExcelServiceController(ExcelService excelService) {
        this.excelService = excelService;
    }
    @GetMapping("/readCsvFile/")
    public ResponseEntity readCsvFile(@PathVariable PathDto pathDto) throws IOException {
        excelService.readCSV(pathDto);
       return ResponseEntity.ok().build();
    }
}
