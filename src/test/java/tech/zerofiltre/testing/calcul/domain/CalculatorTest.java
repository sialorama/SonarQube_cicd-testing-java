package tech.zerofiltre.testing.calcul.domain;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculatorUnderTest = new Calculator();

    @Test
    void add_twoIntegers_shouldReturnTheSum() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculatorUnderTest.add(a, b);

        // Assert
        assertEquals(8, result);
    }

    @Test
    void sub_twoIntegers_shouldReturnTheDifference() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int result = calculatorUnderTest.sub(a, b);

        // Assert
        assertEquals(6, result);
    }

    @Test
    void multiply_twoIntegers_shouldReturnTheProduct() {
        // Arrange
        int a = 7;
        int b = 6;

        // Act
        int result = calculatorUnderTest.multiply(a, b);

        // Assert
        assertEquals(42, result);
    }

    @Test
    void divide_twoIntegers_shouldReturnTheQuotient() {
        // Arrange
        int a = 20;
        int b = 5;

        // Act
        int result = calculatorUnderTest.divide(a, b);

        // Assert
        assertEquals(4, result);
    }

    @Test
    void divide_byZero_shouldThrowArithmeticException() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act & Assert
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculatorUnderTest.divide(a, b);
        });

        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void add_twoDoubles_shouldReturnTheSum() {
        // Arrange
        double a = 1.5;
        double b = 2.5;

        // Act
        double result = calculatorUnderTest.add(a, b);

        // Assert
        assertThat(result).isEqualTo(4.0);
    }

    @Test
    void sub_twoDoubles_shouldReturnTheDifference() {
        // Arrange
        double a = 5.5;
        double b = 1.5;

        // Act
        double result = calculatorUnderTest.sub(a, b);

        // Assert
        assertThat(result).isEqualTo(4.0);
    }

    @Test
    void multiply_twoDoubles_shouldReturnTheProduct() {
        // Arrange
        double a = 3.0;
        double b = 2.5;

        // Act
        double result = calculatorUnderTest.multiply(a, b);

        // Assert
        assertThat(result).isEqualTo(7.5);
    }

    @Test
    void divide_twoDoubles_shouldReturnTheQuotient() {
        // Arrange
        double a = 7.5;
        double b = 2.5;

        // Act
        double result = calculatorUnderTest.divide(a, b);

        // Assert
        assertThat(result).isEqualTo(3.0);
    }

    @Test
    void divide_doubleByZero_shouldThrowArithmeticException() {
        // Arrange
        double a = 10.5;
        double b = 0.0;

        // Act & Assert
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculatorUnderTest.divide(a, b);
        });

        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void fact_positiveInteger_shouldReturnFactorial() {
        // Arrange
        int a = 5;

        // Act
        int result = calculatorUnderTest.fact(a);

        // Assert
        assertEquals(120, result); // 5! = 120
    }

    @Test
    void fact_negativeNumber_shouldThrowIllegalArgumentException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorUnderTest.fact(-5);
        });
    }

    @Test
    void fact_numberGreaterThan12_shouldThrowIllegalArgumentException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorUnderTest.fact(13);
        });
    }

    @Test
    void longCalculation_shouldPauseFor500Milliseconds() {
        // Arrange
        long startTime = System.currentTimeMillis();

        // Act
        calculatorUnderTest.longCalculation();

        // Assert
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertThat(duration).isGreaterThanOrEqualTo(500).isLessThan(600);
    }

    @Test
    void digitsSet_positiveInteger_shouldReturnSetOfDigits() {
        // Arrange
        int number = 12345;

        // Act
        Set<Integer> digits = calculatorUnderTest.digitsSet(number);

        // Assert
        Set<Integer> expectedDigits = Set.of(1, 2, 3, 4, 5);
        assertEquals(expectedDigits, digits);
    }

    @Test
    void digitsSet_negativeInteger_shouldReturnSetOfDigitsIgnoringNegativeSign() {
        // Arrange
        int number = -6789;

        // Act
        Set<Integer> digits = calculatorUnderTest.digitsSet(number);

        // Assert
        Set<Integer> expectedDigits = Set.of(6, 7, 8, 9);
        assertEquals(expectedDigits, digits);
    }

    @Test
    void digitsSet_zero_shouldReturnSetWithZero() {
        // Arrange
        int number = 0;

        // Act
        Set<Integer> digits = calculatorUnderTest.digitsSet(number);

        // Assert
        Set<Integer> expectedDigits = Set.of(0);
        assertEquals(expectedDigits, digits);
    }

    @Test
    void subtract_shouldReturnTheDifference() {
        // Arrange
        int a = 10;
        int b = 3;

        // Act
        int result = calculatorUnderTest.subtract(a, b);

        // Assert
        assertEquals(7, result);
    }
}
