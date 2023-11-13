package com.example.pattern.DataConnectors.Service.impl;

import com.example.pattern.DataConnectors.Dto.PathDto;
import com.example.pattern.DataConnectors.Service.ExcelService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
// i know that the CI gonna cry with java.io :)
@Service
public class ExcelServiceImpl implements ExcelService {
    private static final String COMMA_DELIMITER = ",";
    @Override
    public List<List<String>> readCSV(PathDto path) throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path.getPath().toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }


    public static void insertBatch(List<List<String>> records){

    }

}
