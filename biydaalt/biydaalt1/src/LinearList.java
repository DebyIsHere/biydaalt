public interface LinearList<T> {
    boolean isEmpty();
    int size();
    T get(int index);
    int indexOf(T element);
    void add(int index, T element);
    T remove(int index);
    void display();
}
