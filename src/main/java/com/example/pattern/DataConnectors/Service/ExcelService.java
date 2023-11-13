package com.example.pattern.DataConnectors.Service;

import com.example.pattern.DataConnectors.Dto.PathDto;
import java.io.IOException;
import java.util.List;


public interface ExcelService {
    List<List<String>> readCSV(PathDto pathDto) throws IOException;
}
