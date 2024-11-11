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
class Cat extends Animal {
    String colorCat;
    static int catCounter = 0;
    static int plate = 0;
    boolean isNotHungry = false;
    int foodAmount;

    public Cat(String name, String color) {            // конструктор класса Cat
        super(name, "Кот"); // Вызов конструктора родительского класса
        this.colorCat = color;
        catCounter++;
    }

    public void printInfoCat() {           // вывод информации о коте
        System.out.println("Имя кота: " + name);
        System.out.println("Тип животного: " + animalType);
        System.out.println("Сыт ли кот: " + isNotHungry);
        System.out.println("Цвет кота: " + colorCat + "\n");
    }

    public void feedCat(int foodAmount) {          // метод кормления кота
        this.foodAmount = foodAmount;
        if (!isNotHungry) {
            if (plate < this.foodAmount) {
                System.out.println("Коту " + getAnimalName() + " не хватает корма.\n");
            } else {
                plate -= this.foodAmount;
                isNotHungry = true;
                System.out.println("Кот " + getAnimalName() + " поел.\n");
            }
        } else {
            System.out.println("Кот не голоден.\n");
        }
    }

    public static void fillPlate(int plateRefill) {          // метод наполнения миски
        plate += plateRefill;
    }


    @Override
    public void run(int obstacleLength) {          // переопределенный метод бега для котов
        this.obstacleLength = obstacleLength;
        if (this.obstacleLength <= 200 && this.obstacleLength > 0) {
            System.out.println(getAnimalName() + " пробежал " + obstacleLength + " м.\n");
        } else if (this.obstacleLength < 0) {
            System.out.println("Пожалуйста, введите не отрицательную длину препятствия.\n");
        } else {
            System.out.println(getAnimalName() + " не может пробежать более 200 м.\n");
        }
    }

    @Override
    public void swim(int obstacleLength) {          // переопределенный метод плаванья для котов
        this.obstacleLength = obstacleLength;
        System.out.println("Коты не умеют плавать.\n");
    }

    public static void showCatCount() {            // метод подсчета всех котов
        System.out.println("Количество котов: " + catCounter + "\n");
    }
}