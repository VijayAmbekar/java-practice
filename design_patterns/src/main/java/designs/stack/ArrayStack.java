package designs.stack;

public class ArrayStack<T> {
    private final int CAPACITY;

    T elements[];
    private int top = -1;

    public ArrayStack(int capacity) {
        CAPACITY = capacity;
        elements = (T[]) new Object[capacity];
    }

    public void push(T element) {
        // check capacity is not exceeded
        if( (top+1) >= getCapacity()) {
            throw new RuntimeException("Capacity limit exceeded");
        }

        elements[++top] = element;
    }

    public T pop() {
      //if stack not empty then only get element
        if(top ==-1) {
            throw new RuntimeException("Stack is already empty.");
        }

        return elements[top--];
    }

    public T peek ()
    {
        if(top ==-1) {
            throw new RuntimeException("Stack is already empty.");
        }

        return elements[top];
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
