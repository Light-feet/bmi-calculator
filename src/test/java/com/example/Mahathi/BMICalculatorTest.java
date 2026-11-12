
package com.example.Mahathi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BMICalculatorTest {

    // Test 1: BMI calculation for known values
    @Test
    void testBMICalculation() {
        assertEquals(22.86,
                BMICalculator.calculateBMI(70, 1.75), 0.01);
    }

    // Test 2: Underweight category
    @Test
    void testUnderweight() {
        assertEquals("Underweight",
                BMICalculator.getBMICategory(18.49));
    }

    // Test 3: Normal category
    @Test
    void testNormal() {
        assertEquals("Normal",
                BMICalculator.getBMICategory(22));
    }

    // Test 4: Overweight category
    @Test
    void testOverweight() {
        assertEquals("Overweight",
                BMICalculator.getBMICategory(27));
    }

    // Test 5: Obese category
    @Test
    void testObese() {
        assertEquals("Obese",
                BMICalculator.getBMICategory(32));
    }

    // Test 6: Category boundary values
    @Test
    void testCategoryBoundaries() {

        assertEquals("Normal",
                BMICalculator.getBMICategory(18.5));

        assertEquals("Overweight",
                BMICalculator.getBMICategory(25));

        assertEquals("Obese",
                BMICalculator.getBMICategory(30));
    }

    // Test 7: Zero and negative weight
    @Test
    void testInvalidWeight() {

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(0, 1.75));

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(-10, 1.75));
    }

    // Test 8: Zero and negative height
    @Test
    void testInvalidHeight() {

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(70, 0));

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(70, -1));
    }

    // Test 9: Extreme weight and height
    @Test
    void testExtremeValues() {

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(600, 1.75));

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(70, 3.0));

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(0.5, 1.75));

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(70, 0.4));
    }

    // Test 10: NaN and infinity
    @Test
    void testNonFiniteValues() {

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(Double.NaN, 1.75));

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(70, Double.POSITIVE_INFINITY));
    }

    // Test 11: Invalid BMI category input
    @Test
    void testInvalidBMI() {

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.getBMICategory(0));

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.getBMICategory(-5));

        assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.getBMICategory(Double.NaN));
    }
}
