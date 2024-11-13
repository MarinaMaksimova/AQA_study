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
        Array arr = new Array(4, 4);
        arr.fillArrayWithSymbols();
//        arr.fillArrayWithNumbers();
        try {
            arr.findSumOfArray(arr.array);
            arr.showArray();
        } catch (MyArraySizeException | MyArrayDataException e) {
            //System.out.println(e.getMessage());
        }
//        arr.findSumOfArray(arr.array);
//        arr.showArray();
    }
}
