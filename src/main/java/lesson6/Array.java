package lesson6;

import java.util.Random;

/*1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4. При подаче массива другого размера
необходимо бросить исключение MyArray SizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе
массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MyArray SizeException и MyArrayDataException и
вывести результат расчета.*/
public class Array {
    public String[][] array;
    private int[][] arrayInt;
    private int sumOfArray;

    public Array(int rows, int columns) {           // конструктор класса
        array = new String[rows][columns];
        arrayInt = new int[rows][columns];
    }

    public void fillArrayWithNumbers() {           // метод случайного заполнения массива, где строки станут впоследствии цифрами
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Integer.toString((int) (Math.random() * 9));
            }
        }
    }

    public void fillArrayWithSymbols() {           // метод случайного заполнения массива, где строки станут впоследствии буквами или цифрами
        Random random = new Random();
        String symbols = "абвгдеёжзи0123456789";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int randomSymbol = random.nextInt(symbols.length());
                array[i][j] = Character.toString(symbols.charAt(randomSymbol));
            }
        }
    }

    public void findSumOfArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {         // тот самый нужный нам метод из задания
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4 на 4, текущий массив имеет размер " + arr.length + " на " + arr[0].length);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    arrayInt[i][j] = Integer.parseInt(array[i][j]);
                    sumOfArray += arrayInt[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Невозможно преобразовать элемент в ячейке [" + i + "][" + j + "]: " + arr[i][j]);
                }
            }
        }
        System.out.println("Сумма всех элементов в массиве: " + sumOfArray);
    }

    public void showArray() {           // вывод массива в консоль
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


}
