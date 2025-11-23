public class Chain<T> implements LinearList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private int size;

    public Chain() {
        first = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> current = first;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.data;
    }

    @Override
    public int indexOf(T element) {
        Node<T> current = first;
        int index = 0;
        while (current != null) {
            if (current.data.equals(element))
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<T> prev = first;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> removed;
        if (index == 0) {
            removed = first;
            first = first.next;
        } else {
            Node<T> prev = first;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            removed = prev.next;
            prev.next = removed.next;
        }
        size--;
        return removed.data;
    }

    @Override
    public void display() {
        Node<T> current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}