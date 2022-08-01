package Task8;

public class DynamicArray<T> {
    public DynamicArray() {
        this(8);
    }

    private Object[] array;
    private int length = 0;

    public DynamicArray(int size) {
        this.array = new Object[size];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс не входит в границы массива");
        }
    }

    public DynamicArray(T[] object) {
        array = object;
    }

    private boolean isEndOfArray() {
        return length == array.length;
    }

    public void add(T item) {
        if (isEndOfArray()) {
            resize(2);
        }
        array[length] = item;
        length++;
    }

    public int size() {
        return length;
    }

    public T get(int index) throws Exception {
        rangeCheck(index);
        return (T) array[index];
    }

    public void Set(int index, T item) throws Exception {
        rangeCheck(index);
        array[index] = index;
    }

    private int getIndex(T item) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (item == array[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean remove(T item) {

        int index = getIndex(item);
        if (index == -1) {
            return false;
        }
        return remove(index);

    }

    public boolean remove(int index) {
        try {
            rangeCheck(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        for (int i = index; i < length; i++) {
            array[i] = array[i + 1];
        }
        array[length] = null;
        length--;
        return true;
    }

    public void insert(T item, int Index) throws Exception {
        if (Index > array.length || Index < 0) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }

        if (isEndOfArray()) {
            resize(2);
        }

        for (int i = length; i > Index; i--) {
            array[i] = array[i - 1];
        }
        array[Index] = item;
        length++;
    }

    public void addRange(T[] arrayForAdd) {
        int freeSpace = (array.length - length);
        if (freeSpace < arrayForAdd.length) {
            resize(size() + arrayForAdd.length);
        }
        for (int i = 0; i < arrayForAdd.length; i++) {
            array[i + array.length] = arrayForAdd[i];
        }
        length = array.length;
    }


    private void resize(int factor) {
        Object[] newArray = new Object[array.length * factor];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}