package Task10.task2;

import java.sql.Time;
import java.util.Date;

public class task2 {
    public static void main(String[] args) {
        Date date = new Date();
        Person person = new Person();
        person.setName("Vasya");
        Person person1 = new Person();
        person1.setName("Vasya1");
        person.greetings(person1,date, System.out::println);

        
    }
}
