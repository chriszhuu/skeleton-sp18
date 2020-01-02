public class ArrayDeque<T> {
    private T[] items;
    private int capacity;
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        capacity = other.capacity;
        items = (T[]) new Object[capacity];
        first = other.first;
        last = other.last;
        size = other.size;
        System.arraycopy(other.items, 0, items, 0, size);
    }


    private void checkUpsize() {
        if (size == capacity) {
            capacity = capacity * 2;
            T[] expanded = (T[]) new Object[capacity];
            System.arraycopy(items, first, expanded, first, size - first);
            if (last <= first) {
                System.arraycopy(items, 0, expanded, size, last + 1);
                last += size;
            }
            items = expanded;
        }
    }

    private void checkDownsize() {
        if (size < capacity / 4 && capacity > 8) {
            int oldCapacity = capacity;
            capacity = capacity / 2;
            T[] shrunken = (T[]) new Object[capacity];
            if (first < last) {
                System.arraycopy(items, first, shrunken, 0, size);
            } else {
                System.arraycopy(items, first, shrunken, 0, oldCapacity - first);
                System.arraycopy(items, 0, shrunken, oldCapacity - first, last + 1);
            }
            items = shrunken;
            first = 0;
            last = size - 1;
        }
    }

    public void addFirst(T item) {
        if (size!=0) {
            first = (first - 1 + capacity) % capacity;
        }
        items[first] = item;
        size ++;
        checkUpsize();
    }

    public void addLast(T item) {
        if (size != 0) {
            last = (last + 1) % capacity;
        }
        items[last] = item;
        size ++;
        checkUpsize();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i ++) {
            System.out.print(items[(first + i) % capacity] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) return null;
        T ret = items[first];
        if (first != last) {
            first = (first + 1) % capacity;
        }
        size --;
        checkDownsize();
        return ret;
    }

    public T removeLast() {
        if (size == 0) return null;
        T ret = items[last];
        if (last!=first) {
            last = (last - 1 + capacity) % capacity;
        }
        size --;
        checkDownsize();
        return ret;
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return items[(first + index) % capacity];
    }

}
