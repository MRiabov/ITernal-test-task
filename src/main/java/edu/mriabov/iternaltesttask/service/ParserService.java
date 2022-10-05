package edu.mriabov.iternaltesttask.service;

import edu.mriabov.iternaltesttask.config.CSVParserConfig;
import edu.mriabov.iternaltesttask.model.Record;
import edu.mriabov.iternaltesttask.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParserService {

    private final CSVParserConfig csvParserConfig;
    private final ValidatorService validatorService;

    public Set<Record> parse(List<String> lines) {
        boolean isCorrupt = false;
        Map<String, Record> records = new HashMap<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            List<String> split = List.of(line.split(csvParserConfig.getDelimiter()));
            if (!(validatorService.isValidDate(split.get(15)) || validatorService.isNumber(split.get(23)) ||
                    validatorService.isNumber(split.get(26)) || validatorService.isNumber(split.get(27))))
                isCorrupt = true;
            records.put(split.get(0), populateRecord(records, split));
        }
        if (isCorrupt) log.warn("CSV input is wrong!");
        log.info("Finished CSV processing! There were " + lines.size() + " lines.");
        return new HashSet<>(records.values());
    }

    private static Record populateRecord(Map<String, Record> records, List<String> split) {

        Exam exam = new Exam(split.get(12), split.get(15), split.get(16),
                split.get(23),Integer.parseInt(split.get(26)),Integer.parseInt(split.get(27)));
        Course course = new Course(split.get(9), split.get(10), split.get(11), split.get(7), split.get(8), split.get(6), exam);
        Record thisRecord;
        Student student;
        if (!records.containsKey(split.get(0))) {
            student = new Student(split.get(0), split.get(1), split.get(2));
            thisRecord = new Record(student, new HashMap<>());
            records.put(split.get(0), thisRecord);
        } else {
            thisRecord = records.get(split.get(0));
        }
        if (thisRecord.getStudies().containsKey(split.get(3))) {
            thisRecord.getStudies().get(split.get(3)).getCourse();
        } else {
            thisRecord.getStudies().put(split.get(3), new Study(split.get(3), split.get(4), split.get(5),
                    Set.of(course)));
        }
        return thisRecord;
    }
}
