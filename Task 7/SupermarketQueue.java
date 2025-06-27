import java.util.Scanner;

public class SupermarketQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public SupermarketQueue(int maxSize) {
        capacity = maxSize;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public SupermarketQueue() {
        this(20);
    }
    
    public void addCustomer(String customerName) {
        if (isFull()) {
            System.out.println("Queue is full. Customer " + customerName + " cannot be added.");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = customerName;
        size++;
        System.out.println("Customer " + customerName + " added to the queue.");
    }
    
    public String serveCustomer() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No customers to serve.");
            return null;
        }
        String customer = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Customer " + customer + " has been served.");
        return customer;
    }
    
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Current Queue:");
        System.out.println("Front -> ");
        int count = 0;
        int index = front;
        while (count < size) {
            System.out.print(queue[index] + " ");
            index = (index + 1) % capacity;
            count++;
        }
        System.out.println("<- Rear");
    }
    
    public void displayQueueSize() {
        System.out.println("Number of customers in queue: " + size);
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public int getSize() {
        return size;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SupermarketQueue supermarketQueue = new SupermarketQueue(10);
        
        System.out.println("=== Supermarket Queue Management System ===");
        
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a customer to the queue");
            System.out.println("2. Serve the next customer");
            System.out.println("3. Display the current queue");
            System.out.println("4. Display the number of customers in the queue");
            System.out.println("5. Exit the program");
            System.out.print("Enter your choice (1-5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    supermarketQueue.addCustomer(customerName);
                    break;
                    
                case 2:
                    supermarketQueue.serveCustomer();
                    break;
                    
                case 3:
                    supermarketQueue.displayQueue();
                    break;
                    
                case 4:
                    supermarketQueue.displayQueueSize();
                    break;
                    
                case 5:
                    System.out.println("Thank you for using the Supermarket Queue Management System!");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
} 