package Task9.task2;

import java.util.ArrayList;


public class task2 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("test");
        arrayList.add("test2");
        arrayList.add("test3");
        arrayList.add("test34");
        arrayList.add("test3");


        MyList<String> myList = new MyList<>(arrayList);

        while (myList.hasNext()) {
            System.out.println(myList.next());
        }
    }
}
