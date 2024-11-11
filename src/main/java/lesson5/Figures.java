package lesson5;

/*Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольник.
  Задать для каждой фигуры цвет заливки и цвет границы.
  Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль.
  Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве дефолтных методов в интерфейсе.*/
public interface Figures {
    default double calculatedSquare(double... sides) {          // дефолтный метод вычисления площади
        if (this instanceof Triangle) {
            return 0.5 * ((Triangle) this).getBase() * ((Triangle) this).getHeight();
        } else if (this instanceof Circle) {
            return Math.PI * Math.pow(((Circle) this).getRadius(), 2);
        } else if (this instanceof Rectangle) {
            return ((Rectangle) this).getSideA() * ((Rectangle) this).getSideB();
        }
        return 0;
    }

    default double calculatedPerimeter(double... sides) {           // дефолтный метод вычисления периметра
        if (this instanceof Triangle) {
            return ((Triangle) this).getBase() + ((Triangle) this).getSideLeft() + ((Triangle) this).getSideRight();
        } else if (this instanceof Circle) {
            return 2 * ((Circle) this).getRadius() * Math.PI;
        } else if (this instanceof Rectangle) {
            return (2 * ((Rectangle) this).getSideA()) + (2 * ((Rectangle) this).getSideB());
        }
        return 0;
    }

    void showInfo();            // метод вывода информации
}
