package Task9.task2;

import Task7.task3.Interfaces.IIndexable;
import Task8.DynamicArray;
import org.w3c.dom.Node;

import java.util.*;
import java.util.function.Consumer;

public class MyList<T> extends DynamicArray implements Iterator<T> {
    public MyList() {
        this(8);
    }

    public MyList(Object[] object) {
        super(object);
    }

    public MyList(int size) {
        this.array = new Object[size];
    }

    public MyList(List<T> list) {
        array = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        length = list.size();
    }

    private int current = 0;

    @Override
    public boolean hasNext() {
        return current < length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Больше нет элементов");
        }
        return (T) array[current++];
    }

    public int getCurrent() {
        return current;
    }
}
