package lesson3;

public class Methods {

    /* 1. Создайте метод printThreeWords(), который при вызове должен
            отпечатать в столбец три слова: Orange, Banana, Apple. */
    public void printThreeWords() {
        System.out.println("Orange\n" + "Banana\n" + "Apple\n");
    }

    /* 2. Создайте метод checkSumSign(), в теле которого объявите две
        int переменные a и b, инициализируйте их любыми значениями, которыми
        захотите. Далее метод должен просуммировать эти переменные, и если их
        сумма больше или равна 0, то вывести в консоль сообщение "Сумма
        положительная", в противном случае - "Сумма отрицательная". */
    public void checkSumSign() {
        int a = -6;
        int b = 5;

        if ((a + b) >= 0) {
            System.out.println("Сумма положительная\n");
        } else {
            System.out.println("Сумма отрицательная\n");
        }
    }

    /* 3. Создайте метод printColor(), в теле которого задайте int
        переменную value и инициализируйте ее любым значением. Если value
        меньше 0 (0включительно), то в консоль метод должен вывести сообщение
        "Красный", если лежит в пределах от 0 (0 исключительно) до 100 (100
        включительно), то "Желтый", есил больше 100 (100 исключительно) - "Зеленый".*/
    public void printColor() {
        int value = -50;
        if (value <= 0) {
            System.out.println("Красный\n");
        } else if (value > 100) {
            System.out.println("Зеленый\n");
        } else {
            System.out.println("Желтый\n");
        }
    }

    /* 4. Создайте метод compareNumbers(), в теле которого объявите две int
        переменные a и b, инициализируйте их любыми значениями, которыми
        захотите. Если а больше или равно b, то необходимо вывести в консоль
        сообщение "а >= b", в противном случае "а < b". */
    public void compareNumbers() {
        int a = 5;
        int b = 5;
        if (a >= b) {
            System.out.println("а >= b\n");
        } else {
            System.out.println("а < b\n");
        }
    }

    /* 5. Напишите метод, принимающий на вход два целых числа и проверяющий,
            что их сумма лежит в пределах от 10 до 20 (включительно), если да - вернуть
            true, в противном случае - false. */
    public boolean isSumInRange(int a, int b) {
//        if ((a + b) >=10 && (a + b) <=20){
//            return true;
//        } else {
//            return false;
//        }
        return a + b >= 10 && a + b <= 20;
    }

    /* 6. Напишите метод, которому в качестве параметра передается целое число,
            метод должен напечатать в консоль положительное ли число передали или
            отрицательное. Замечание: 0 считаем положительным числом. */
    public void comparePositiveNegative(int a) {
        if (a >= 0) {
            System.out.println("Число положительное\n");
        } else {
            System.out.println("Число отрицательное\n");
        }
    }

    /* 7. Напишите метод, которому в качестве параметра передается целое число.
            Метод должен вернуть true, если число отрицательное, и вернуть false если
            положительное. Замечание: 0 считаем положительным числом. */
    public boolean isNegative(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    /* 8. Напишите метод, которому в качестве аргументов передается строка и
           число, мтеод должен отпечатать в консоль указанную строку, указанное
           количество раз. */
    public void printStringNTimes(String str, int a) {
        a = Math.abs(a);
        System.out.println("Количество раз, которое строка должна вывестись: " + a);
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    /* 9. Напишите метод, который определяет, является ли год високосным, и
            возвращает boolean (true - високосный, false - не високосный). Каждый 4-ый
            год является високосным, кроме каждого 100-го, при этом каждый 400-й - високосный. */
    public boolean isLeapYear(int year) {
//        if (year % 4 == 0) {
//            if (year % 100 == 0) {
//                if (year % 400 == 0){
//                    return true;
//                }
//                return false;
//            }
//            return true;
//        }
//            return false;
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    /* 10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
            [1, 1, 0, 0, 1, 0, 1, 1, 0, 0]. С помощью цикла и условия заменить 0 на 1 и наоборот. */
    public void replaceArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("Изначальный массив:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nИзмененный массив:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
            System.out.print(arr[i] + " ");
        }

    }

    /* 11. Задать пустой целочисленный массив длинной 100. С помощью цикла заполнить
            его значениями 1 2 3 ... 100. */
    public void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

    /* 12. Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]. Пройти по нему
            циклом, и числа меньше 6 умножить на 2. */
    public void multiplicationArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Изначальный массив:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nИзмененный массив:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
            System.out.print(arr[i] + " ");
        }
    }

    /* 13. Создать квадратный двумерный целочисленный массив (кол-во строк и столбцов
        одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        (можно только одну из диагоналей, если обе сложно). Определить элементы одной из
        диагоналей можно по следующему принципу: индексы таких элементов равны, т.е. [0][0],
        [1][1] ... [n][n]. */
    public void diagonalArray(int a) {
        int[][] arr = new int[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == j || j == a - 1 - i) {
                    arr[i][j] = 1;
                } else arr[i][j] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* 14. Написать метод, принимающий на вход два аргумента: len и initialValue, и
            возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна
            initialValue. */
    public void createCustomArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
            System.out.print(arr[i] + " ");
        }
    }

}
