package Lesson_14_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

/*Создайте 2 ветки: Lesson_14_junit_5 и Lesson_14_testng. Напишите программу, позволяющую вычислить факториал числа.
Эта программа должна быть в каждой ветке.
В ветке Lesson_14_junit_5 напишите юнит-тесты для этой программы, используя Junit 5.
В ветке Lesson_14_testng напишите юнит-тесты, используя TestNG.*/

class FactorialTest {

    @DisplayName("Проверка на расчет факториала")
    @ParameterizedTest
    @CsvSource({"5, 120", "18, 6402373705728000", "0, 1", "1, 1"})
    void testFactorial(int actual, BigInteger expected) {
        Factorial factorial = new Factorial();
        assertEquals(expected, factorial.factorial(actual));
    }

    @DisplayName("Проверка на отрицательное число")
    @Test
    void testFactorialIsNotNegative() {
        Factorial factorial = new Factorial();
        assertThrows(IllegalArgumentException.class, () -> {
            factorial.factorial(-5);
        });
    }

    @DisplayName("Проверка на null")
    @Test
    void testFactorialIsNotNull(){
        Factorial factorial = new Factorial();
        assertNotNull(factorial.factorial(46));
    }

}