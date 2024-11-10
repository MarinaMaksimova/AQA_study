package lesson4;

/*Создать класс Park с внутренним классом, с помощью объектов которого можно хранить
информацию об аттракционах, времени их работы и стоимости.*/

public class Park {

    private String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }           // конструктор класса Park

    public Attraction createAttraction(String attractionName, int workHoursFrom, int workHoursTo, int price) {          // Метод создания аттракциона
        return new Attraction(attractionName, workHoursFrom, workHoursTo, price);
    }

    public void printInfoOpen(Attraction attraction, int currentHour) {         // Метод для вывода информации о работе аттракциона
        if (attraction.isOpen(currentHour)) {
            System.out.println("Аттракцион \"" + attraction.getAttractionName() + "\" открыт.\n");
        } else {
            System.out.println("Аттракцион \"" + attraction.getAttractionName() + "\" закрыт.\n");
        }
    }

    public class Attraction {

        private String attractionName, locationPark;
        private int workHoursFrom, workHoursTo, price;

        public Attraction(String attractionName, int workHoursFrom, int workHoursTo, int price) {           // конструктор класса Attraction
            this.attractionName = attractionName;

            if (workHoursFrom > 0 && workHoursFrom <= 24) {
                this.workHoursFrom = workHoursFrom;
                this.workHoursTo = workHoursTo;
            } else {
                throw new ArithmeticException("Не верное время, укажите время в диапазоне от 0 до 24");
            }

            if (workHoursTo > workHoursFrom && (workHoursTo > 0 && workHoursTo <= 24)) {
                this.workHoursTo = workHoursTo;
            } else {
                throw new ArithmeticException("Не верное время, укажите время в диапазоне от 0 до 24. Также время окончания работы должно быть позже времени начала работы.");
            }

            this.price = price;
            locationPark = parkName;
        }

        public void printAttractionInfo() {         // метод для вывода информации об аттракционе
            System.out.println("Название аттракциона: " + attractionName);
            System.out.println("Название парка, в котором находится аттракцион: " + locationPark);
            System.out.println("Часы работы: c " + workHoursFrom + ":00 до " + workHoursTo + ":00");
            System.out.println("Стоимость: " + price + "\n");
        }

        public void setPrice(int price) {
            this.price = price;
        }           // метод для измениня стоимости аттракциона

        public String getAttractionName() {         // метод для получения названия аттракциона
            return attractionName;
        }

        public boolean isOpen(int currentHour) {            // метод для проверки времени работы аттракциона
            return (currentHour >= workHoursFrom && currentHour < workHoursTo);
        }

    }

}
