package Task10.task2;

import java.util.ArrayList;
import java.util.Date;

public class Person {




    public Person(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ArrayList<ISomeAction> listeners = new ArrayList<ISomeAction>();

    public void addListener(ISomeAction toAdd) {
        listeners.add(toAdd);
    }

    public void coming() {
        for (ISomeAction hl : listeners)
            hl.greet(new Date(), this.getName(), this);
    }

    public void going() {
        for (ISomeAction hl : listeners)
            hl.gone(this.getName(), this);
    }
}


