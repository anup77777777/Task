class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public double calculateSalary() {
        return baseSalary;
    }
}
class Manager extends Employee {
    private double performanceBonus;

    public Manager(String name, double baseSalary, double performanceBonus) {
        super(name, baseSalary);
        this.performanceBonus = performanceBonus;
    }


    @Override
    public double calculateSalary() {
        return baseSalary + performanceBonus;
    }
}
public class PayrollSystem {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", 30000);
        Manager mgr = new Manager("Alice Smith", 50000, 10000);

        System.out.println("Employee Salary: " + emp.calculateSalary());
        System.out.println("Manager Salary: " + mgr.calculateSalary());
    }
}

