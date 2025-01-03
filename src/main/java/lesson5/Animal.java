package lesson5;

/*Создать классы Собака и Кот с наследованием от класса Животное.
Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина
препятствия. Результатом выполнения действия будет печать в консоль. (Например,
dogBobik.run(150); → 'Бобик пробежал 150 м.");
У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не
умеет плавать, собака 10 м.).
Добавить подсчет созданных котов, собак и животных.
Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:
• Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
• Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
удалось покушать (хватило еды), сытость = true.
• Считаем, что если коту мало еды в миске, то он ее просто не трогает, то есть не может быть
наполовину сыт (это сделано для упрощения логики программы).
• Создать массив котов и миску с едой, попросить всех котов покушать из этой миски и потом
вывести информацию о сытости котов в консоль.
• Добавить метод, с помощью которого можно было бы добавлять еду в миску.*/
public class Animal {

    String name, animalType;
    int obstacleLength;
    static int animalCounter = 0;

    public Animal(String name, String animalType) {            // Animal конструктор
        this.name = name;
        this.animalType = animalType;
        animalCounter++;
    }

    public static void showAnimalCount() {         // подсчет количества животных
        System.out.println("Количество животных: " + animalCounter + "\n");
    }

    public String getAnimalName() {         // получение имени животного
        return name;
    }

    public void run(int obstacleLength) {           // метод бега животного
        this.obstacleLength = obstacleLength;
        System.out.println(getAnimalName() + " пробежал " + obstacleLength + " м.\n");
    }

    public void swim(int obstacleLength) {          // метод плаванья животного
        this.obstacleLength = obstacleLength;
        System.out.println(getAnimalName() + " проплыл " + obstacleLength + " м.\n");
    }

    public void printInfoAnimal() {            // метод печати информации о животном
        System.out.println("Имя животного: " + name);
        System.out.println("Тип животного: " + animalType + "\n");
    }

}