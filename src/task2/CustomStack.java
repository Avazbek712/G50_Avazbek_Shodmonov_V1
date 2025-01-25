package task2;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by Avazbek on 26/12/24.
 */
public class CustomStack<V> {
    private Object[] stack;
    private int size;

    public CustomStack() {
        this(10);
    }

    public CustomStack(int capacity) {
        this.stack = new Object[capacity];
    }

    public void push(V value) {
        if (Objects.isNull(value)) {
            throw new NullPointerException("Cannot push a null value");
        }
        if (size == stack.length) {
            Object[] newStack = new Object[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public void pop() {
        if (size == 0) {
            return;
        }
        --size;
    }

    @SuppressWarnings("unchecked")
    public V peek() {
        if (size == 0) {
            return null;
        }
        return (V) stack[size - 1];
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(stack[i].toString());
        }
        return joiner.toString();
    }
}
