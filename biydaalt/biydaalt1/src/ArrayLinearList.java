public class ArrayLinearList<T> implements LinearList<T> {
    protected Object[] element;
    protected int size;

    public ArrayLinearList() {
        this.element = new Object[10];
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        return (T) element[index];
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++)
            if (this.element[i].equals(element))
                return i;
        return -1;
    }

    @Override
    public void add(int index, T element) {
        if (size == this.element.length)
            enlarge();
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        for (int i = size - 1; i >= index; i--)
            this.element[i + 1] = this.element[i];
        this.element[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        T removedElement = (T) element[index];
        for (int i = index; i < size - 1; i++)
            element[i] = element[i + 1];
        element[--size] = null;
        return removedElement;
    }

    private void enlarge() {
        Object[] newArray = new Object[element.length * 2];
        System.arraycopy(element, 0, newArray, 0, size);
        element = newArray;
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++)
            System.out.println(element[i]);
    }
}