public class Geometry {

    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double calculateArea(double length, double width) {
        return length * width;
    }

    public double calculateArea(double base, double height, boolean type) {
        return 0.5 * base * height;
    }
    public static void main(String[] args) {
        Geometry geo = new Geometry();

        double circleArea = geo.calculateArea(7.0);                       
        double rectangleArea = geo.calculateArea(5.0, 10.0);             
        double triangleArea = geo.calculateArea(6.0, 4.0, true);         

        System.out.println("Area of Circle: " + circleArea);
        System.out.println("Area of Rectangle: " + rectangleArea);
        System.out.println("Area of Triangle: " + triangleArea);
    }
}

