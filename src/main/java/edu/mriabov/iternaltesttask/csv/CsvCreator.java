package edu.mriabov.iternaltesttask.csv;

import edu.mriabov.iternaltesttask.config.Config;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CsvCreator {

    private final Config config;

    public void createCSV(List<String[]> input){
        String content = createCsvContent(input);
        createInvalidFile("invalidLines",content);
    }

    private void createInvalidFile(String invalidFileName,String content){
        String invalidOutputPath = config.getInvalidOutputPath();
        try (FileOutputStream fos = new FileOutputStream(invalidOutputPath+invalidFileName+".csv")) {
            fos.write(content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String createCsvContent(List<String[]> input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String[] line: input){
            for (String value: line) stringBuilder.append(value);
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }


}
