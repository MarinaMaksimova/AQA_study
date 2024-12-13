package Lesson_14_junit_5;

/*Создайте 2 ветки: Lesson_14_junit_5 и Lesson_14_testng. Напишите программу, позволяющую вычислить факториал числа.
Эта программа должна быть в каждой ветке.
В ветке Lesson_14_junit_5 напишите юнит-тесты для этой программы, используя Junit 5.
В ветке Lesson_14_testng напишите юнит-тесты, используя TestNG.*/

public class Main {
    public static void main(String[] args) {
        int num = (int)(Math.random()*51); //рандом чисел до 50 включительно
        Factorial factorialCount = new Factorial();
        System.out.println("Факториал числа "+ num + ": "+ factorialCount.factorial(num));
    }
}
