package edu.mriabov.service;

import edu.mriabov.config.CSVParserConfig;
import edu.mriabov.model.Record;
import edu.mriabov.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Parser;
import java.util.List;

@Service
public class ParserService {

    private final CSVParserConfig csvParserConfig;
    private final String delimiter;

    public ParserService(CSVParserConfig csvParserConfig) {
        this.csvParserConfig = csvParserConfig;
        delimiter = csvParserConfig.getDelimiter();
    }

    public Record parse(List<String> lines) {
        Student student = new Student();
        Record record = new Record(student, null);

        String[] headerSplit = lines.get(0).split(delimiter);
        for (int i = 1; i < lines.size(); i++) {
            String[] currentLineSplit = lines.get(i).split(delimiter);
            for (int j = 0; j < currentLineSplit.length; j++) {
                switch (headerSplit[j]) {
                    case "Studentid" ->
                    case  "Name" ->
                    case  "Surname" ->
                    case  "Study id" ->
                    case  "field code" ->
                    case  "field" ->
                    case  "course year of study" ->
                    case  "course semester" ->
                    case  "course academic year" ->
                    case  "course code" ->
                    case  "Course name" ->
                    case  "course type" ->
                    case  "Exam result" ->
                    case  "register date" ->
                    case  "registered by" ->
                    case  "Exam date" ->
                    case  "Exam teacher" ->
                    case  "retaked course - code" ->
                    case  "retaked course - name" ->
                    case  "retaked course - academic year" ->
                    case  "approved forgived course - code" ->
                    case  "approved forgived course - name" ->
                    case  "approved forgived course - academic year" ->
                    case  "exam grade" ->
                    case  "Credits for enrolled courses per academic year" ->
                    case  "Credits for passed courses for period" ->
                    case  "exam credits registered" ->
                    case  "exam credits obtained" ->
                    case "" -> record.getStudent().getId();
                }
            }
        }
        return record;
    }
}
