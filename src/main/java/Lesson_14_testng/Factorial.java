package Lesson_14_testng;

import java.math.BigInteger;

/*Создайте 2 ветки: Lesson_14_junit_5 и Lesson_14_testng. Напишите программу, позволяющую вычислить факториал числа.
Эта программа должна быть в каждой ветке.
В ветке Lesson_14_junit_5 напишите юнит-тесты для этой программы, используя Junit 5.
В ветке Lesson_14_testng напишите юнит-тесты, используя TestNG.*/

public class Factorial {
    public BigInteger factorial(int f) {
        if (f < 0) {
            throw new IllegalArgumentException("Значение не должно быть отрицательным.");
        }
        else if (f == 1 || f == 0) {
            return BigInteger.valueOf(1);
        }
        else {
            return BigInteger.valueOf(f).multiply(factorial(f - 1));
        }
    }
}
