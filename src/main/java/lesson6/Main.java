package lesson6;

/*1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4. При подаче массива другого размера
необходимо бросить исключение MyArray SizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе
массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MyArray SizeException и MyArrayDataException и
вывести результат расчета.*/
public class Main {
    public static void main(String[] args) {
        // массив с размером 4 на 4 и числовыми данными
        System.out.println("Массив с размером 4 на 4 и числовыми данными:");
        MultiDimensionalArray arr = new MultiDimensionalArray(4, 4);
        arr.fillArrayWithNumbers(); // заполнение массива строковыми символами, которые корректно конвертируются в Int
        try {
            arr.findSumOfArray(arr.array);
            arr.showArray();
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        // массив с размером 4 на 4 и символьно-числовыми данными
        System.out.println("\nМассив с размером 4 на 4 и символьно-числовыми данными:");
        MultiDimensionalArray arr1 = new MultiDimensionalArray(4, 4);
        arr1.fillArrayWithSymbols(); // заполнение массива строковыми символами, которые НЕкорректно конвертируются в Int
        try {
            arr1.findSumOfArray(arr1.array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            arr1.showArray();
        }

        // массив с размером 4 на 4 и символьно-числовыми данными
        System.out.println("\nМассив с размером НЕ 4 на 4 и c числовыми данными:");
        MultiDimensionalArray arr2 = new MultiDimensionalArray(3, 5);
        arr2.fillArrayWithNumbers(); // заполнение массива строковыми символами, которые корректно конвертируются в Int
        try {
            arr2.findSumOfArray(arr2.array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            arr2.showArray();
        }

        // массив с размером 4 на 4 и числовыми данными
        System.out.println("\nМассив с размером 4 на 4 и числовыми данными, но в строке 3 не 4 элемента:");
        MultiDimensionalArray arr3 = new MultiDimensionalArray(4, 4);
        arr3.fillArray();
        arr3.showArray();
        try {
            arr3.findSumOfArray(arr3.array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }
}
