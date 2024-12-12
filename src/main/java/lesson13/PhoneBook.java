package lesson13;

import java.util.*;
/*Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров. В этот
телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по
фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
запросе такой фамилии должны выводиться все телефоны.*/

public class PhoneBook {
    HashMap <String, List<String>> phoneAndName = new HashMap<>();

    public void addEntry(String  lastName, String phoneNumber){
        ArrayList <String> phones = new ArrayList<>(); // создается список для телефонов, есил будет вдруг одна фамилия и много номеров
        phoneAndName.putIfAbsent(lastName, phones); // записывается фамилию список,но только если такой фамилии не существует
        phoneAndName.get(lastName).add(phoneNumber); // получен ключ - фамилия, и добавлен с помощью метода лист.add телефонный номер
    }

    public void getPhoneNumber (String lastName){
        ArrayList <String> warningMessage = new ArrayList<>(); // создается дефолтное сообщение для метода getOrDefault()
        warningMessage.add("Данной фамилии нет в телефонном справочнике");
        System.out.println(lastName +": "+ phoneAndName.getOrDefault(lastName, warningMessage)); // метод getOrDefault() возвращает значение по ключу-фамилии, но если ее нет - выводится дефолтное сообщение
    }
}
