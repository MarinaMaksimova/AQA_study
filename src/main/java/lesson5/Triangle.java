package lesson5;

public class Triangle implements Figures {
    private double base, sideRight, sideLeft, height;
    private String colorFill, colorBorder;

    public Triangle(double base, double sideLeft, double sideRight, String colorFill, String colorBorder) {         // конструктор
        this.base = base;
        this.sideLeft = sideLeft;
        this.sideRight = sideRight;
        this.height = (sideLeft * sideRight) / base;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    @Override
    public double calculatedPerimeter() {           // переопределение метода расчета периметра для треугольника
        return base + sideLeft + sideRight;
    }

    @Override
    public double calculatedSquare() {           // переопределение метода расчета площади для треугольника
        return 0.5 * base * height;
    }

    @Override
    public void showInfo() {            // переопределение метода вывода информации для треугольника
        System.out.println("Площадь треугольника: " + calculatedSquare());
        System.out.println("Периметр треугольника: " + calculatedPerimeter());
        System.out.println("Цвет фона треугольника: " + colorFill);
        System.out.println("Цвет границ треугольника: " + colorBorder + "\n");
    }
}
