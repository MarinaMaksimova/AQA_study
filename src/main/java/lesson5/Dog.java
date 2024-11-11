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
class Dog extends Animal {
    static int dogCounter = 0;

    public Dog(String name) {          // конструктор класса Dog
        super(name, "Собака");
        dogCounter++;
    }

    public void printInfoDog() {           // метод вывода информации о собаке
        System.out.println("Имя собаки: " + name);
        System.out.println("Тип животного: " + animalType + "\n");
    }

    @Override
    public void run(int obstacleLength) {          // переопределенный метод бега для собак
        this.obstacleLength = obstacleLength;
        if (this.obstacleLength <= 500 && this.obstacleLength > 0) {
            System.out.println(getAnimalName() + " пробежал " + obstacleLength + " м.\n");
        } else if (this.obstacleLength < 0) {
            System.out.println("Пожалуйста, введите не отрицательную длину препятствия.\n");
        } else {
            System.out.println(getAnimalName() + " не может пробежать более 500 м.\n");
        }
    }

    @Override
    public void swim(int obstacleLength) {          // переопределенный метод плаванья для собак
        this.obstacleLength = obstacleLength;
        if (this.obstacleLength <= 10 && this.obstacleLength > 0) {
            System.out.println(getAnimalName() + " проплыл " + obstacleLength + " м.\n");
        } else if (this.obstacleLength < 0) {
            System.out.println("Пожалуйста, введите не отрицательную длину препятствия.\n");
        } else {
            System.out.println(getAnimalName() + " не может проплыть более 10 м.\n");
        }
    }

    public static void showDogCount() {            // метод подсчета собак
        System.out.println("Количество собак: " + dogCounter + "\n");
    }
}
