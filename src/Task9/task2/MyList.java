package Task9.task2;

import Task7.task3.Interfaces.IIndexable;
import Task7.task3.List;
import Task8.DynamicArray;
import org.w3c.dom.Node;

import javax.swing.*;
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

    public MyList(Iterable<T> iterable) {
         ArrayList<T> arrayList = new ArrayList<>();
         while (iterable.iterator().hasNext()) {
             arrayList.add(iterable.iterator().next());
         }
        array = arrayList.toArray();
        length = arrayList.size();
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
