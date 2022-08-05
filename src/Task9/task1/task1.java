package Task9.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static Task9.task1.Deleter.*;

public class task1 {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.add("8");
        strings.add("9");
        strings.add("10");


        LinkedList<Integer> integer = new LinkedList<>();

        integer.add(1);
        integer.add(2);
        integer.add(3);
        integer.add(4);
        integer.add(5);
        integer.add(6);
        integer.add(7);
        integer.add(8);
        integer.add(9);
        integer.add(10);

        OneOfN(integer,2);
        for (Integer i:integer){
            System.out.println(i);
        }

    }
}
