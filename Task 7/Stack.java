public class Stack {
    private int[] array;
    private int top;
    private int capacity;
    
    public Stack(int size) {
        capacity = size;
        array = new int[capacity];
        top = -1;
    }
    
    public Stack() {
        this(10);
    }
    
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + element);
            return;
        }
        array[++top] = element;
        System.out.println(element + " pushed to stack");
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        int element = array[top--];
        System.out.println(element + " popped from stack");
        return element;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return array[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
    
    private boolean isFull() {
        return top == capacity - 1;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        
        System.out.println("=== Stack Implementation Test ===");
        
        System.out.println("\n1. Testing push operations:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        
        System.out.println("\n2. Current stack:");
        stack.display();
        
        System.out.println("\n3. Testing peek operation:");
        System.out.println("Top element: " + stack.peek());
        
        System.out.println("\n4. Testing size operation:");
        System.out.println("Stack size: " + stack.size());
        
        System.out.println("\n5. Testing pop operations:");
        stack.pop();
        stack.pop();
        stack.pop();
        
        System.out.println("\n6. Stack after popping:");
        stack.display();
        
        System.out.println("\n7. Testing isEmpty operation:");
        System.out.println("Is stack empty? " + stack.isEmpty());
        
        System.out.println("\n8. Popping remaining elements:");
        stack.pop();
        stack.pop();
        stack.pop();
        
        System.out.println("\n9. Testing isEmpty after emptying:");
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
} 