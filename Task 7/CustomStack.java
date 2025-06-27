public class CustomStack {
    private int[] stackArray;
    private int top;
    private int maxSize;
    
    public CustomStack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }
    
    public CustomStack() {
        this(10);
    }
    
    public void push(int val) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + val);
            return;
        }
        stackArray[++top] = val;
        System.out.println(val + " pushed to custom stack");
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        int element = stackArray[top--];
        System.out.println(element + " popped from custom stack");
        return element;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return stackArray[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == maxSize - 1;
    }
    
    public int size() {
        return top + 1;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Custom Stack is empty");
            return;
        }
        System.out.print("Custom Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(4);
        
        System.out.println("=== Custom Stack Implementation Test ===");
        
        System.out.println("\n1. Testing push operations:");
        customStack.push(100);
        customStack.push(200);
        customStack.push(300);
        customStack.push(400);
        customStack.push(500);
        
        System.out.println("\n2. Current custom stack:");
        customStack.display();
        
        System.out.println("\n3. Testing isFull operation:");
        System.out.println("Is custom stack full? " + customStack.isFull());
        
        System.out.println("\n4. Testing peek operation:");
        System.out.println("Top element: " + customStack.peek());
        
        System.out.println("\n5. Testing size operation:");
        System.out.println("Custom stack size: " + customStack.size());
        
        System.out.println("\n6. Testing pop operations:");
        customStack.pop();
        customStack.pop();
        
        System.out.println("\n7. Custom stack after popping:");
        customStack.display();
        
        System.out.println("\n8. Testing isEmpty operation:");
        System.out.println("Is custom stack empty? " + customStack.isEmpty());
        
        System.out.println("\n9. Testing isFull after popping:");
        System.out.println("Is custom stack full? " + customStack.isFull());
        
        System.out.println("\n10. Popping remaining elements:");
        customStack.pop();
        customStack.pop();
        customStack.pop();
        
        System.out.println("\n11. Testing isEmpty after emptying:");
        System.out.println("Is custom stack empty? " + customStack.isEmpty());
    }
} 