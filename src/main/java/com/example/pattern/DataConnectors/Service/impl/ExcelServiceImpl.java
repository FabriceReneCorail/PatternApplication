package com.example.pattern.DataConnectors.Service.impl;

import com.example.pattern.DataConnectors.Service.ExcelService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class ExcelServiceImpl implements ExcelService {
    private static final String COMMA_DELIMITER = ",";
    @Override
    public List<List<String>> readCSV() throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(selectFileFromComputer()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }
    private File selectFileFromComputer(){
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(null);
       return jFileChooser.getSelectedFile().getAbsoluteFile();
    }
}
