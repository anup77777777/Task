abstract class Shape {

    abstract double calculateArea();
    
    public void displayArea() {
        System.out.println("Area: " + calculateArea());
    }
}
class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}
public class ShapeAreaDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 8);

        System.out.print("Circle ");
        circle.displayArea();

        System.out.print("Rectangle ");
        rectangle.displayArea();

        System.out.print("Triangle ");
        triangle.displayArea();
    }
}
