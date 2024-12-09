package lesson13;

import java.util.*;
/*Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово. (реализовать с
использованием коллекций)*/

public class ArrayWords {

    public HashSet<String> isWordUnique(String [] arr) {
        HashSet<String> list = new HashSet<>(Arrays.asList(arr)); // автоматически отбрасываются дублирующие элементы из преобразованного массива в лист
        return list;
    }

    public Map<String, Integer> countWordsEncounter(String [] arr) {
        HashMap<String, Integer> wordCounts = new HashMap<>(); // счетчик повторений
        for (String word : Arrays.asList(arr)) { // перебор по словам из преобразованного массива в лист
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1); // помещается ключ-значение (слово-счетчик), где счетчик расчитывается через метод getOrDefault()
        }
        return wordCounts;
    }

}
