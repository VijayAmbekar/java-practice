package designs.stack;

import java.util.Objects;

public class LinkedListStack<T> {

    private class DataNode<T> {
        private T value;
        DataNode previous;

        DataNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }
    }

    DataNode top;

    public void push(T element) {
        if(Objects.isNull(top)) {
            top = createNode(element);
        } else {
            // top exist
            DataNode newTop = createNode(element);
            newTop.previous = top;
            top = newTop;
        }
    }

    private DataNode createNode(T value) {
        return new DataNode(value);
    }

    public T pop() {
        if(Objects.isNull(top)) {
            throw new UnsupportedOperationException("Stack is empty");
        } else {
            DataNode node = top;
            top = top.previous;
            return (T) node.getValue();
        }
    }

    public T peek ()
    {
        if(Objects.isNull(top)) {
            throw new UnsupportedOperationException("Stack is empty");
        } else {
            return (T) top.getValue();
        }
    }

    public boolean isEmpty() {
        return Objects.isNull(top);
    }


//    private final int CAPACITY;
//
//    T elements[];
//    private int top = -1;
//
//    public ArrayStack(int capacity) {
//        CAPACITY = capacity;
//        elements = (T[]) new Object[capacity];
//    }
//
//    public void push(T element) {
//        // check capacity is not exceeded
//        if( (top+1) >= getCapacity()) {
//            throw new RuntimeException("Capacity limit exceeded");
//        }
//
//        elements[++top] = element;
//    }
//
//    public T pop() {
//        //if stack not empty then only get element
//        if(top ==-1) {
//            throw new RuntimeException("Stack is already empty.");
//        }
//
//        return elements[top--];
//    }
//
//    public T peek ()
//    {
//        if(top ==-1) {
//            throw new RuntimeException("Stack is already empty.");
//        }
//
//        return elements[top];
//    }
//
//    public int getCapacity() {
//        return CAPACITY;
//    }
//
//    public boolean isEmpty() {
//        return top == -1;
//    }

}




