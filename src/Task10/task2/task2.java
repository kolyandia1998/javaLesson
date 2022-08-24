package Task10.task2;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class task2 {
    public static void main(String[] args) {
        Office office = new Office(System.out::println);
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Jhon"));
        people.add(new Person("Bill"));
        people.add(new Person("Sam"));

        for (Person p : people) {
            p.addListener(office);
        }

        people.get(0).coming();
        people.get(1).coming();
        people.get(2).coming();
        people.get(0).going();

    }
}
