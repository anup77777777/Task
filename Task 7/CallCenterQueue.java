import java.util.Scanner;

public class CallCenterQueue {
    private Call[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    private static class Call {
        String callerName;
        String phoneNumber;
        String issue;
        int priority;
        
        public Call(String callerName, String phoneNumber, String issue, int priority) {
            this.callerName = callerName;
            this.phoneNumber = phoneNumber;
            this.issue = issue;
            this.priority = priority;
        }
        
        @Override
        public String toString() {
            return callerName + " (" + phoneNumber + ") - " + issue + " [Priority: " + 
                   (priority == 1 ? "High" : priority == 2 ? "Medium" : "Low") + "]";
        }
    }
    
    public CallCenterQueue(int maxSize) {
        capacity = maxSize;
        queue = new Call[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public CallCenterQueue() {
        this(15);
    }
    
    public void addCall(String callerName, String phoneNumber, String issue, int priority) {
        if (isFull()) {
            System.out.println("Queue is full. Call from " + callerName + " cannot be added.");
            return;
        }
        Call newCall = new Call(callerName, phoneNumber, issue, priority);
        rear = (rear + 1) % capacity;
        queue[rear] = newCall;
        size++;
        System.out.println("Call from " + callerName + " added to the queue.");
    }
    
    public Call serveCall() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No calls to handle.");
            return null;
        }
        Call call = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Handling call from " + call.callerName + "...");
        System.out.println("Phone: " + call.phoneNumber);
        System.out.println("Issue: " + call.issue);
        System.out.println("Priority: " + (call.priority == 1 ? "High" : call.priority == 2 ? "Medium" : "Low"));
        System.out.println("Call has been handled successfully.");
        return call;
    }
    
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Call queue is empty.");
            return;
        }
        System.out.println("Current Call Queue:");
        System.out.println("Front -> ");
        int count = 0;
        int index = front;
        int position = 1;
        while (count < size) {
            System.out.println(position + ". " + queue[index]);
            index = (index + 1) % capacity;
            count++;
            position++;
        }
        System.out.println("<- Rear");
    }
    
    public void displayPendingCalls() {
        System.out.println("Number of pending calls: " + size);
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
        CallCenterQueue callCenterQueue = new CallCenterQueue(10);
        
        System.out.println("=== Call Center Queue Management System ===");
        
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add an incoming call to the queue");
            System.out.println("2. Serve and handle the next call");
            System.out.println("3. Display the current call queue");
            System.out.println("4. Display the number of pending calls");
            System.out.println("5. Exit the program");
            System.out.print("Enter your choice (1-5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter caller name: ");
                    String callerName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter issue description: ");
                    String issue = scanner.nextLine();
                    System.out.println("Select priority:");
                    System.out.println("1. High");
                    System.out.println("2. Medium");
                    System.out.println("3. Low");
                    System.out.print("Enter priority (1-3): ");
                    int priority = scanner.nextInt();
                    
                    if (priority >= 1 && priority <= 3) {
                        callCenterQueue.addCall(callerName, phoneNumber, issue, priority);
                    } else {
                        System.out.println("Invalid priority. Using Medium priority.");
                        callCenterQueue.addCall(callerName, phoneNumber, issue, 2);
                    }
                    break;
                    
                case 2:
                    callCenterQueue.serveCall();
                    break;
                    
                case 3:
                    callCenterQueue.displayQueue();
                    break;
                    
                case 4:
                    callCenterQueue.displayPendingCalls();
                    break;
                    
                case 5:
                    System.out.println("Thank you for using the Call Center Queue Management System!");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
} 