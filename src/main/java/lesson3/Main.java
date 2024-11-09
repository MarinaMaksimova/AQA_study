package lesson3;
//import lesson3.Methods;

public class Main {
    public static void main(String[] args) {

        Methods methods = new Methods();

        System.out.println("Задание 1:");
        methods.printThreeWords();

        System.out.println("Задание 2:");
        methods.checkSumSign();

        System.out.println("Задание 3:");
        methods.printColor();

        System.out.println("Задание 4:");
        methods.compareNumbers();

        System.out.println("Задание 5:");
        System.out.println(methods.isSumInRange(15, 5) + "\n");

        System.out.println("Задание 6:");
        methods.comparePositiveNegative(3);

        System.out.println("Задание 7:");
        System.out.println(methods.isNegative(0) + "\n");

        System.out.println("Задание 8:");
        methods.printStringNTimes("строка", -3);
        System.out.println();

        System.out.println("Задание 9:");
        System.out.println(methods.isLeapYear(2023) + "\n");

        System.out.println("Задание 10:");
        methods.replaceArray();
        System.out.println("\n");

        System.out.println("Задание 11:");
        methods.fillArray();
        System.out.println("\n");

        System.out.println("Задание 12:");
        methods.multiplicationArray();
        System.out.println("\n");

        System.out.println("Задание 13:");
        methods.diagonalArray(5);
        System.out.println();

        System.out.println("Задание 14:");
        methods.createCustomArray(3, 22);

    }
}