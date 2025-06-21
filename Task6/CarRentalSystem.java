abstract class Vehicle {
    String vehicleName;

    Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    abstract double calculateRentalCost(int hours);

    public void displayRentalCost(int hours) {
        double cost = calculateRentalCost(hours);
        System.out.println(vehicleName + " rental for " + hours + " hours: Rs. " + cost);
    }
}

class Car extends Vehicle {
    double ratePerHour = 500;

    Car(String name) {
        super(name);
    }

    @Override
    double calculateRentalCost(int hours) {
        return hours * ratePerHour;
    }
}
class Motorcycle extends Vehicle {
    double ratePerHour = 200;

    Motorcycle(String name) {
        super(name);
    }

    @Override
    double calculateRentalCost(int hours) {
        return hours * ratePerHour;
    }
}

class Bicycle extends Vehicle {
    double ratePerHour = 50;

    Bicycle(String name) {
        super(name);
    }

    @Override
    double calculateRentalCost(int hours) {
        return hours * ratePerHour;
    }
}
public class CarRentalSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota Corolla");
        Vehicle motorcycle = new Motorcycle("Yamaha FZ");
        Vehicle bicycle = new Bicycle("Hero Cycle");

        car.displayRentalCost(4);
        motorcycle.displayRentalCost(4);
        bicycle.displayRentalCost(4);
    }
}

