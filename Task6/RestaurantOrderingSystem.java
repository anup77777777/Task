abstract class MenuItem {
    String name;

    MenuItem(String name) {
        this.name = name;
    }

    abstract void prepare();
    abstract void serve();

    public void processOrder() {
        System.out.println("\nOrdering: " + name);
        prepare();
        serve();
    }
}
class Appetizer extends MenuItem {
    Appetizer(String name) {
        super(name);
    }

    @Override
    void prepare() {
        System.out.println("Preparing appetizer: chopping and seasoning...");
    }

    @Override
    void serve() {
        System.out.println("Serving appetizer with a dipping sauce.");
    }
}

class MainCourse extends MenuItem {
    MainCourse(String name) {
        super(name);
    }

    @Override
    void prepare() {
        System.out.println("Preparing main course: cooking meat and sides...");
    }

    @Override
    void serve() {
        System.out.println("Serving main course hot with garnish.");
    }
}

class Beverage extends MenuItem {
    Beverage(String name) {
        super(name);
    }

    @Override
    void prepare() {
        System.out.println("Preparing beverage: mixing or brewing...");
    }

    @Override
    void serve() {
        System.out.println("Serving beverage chilled or hot with a straw or cup.");
    }
}
public class RestaurantOrderingSystem {
    public static void main(String[] args) {

        MenuItem appetizer = new Appetizer("Spring Rolls");
        MenuItem mainCourse = new MainCourse("Grilled Chicken");
        MenuItem beverage = new Beverage("Iced Tea");

        appetizer.processOrder();
        mainCourse.processOrder();
        beverage.processOrder();
    }
}

