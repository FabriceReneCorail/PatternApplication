package com.example.pattern.DataConnectors.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;


public interface ExcelService {
    List<List<String>> readCSV(File file) throws IOException;
}
