package edu.mriabov.iternaltesttask.utils;

import edu.mriabov.iternaltesttask.model.Course;
import edu.mriabov.iternaltesttask.model.Exam;
import edu.mriabov.iternaltesttask.model.Student;
import edu.mriabov.iternaltesttask.model.Study;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.NONE)
public class ModelUtils {

    public static Student getStudent(String[] params) {
        Student student = new Student();
        student.setId(params[0]);
        student.setName(params[1]);
        student.setSurname(params[2]);

        return student;
    }

    public static Map<String,Study> getStudentInfo(List<String[]> studentParams) {
        Map<String,Study> result = new HashMap<>();

        Map<Study, Set<Course>> studyCourses = getStudyInfos(studentParams);
        for (Map.Entry<Study, Set<Course>> studyInfo : studyCourses.entrySet()) {
            Study study = studyInfo.getKey();
            study.setCourse(studyInfo.getValue());
            result.put(study.getId(), study);
        }
        return result;
    }

    private static Map<Study, Set<Course>> getStudyInfos(List<String[]> studentParams) {
        Map<Study, Set<Course>> studyCourses = new HashMap<>();
        for (String[] params : studentParams) {
            Study study = getStudy(params);
            studyCourses.computeIfAbsent(study,v -> new HashSet<>());
            Set<Course> courses = studyCourses.get(study);
            courses.add(getCourse(params));
        }
        return studyCourses;
    }

    public static Study getStudy(String[] params) {
        Study study = new Study();
        study.setId(params[3]);
        study.setFieldCode(params[4]);
        study.setField(params[5]);

        return study;
    }

    public static Course getCourse(String[] params) {
        Course course = new Course();
        course.setYear_of_study(params[6]);
        course.setSemester(params[7]);
        course.setAyear(params[8]);
        course.setCode(params[9]);
        course.setName(params[10]);
        course.setType(params[11]);
        course.setExam(getExam(params));

        return course;
    }

    public static Exam getExam(String[] params) {
        Exam exam = new Exam();
        exam.setResult(params[12]);
        exam.setDate(params[15]);
        exam.setTeacher(params[16]);
        exam.setGrade(params[23]);
        exam.setCredits_reg(Integer.parseInt(params[26]));
        exam.setCredits_obt(Integer.parseInt(params[27]));

        return exam;
    }

}
