public class DynamicArray<T> {
    private Object[] array;
    private int size;
    private int capacity;

    // Constructor to initialize the dynamic array with a default capacity
    public DynamicArray() {
        capacity = 10; // Default capacity
        array = new Object[capacity];
        size = 0;
    }

    // Method to add an element to the dynamic array
    public void add(T element) {
        // Check if the array is full, resize if needed
        if (size == capacity) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    // Method to remove an element from the dynamic array
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    // Method to get an element at a specific index
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return (T) array[index];
    }

    // Method to get the size of the dynamic array
    public int size() {
        return size;
    }

    // Method to increase the capacity of the dynamic array
    private void increaseCapacity() {
        capacity *= 2; // Double the capacity
        Object[] newArray = new Object[capacity];
        // Copy elements to the new array
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("Hello");
        dynamicArray.add("World");
        dynamicArray.add("!");

        System.out.println("Elements in dynamic array:");
        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.println(dynamicArray.get(i));
        }

        dynamicArray.remove(1);

        System.out.println("Elements in dynamic array after removal:");
        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.println(dynamicArray.get(i));
        }
    }
}