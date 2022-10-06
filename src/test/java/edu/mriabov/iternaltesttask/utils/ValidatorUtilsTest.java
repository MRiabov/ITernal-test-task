package edu.mriabov.iternaltesttask.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorUtilsTest {
    /**
     * Method under test: {@link ValidatorUtils#isDateValid(String)}
     */
    @Test
    void testIsDateValid() {
        // Arrange, Act and Assert
        assertTrue(ValidatorUtils.isDateValid("06.10.2022"));
        assertFalse(ValidatorUtils.isDateValid("69.1337.420"));
        assertFalse(ValidatorUtils.isDateValid("Not all who wander are lost."));
    }

    /**
     * Method under test: {@link ValidatorUtils#isDouble(String)}
     */
    @Test
    void testIsDouble() {
        // Arrange, Act and Assert
        assertTrue(ValidatorUtils.isDouble("42"));
        assertTrue(ValidatorUtils.isDouble("42,123"));
        assertTrue(ValidatorUtils.isDouble("42.123"));
        assertFalse(ValidatorUtils.isDouble("foo"));
    }

    /**
     * Method under test: {@link ValidatorUtils#isInt(String)}
     */
    @Test
    void testIsInt() {
        // Arrange, Act and Assert
        assertTrue(ValidatorUtils.isInt("42"));
        assertFalse(ValidatorUtils.isInt("42.123"));
        assertFalse(ValidatorUtils.isInt("foo"));
    }
}

