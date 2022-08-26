package Task10.task2;

import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;

public class Office implements ISomeAction {
    public Office(SaySomth howSaySmth) {
        this.howSay = howSaySmth;
    }
    private ArrayList<Person> personInOffice = new ArrayList<>();
    private SaySomth howSay;

    private void doToEveryone(SaySomth saySomth, String name, String whatSay) {
        for (Person p : personInOffice) {
            saySomth.Say(whatSay + name + "  - Сказал " + p.getName());
        }
    }

    @Override
    public void greet(Date date, String name, Person person) {
        howSay.Say(name + " пришел на работу");
        int currentHour = date.getHours();
        String greeting = null;
        if (currentHour >= 12 && currentHour <= 17) {
            greeting = "Добпый день,";
        } else if (currentHour >= 8 && currentHour <= 11) {
            greeting = "Доброе утро,";
        } else if (currentHour >= 18) {
            greeting = "Добпый вечер,";
        }
        doToEveryone(howSay, name, greeting);
        personInOffice.add(person);
    }
    @Override
    public void gone(String name, Person person) {
        howSay.Say(name + " ушел с работы");
        personInOffice.remove(person);
        doToEveryone(howSay, name, "Пока, ");
    }
}

