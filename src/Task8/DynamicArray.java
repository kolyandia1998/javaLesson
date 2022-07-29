package Task8;

public class DynamicArray<T> {

    private final int initSize = 8;

    private Object[] array = new Object[initSize];

    public int countElements = 0;

    public DynamicArray(int size) {
        array = new Object[size];
    }

    public DynamicArray(T[] object) {
        array = object;
    }

    public int getRealSize() {
        return array.length;
    }


    private boolean isEnd() {
        return countElements == array.length;
    }


    public void add(T item) {
        if (isEnd()) {
            resize();
            array[countElements++] = item;

        } else {
            array[countElements] = item;
            countElements++;
        }
    }

    public T get(int index) {
        return (T) array[index];
    }

    public Boolean Remove(int index) {

        if (index < 0 || index > countElements) {
            return false;
        }
        for (int i = index; i < countElements; i++) {
            array[i] = array[i + 1];
        }
        array[countElements] = null;
        countElements--;
        return true;
    }
    public void AddRange(T[] arrayForAdd) {
        int freeCell = (array.length - countElements);
        if (freeCell < arrayForAdd.length) {
            Object[] intermediateArray = new Object[array.length + arrayForAdd.length - freeCell];
            for (int i = 0; i < array.length; i++) {
                intermediateArray[i] = array[i];

            }
            for (int i = 0; i < arrayForAdd.length; i++) {
                intermediateArray[i + array.length] = arrayForAdd[i];
            }
            array = intermediateArray;
            countElements = array.length;
        } else {
            for (int i = 0; i < arrayForAdd.length; i++) {
                add(arrayForAdd[i]);

            }
        }
    }
    public int size() {
        return countElements;
    }
    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}