package edu.mriabov.iternaltesttask.utils;

import edu.mriabov.iternaltesttask.model.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModelUtilsTest {

    /**
     * Method under test: {@link ModelUtils#getStudent(String[])}
     */
    @Test
    void testGetStudent4() {
        // Arrange and Act
        Student actualStudent = ModelUtils.getStudent(new String[]{"Params", "Params", "Params"});

        // Assert
        assertEquals("Params", actualStudent.getId());
        assertEquals("Params", actualStudent.getSurname());
        assertEquals("Params", actualStudent.getName());
    }

    /**
     * Method under test: {@link ModelUtils#getStudentInfo(List)}
     */
    @Test
    void testGetStudentInfo() {
        // Arrange, Act and Assert
        assertTrue(ModelUtils.getStudentInfo(new ArrayList<>()).isEmpty());
    }
}

