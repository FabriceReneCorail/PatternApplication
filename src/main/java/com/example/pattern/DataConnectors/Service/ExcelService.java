package com.example.pattern.DataConnectors.Service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

public interface ExcelService {
    List<List<String>> readCSV() throws IOException;
}
