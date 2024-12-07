package lesson5;

public class Circle implements Figures {
    private double radius;
    private String colorFill, colorBorder;

    public Circle(double radius, String colorFill, String colorBorder) {            // конструктор
        this.radius = radius;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    @Override
    public double calculatedPerimeter() {           // переопределение метода расчета периметра для круга
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculatedSquare() {           // переопределение метода расчета площади для круга
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void showInfo() {            // переопределение метода вывода информации для круга
        System.out.println("Площадь круга: " + calculatedSquare());
        System.out.println("Периметр круга: " + calculatedPerimeter());
        System.out.println("Цвет фона круга: " + colorFill);
        System.out.println("Цвет границ круга: " + colorBorder + "\n");
    }
}
