package edu.mriabov.io;

import com.opencsv.CSVReader;
import edu.mriabov.config.CSVParserConfig;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetCSV {

    private final CSVParserConfig config;

    public List<String> getLinesFromCSV() {
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Employee.csv"));) {
            scanner.useDelimiter(config.getDelimiter());
            while (scanner.hasNext()) {
                result.add(scanner.nextLine());
            }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }
        return result;
    }

}
