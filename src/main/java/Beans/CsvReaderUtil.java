package Beans;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReaderUtil {
    public List<String[]> readCsv(String filePath) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            return csvReader.readAll();
        }
    }
}
