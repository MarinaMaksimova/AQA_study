package lesson5;

public class Triangle implements Figures {
    public double base, sideRight, sideLeft, height;
    public String colorFill, colorBorder;

    public Triangle(double base, double sideLeft, double sideRight, String colorFill, String colorBorder) {         // конструктор
        this.base = base;
        this.sideLeft = sideLeft;
        this.sideRight = sideRight;
        this.height = (sideLeft * sideRight) / base;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    public double getBase() {           // получение стороны основания треугольника
        return base;
    }

    public double getSideLeft() {           // получение левой стороны треугольника
        return sideLeft;
    }

    public double getSideRight() {          // получение правой стороны треугольника
        return sideRight;
    }

    public double getHeight() {         // получение высоты треугольника
        return height;
    }

    @Override
    public void showInfo() {            // переопределение метода выводы информации для треугольника
        System.out.println("Площадь треугольника: " + calculatedSquare(base, height));
        System.out.println("Периметр треугольника: " + calculatedPerimeter(base, sideLeft, sideRight));
        System.out.println("Цвет фона треугольника: " + colorFill);
        System.out.println("Цвет границ треугольника: " + colorBorder + "\n");
    }
}
