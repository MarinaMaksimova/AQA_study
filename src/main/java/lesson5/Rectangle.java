package lesson5;

public class Rectangle implements Figures {
    public double sideA, sideB;
    public String colorFill, colorBorder;

    public Rectangle(double sideA, double sideB, String colorFill, String colorBorder) {            // конструктор
        this.sideA = sideA;
        this.sideB = sideB;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    public double getSideA() {          // получение первой стороны прямоугольника
        return sideA;
    }

    public double getSideB() {          // получение второй стороны прямоугольника
        return sideB;
    }

    @Override
    public void showInfo() {            // переопределение метода выводы информации для прямоугольника
        System.out.println("Площадь прямоугольника: " + calculatedSquare(sideA, sideB));
        System.out.println("Периметр прямоугольника: " + calculatedPerimeter(sideA, sideB));
        System.out.println("Цвет фона прямоугольника: " + colorFill);
        System.out.println("Цвет границ прямоугольника: " + colorBorder + "\n");
    }
}
