package edu.mriabov.iternaltesttask.csv;

import edu.mriabov.iternaltesttask.config.CSVParserConfig;
import edu.mriabov.iternaltesttask.model.Record;
import edu.mriabov.iternaltesttask.model.Student;
import edu.mriabov.iternaltesttask.model.Study;
import edu.mriabov.iternaltesttask.utils.Pair;
import edu.mriabov.iternaltesttask.utils.ValidatorUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

import static edu.mriabov.iternaltesttask.utils.ModelUtils.getStudent;
import static edu.mriabov.iternaltesttask.utils.ModelUtils.getStudentInfo;
import static edu.mriabov.iternaltesttask.utils.ValidatorUtils.isLineValid;

@Service
@RequiredArgsConstructor
@Slf4j
public class CSVParser {

    private final CSVParserConfig csvConfig;
    private final CSVReader csvReader;

    public Pair<List<String[]>, Set<Record>> parseData() {
        List<String> linesFromCSV = csvReader.getLinesFromCSV()
                .stream()
                .skip(1)
                .toList();

        return parseData(linesFromCSV);
    }

    private Pair<List<String[]>, Set<Record>> parseData(List<String> lines) {
        Set<Record> studentsInfo = new HashSet<>();
        Map<Student, List<String[]>> studentsParams = getStudentParams(lines);
        for (Student student : studentsParams.keySet()) {
            log.info("Parsing student_id = '{}' info", student.getId());
            Map<String, Study> studySet = getStudentInfo(studentsParams.get(student));
            Record studentInfo = new Record(student, studySet);
            studentsInfo.add(studentInfo);
        }
        return new Pair<>(getInvalidLines(lines), studentsInfo);
    }

    private Map<Student, List<String[]>> getStudentParams(List<String> lines) {
        List<String[]> unparsedLines = getValidLines(lines);
        Map<Student, List<String[]>> studentsParams = new HashMap<>();
        for (String[] unparsedLine : unparsedLines) {
            Student student = getStudent(unparsedLine);
            studentsParams.computeIfAbsent(student,v -> new ArrayList<>());
            List<String[]> params = studentsParams.get(student);
            params.add(unparsedLine);
        }

        return studentsParams;
    }

    private List<String[]> getInvalidLines(List<String> lines) {
        return lines.stream()
                .map(this::getUnparsedLine)
                .filter(line -> !isLineValid(line))
                .toList();
    }

    private List<String[]> getValidLines(List<String> lines) {
        return lines.stream()
                .map(this::getUnparsedLine)
                .filter(ValidatorUtils::isLineValid)
                .toList();
    }

    private String[] getUnparsedLine(String line) {
        return line.split(csvConfig.getDelimiter());
    }
}
