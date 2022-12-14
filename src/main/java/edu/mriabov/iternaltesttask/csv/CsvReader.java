package edu.mriabov.iternaltesttask.csv;

import edu.mriabov.iternaltesttask.config.Config;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class CsvReader {

    private final Config config;

    public List<String> getLinesFromCSV() {
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(config.getInputPath()));) {
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
