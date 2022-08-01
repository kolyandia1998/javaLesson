package Task8;

public class DynamicArray<T> {
    public DynamicArray() {
        this.array = new Object[8];
    }

    private Object[] array;
    public int length = 0;

    public DynamicArray(int size) {
        this.array = new Object[size];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= getRealSize()) {
            throw new ArrayIndexOutOfBoundsException("Индекс не входит в границы массива");
        }
    }

    public DynamicArray(T[] object) {
        array = object;
    }

    public int getRealSize() {
        return array.length;
    }

    private boolean isEndOfArray() {
        return length == array.length;
    }

    public void add(T item) {
        if (isEndOfArray()) {
            resize();
        }
        array[length] = item;
        length++;
    }

    public T get(int index) throws Exception {
        rangeCheck(index);
        return (T) array[index];
    }

    public void set(int index, T item) throws Exception {
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

    public boolean RemoveItem(T item) {

        int index = getIndex(item);
        if (index == -1) {
            return false;
        }
        return Remove(index);

    }


    public boolean Remove(int index) {
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

    public void Insert(T item, int Index) throws Exception {
        if (Index > array.length || Index < 0) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }

        if (isEndOfArray()) {
            resize();
        }

        for (int i = length; i > Index; i--) {
            array[i] = array[i - 1];
        }
        array[Index] = item;
        length++;
    }

    public void AddRange(T[] arrayForAdd) {
        int freeCell = (array.length - length);
        if (freeCell < arrayForAdd.length) {
            Object[] intermediateArray = new Object[array.length + arrayForAdd.length - freeCell];
            for (int i = 0; i < array.length; i++) {
                intermediateArray[i] = array[i];

            }
            for (int i = 0; i < arrayForAdd.length; i++) {
                intermediateArray[i + array.length] = arrayForAdd[i];
            }
            array = intermediateArray;
            length = array.length;
        } else {
            for (int i = 0; i < arrayForAdd.length; i++) {
                add(arrayForAdd[i]);
            }
        }
    }

    public int size() {
        return length;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}