package lesson5;

public class Main {
    public static void main(String[] args) {
//        Animal pig = new Animal("Свин", "Хрюшка");
//        pig.run(10);
//        pig.swim(5,);
//        pig.printInfoAnimal();
//        Animal frog = new Animal("Фрогги", "Лягушка");
//        frog.printInfoAnimal();

        Cat cat1 = new Cat("Мурка", "Черный");
        Cat cat2 = new Cat("Пушка", "белый");

        // Создание массива котов
        Cat[] cats = new Cat[2];
        cats[0] = cat1;
        cats[1] = cat2;
        Cat.fillPlate(10);
        // Кормление котов
        for (Cat cat : cats) {
            cat.feedCat(4); // Кормим каждого кота по 4 единицы корма
        }
        // Вывод информации о сытости всех котов
        for (Cat cat : cats) {
            cat.printInfoCat();
        }

//        cat.run(191);
//        cat.swim(2);

//        Dog dog = new Dog("Бобик");
//        dog.printInfoDog();
//        dog.run(371);
//        dog.swim(12);
//
//        Animal.showAnimalCount();
//        Cat.showCatCount();
//        Dog.showDogCount();
    }
}
