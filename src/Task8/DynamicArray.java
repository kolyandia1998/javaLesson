package Task8;

import Task7.task3.Interfaces.IIndexable;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicArray<T>   {
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
        resizeIfNeed(array.length * 2);
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

    public boolean remove(T item) {
        int index = getIndex(item);
        if (index == -1) {
            return false;
        }
        return remove(index);
    }

    public void resizeIfNeed(int length) {
        if (isEndOfArray())
            resize(length);
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

        resizeIfNeed(array.length * 2);

        for (int i = length; i > Index; i--) {
            array[i] = array[i - 1];
        }
        array[Index] = item;
        length++;
    }

    public void addRange(T[] arrayForAdd) {
        if ((arrayForAdd.length + length) > array.length) {
            resize(arrayForAdd.length + length);
        }
        for (int i = 0; i < arrayForAdd.length; i++) {
            add(arrayForAdd[i]);
        }
    }

    private void resize(int newSize) {

        Object[] newArray = new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }





}