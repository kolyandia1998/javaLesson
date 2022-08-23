package Task10.task2;

import org.w3c.dom.events.Event;

import java.awt.*;
import java.sql.Time;
import java.util.Date;
import java.util.EventObject;

public class Person {

    private String name;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void greetings (Person ob,Date date, Greet obj) {
         int currentHour = date.getHours();

          if (currentHour>=12 && currentHour <= 17)
                { String hi = "Добрый день," + ob.getName();
                    obj.great(hi);}
          else if (currentHour>= 8 && currentHour <= 11)
                { String hi = "Доброе утро," + ob.getName();
                    obj.great(hi);}
          else if (currentHour>=18){
                String hi = "Добрый вечер," + ob.getName();
                    obj.great(hi);
          }
    }

    public void bye (Person ob, By obj) {
           String by = "До свидания, " + ob.getName();
           obj.by(by);
    }


    EventObject eventObject;
    public void coming (Person obj) {


    }


}
