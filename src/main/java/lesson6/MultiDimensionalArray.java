package lesson6;

import java.util.Random;
import java.util.Arrays;

/*1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4. При подаче массива другого размера
необходимо бросить исключение MyArray SizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе
массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MyArray SizeException и MyArrayDataException и
вывести результат расчета.*/
public class MultiDimensionalArray {
    public String[][] array;
    private int[][] arrayInt;
    private int sumOfArray;

    public MultiDimensionalArray(int rows, int columns) {           // конструктор класса
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

    public void fillArray() {           // заполняем массив 4 на 4, в 3 строке всего 2 элемента
        array[0][0] = String.valueOf(1);
        array[0][1] = String.valueOf(2);
        array[0][2] = String.valueOf(3);
        array[0][3] = String.valueOf(4);

        array[1][0] = String.valueOf(5);
        array[1][1] = String.valueOf(6);
        array[1][2] = String.valueOf(7);
        array[1][3] = String.valueOf(8);

        array[2][0] = String.valueOf(9);
        array[2][1] = String.valueOf(10);
        array[2][2] = String.valueOf(11);

        array[3][0] = String.valueOf(12);
        array[3][1] = String.valueOf(13);
        array[3][2] = String.valueOf(14);
        array[3][3] = String.valueOf(15);
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

    public void showArray() {           // вывод двумерного массива в консоль
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(Arrays.toString(array[i]));
//        }
        System.out.println(Arrays.deepToString(array));
    }

}
