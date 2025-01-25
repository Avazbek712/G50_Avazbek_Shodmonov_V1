package task3;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by Avazbek on 26/12/24.
 */
public class Dictionary<K, V> {
    private Object[] elements;
    private int size;

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public Dictionary() {
        this(16);
    }

    public Dictionary(int capacity) {
        elements = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public void put(K newKey, V newValue) {
        int index = newKey.hashCode() % elements.length;
        Node node = (Node) elements[index];
        if (Objects.isNull(node)) {
            node = new Node(newKey, newValue);
            elements[index] = node;
            size++;
        }
        if (Objects.equals(node.key, newKey)) {
            node.value = newValue;
            return;
        }
        Node current = node.next;
        Node prev = node;
        while (Objects.nonNull(current)) {
            if (Objects.equals(current.key, newKey)) {
                current.value = newValue;
            }
            current = current.next;
            prev = prev.next;
        }
        prev.next = new Node(newKey, newValue);
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        int index = key.hashCode() % elements.length;
        Node node = (Node) elements[index];
        if (Objects.isNull(node)) {
            return null;
        }
        if (Objects.equals(node.key, key)) {
            return node.value;
        }
        Node current = node.next;
        while (Objects.nonNull(current)) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public V remove(K key) {
        int index = key.hashCode() % elements.length;
        Node node = (Node) elements[index];
        if (Objects.isNull(node)) {
            return null;
        }
        if (Objects.equals(node.key, key)) {
            V oldValue = node.value;
            elements[index] = node.next;
            size--;
            return oldValue;
        }
        Node current = node.next;
        Node prev = node;
        while (Objects.nonNull(current)) {
            if (Objects.equals(current.key, key)) {
                prev.next = current.next;
                return prev.value;
            }
            prev = prev.next;
            current = current.next;
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (Object o : elements) {
            if (Objects.nonNull(o)) {
                sj.add(o.toString());
            }
            Node current = (Node) o;
            while (Objects.nonNull(current)) {
                sj.add(current.toString());
                current = current.next;
            }
        }
        return sj.toString();
    }
}
