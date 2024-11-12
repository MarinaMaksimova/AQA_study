package lesson4;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Иванова", "Алина", "Младший сотрудник", "ivanov@mail.com", 375299653467L, 1450, 29);

        /*Создать массив из 5 сотрудников.
        Пример:
        // вначале объявляем массив объектов
        Personil persArray = new Person [51:
        // потом для каждой ячейки массива задаем объект
        persArray [0] = new Person ("Ivanov Ivan", "Engineer",
        "ivivan@ma1lbox.com", "892312312", 30000, 30) ;
        persArray [1] = new Person (...) ;
        persArray [4] = new Person (...) :*/
        Employee[] arrayEmployees = new Employee[5];
        arrayEmployees[0] = employee1;
        arrayEmployees[1] = new Employee("Бургаков", "Борис", "Старший сотрудник", "burgakov@mail.com", 375299872367L, 2300, 31);
        arrayEmployees[2] = new Employee("Исакиев", "Геннадий", "Менеджер", "isakiev@mail.com", 375336772347L, 2550, 30);
        arrayEmployees[3] = new Employee("Капустина", "Инесса", "Бухгалтер", "kapustka333@mail.com", 375299183367L, 2600, 27);
        arrayEmployees[4] = new Employee("Павлов", "Павел", "Младший директор", "pavlov@mail.com", 375299492667L, 3300, 45);

        for (int i = 0; i < arrayEmployees.length; i++) {
            arrayEmployees[i].printEmployeeInfo();
        }


        // Вызов класса Park и методов
        Park park = new Park("1 МАЯ");

        Park.Attraction attraction1 = park.createAttraction("Машинки", 10, 15, 15);
        Park.Attraction attraction2 = park.createAttraction("Колесо обозрения", 15, 21, 10);

        attraction1.printAttractionInfo();
        attraction1.setPrice(20);
        attraction1.printAttractionInfo();
        park.printInfoOpen(attraction1, 7);

        attraction2.printAttractionInfo();
        park.printInfoOpen(attraction2, 16);
    }
}