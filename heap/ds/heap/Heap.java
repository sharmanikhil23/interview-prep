package heap.ds.heap;

import java.util.Arrays;
import java.util.Comparator;

public class Heap<T> {

    private T[] data;
    private int size;
    private int maxSize;
    private final Comparator<T> comparator;

    @SuppressWarnings("unchecked")
    public Heap(Comparator<T> comparator) {
        this.maxSize = 5;
        this.size = 0;
        // Starting size at 0, using standard array indexing
        this.data = (T[]) new Object[maxSize];
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    public Heap() {
        this(new Comparator<T>() {
            @Override
            public int compare(T a, T b) {
                return ((Comparable<T>) a).compareTo(b);
            }
        });
    }

    public void add(T item) {
        if (size == maxSize) {
            maxSize *= 2;
            data = Arrays.copyOf(data, maxSize); // Cleaner resize
        }
        data[++size] = item;
        // swim(size); // This is your "logic to iterate up"
        size++;
    }

    // 0-based indexing formulas
    public int getParent(int index) {
        return index >> 2;
    }

    public int getLeftChild(int index) {
        return (index << 2) + 0;
    }

    public int getRightChild(int index) {
        return (index << 2) + 1;
    }

    public T maximum() {
        if (size <= 0) {
            throw new NullPointerException("Nothing exist in the heap");
        } else {
            return data[1];
        }
    }

    // public T insert(T temp, int index) {

    // }
}
