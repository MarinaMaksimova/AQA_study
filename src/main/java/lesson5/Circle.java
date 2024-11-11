package lesson5;

public class Circle implements Figures {
    public double radius;
    public String colorFill, colorBorder;

    public Circle(double radius, String colorFill, String colorBorder) {            // конструктор
        this.radius = radius;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    public double getRadius() {         // получение радиуса круга
        return radius;
    }

    @Override
    public void showInfo() {            // переопределение метода выводы информации для круга
        System.out.println("Площадь круга: " + calculatedSquare(radius));
        System.out.println("Периметр круга: " + calculatedPerimeter(radius));
        System.out.println("Цвет фона круга: " + colorFill);
        System.out.println("Цвет границ круга: " + colorBorder + "\n");
    }
}
