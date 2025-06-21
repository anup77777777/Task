abstract class Shape {
    String name;

    Shape(String name) {
        this.name = name;
    }

    abstract void resize(double factor);
    abstract void rotate(double angle);

    public void transform(double factor, double angle) {
        System.out.println("\nTransforming: " + name);
        resize(factor);
        rotate(angle);
    }
}

class Circle extends Shape {
    double radius;

    Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    void resize(double factor) {
        radius *= factor;
        System.out.println("Resized Circle to radius: " + radius);
    }

    @Override
    void rotate(double angle) {
        System.out.println("Circle rotation by " + angle + "° has no visual effect.");
    }
}

class Square extends Shape {
    double side;

    Square(String name, double side) {
        super(name);
        this.side = side;
    }

    @Override
    void resize(double factor) {
        side *= factor;
        System.out.println("Resized Square to side: " + side);
    }

    @Override
    void rotate(double angle) {
        System.out.println("Square rotated by " + angle + "°.");
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle(String name, double base, double height) {
        super(name);
        this.base = base;
        this.height = height;
    }

    @Override
    void resize(double factor) {
        base *= factor;
        height *= factor;
        System.out.println("Resized Triangle to base: " + base + " and height: " + height);
    }

    @Override
    void rotate(double angle) {
        System.out.println("Triangle rotated by " + angle + "°.");
    }
}
public class ShapeManipulationApp {
    public static void main(String[] args) {
        Shape circle = new Circle("My Circle", 5.0);
        Shape square = new Square("My Square", 4.0);
        Shape triangle = new Triangle("My Triangle", 6.0, 3.0);

        circle.transform(2.0, 90);     
        square.transform(1.5, 45);    
        triangle.transform(0.5, 30);   
    }
}

