package lesson5;

public class Rectangle implements Figures {
    private double sideA, sideB;
    private String colorFill, colorBorder;

    public Rectangle(double sideA, double sideB, String colorFill, String colorBorder) {            // конструктор
        this.sideA = sideA;
        this.sideB = sideB;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    @Override
    public double calculatedPerimeter() {           // переопределение метода расчета периметра для прямоугольника
        return 2 * (sideA + sideB);
    }

    @Override
    public double calculatedSquare() {           // переопределение метода расчета площади для прямоугольника
        return sideA * sideB;
    }

    @Override
    public void showInfo() {            // переопределение метода вывода информации для прямоугольника
        System.out.println("Площадь прямоугольника: " + calculatedSquare());
        System.out.println("Периметр прямоугольника: " + calculatedPerimeter());
        System.out.println("Цвет фона прямоугольника: " + colorFill);
        System.out.println("Цвет границ прямоугольника: " + colorBorder + "\n");
    }
}
