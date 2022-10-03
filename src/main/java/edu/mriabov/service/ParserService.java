package edu.mriabov.service;

import edu.mriabov.config.CSVParserConfig;
import edu.mriabov.model.Record;
import edu.mriabov.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ParserService {

    private final CSVParserConfig csvParserConfig;
    private final ValidatorService validatorService;

    public Record parse(List<String> lines) {
        boolean isCorrupt = false;
        Student student = new Student();
        Course course = new Course();
        Study study = new Study();
        Exam exam = new Exam();
        study.setCourse(Set.of(course));
        course.setExam(exam);
        Record record = new Record(student, new HashSet<>());

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            List<String> split = List.of(line.split(csvParserConfig.getDelimiter()));
            student.setId(split.get(0));
            student.setName(split.get(1));
            student.setSurname(split.get(2));
            study.setId(split.get(3));
            study.setFieldCode(split.get(4));
            study.setField(split.get(5));
            course.setYear_of_study(split.get(6));
            course.setSemester(split.get(7));
            course.setAyear(split.get(8));
            course.setCode(split.get(9));
            course.setName(split.get(10));
            course.setType(split.get(11));
            exam.setResult(split.get(12));
            if (validatorService.isValidDate(split.get(15))) exam.setDate(Date.valueOf(split.get(12)));
            else isCorrupt = true;
            exam.setTeacher(split.get(16));
            if (validatorService.isNumber(split.get(22)))
                exam.setGrade(Double.valueOf(split.get(22)));
            if (validatorService.isNumber(split.get(26))) exam.setCredits_reg(Integer.parseInt(split.get(26)));
            else isCorrupt = true;
            if (validatorService.isNumber(split.get(27))) exam.setCredits_obt(Integer.parseInt(split.get(27)));
            else isCorrupt = true;


        }
        return record;
    }
}
