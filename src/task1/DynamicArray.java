package task1;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by Avazbek on 26/12/24.
 */
public class DynamicArray<T> {
    private Object[] array;
    private int size;

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        array = new Object[capacity];
    }


    public void add(T value) {
        if (Objects.isNull(value)) {
            throw new NullPointerException("Cannot add a null value");
        }
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (Objects.isNull(array[index])) {
            throw new NullPointerException("Cannot get a null value");
        }
        return (T) array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }
    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            sj.add(Objects.toString(array[i]));
        }
        return sj.toString();
    }
}
