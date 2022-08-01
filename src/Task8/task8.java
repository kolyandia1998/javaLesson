package Task8;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class task8 {
    public static void main(String[] args) throws Exception {


        DynamicArray<String> dynamicArray = new DynamicArray<String>(9);
        dynamicArray.add("test1");
        dynamicArray.add("test2");
        dynamicArray.add("test3");
        dynamicArray.add("test4");
        dynamicArray.add("test5");
        dynamicArray.remove("test3");

        System.out.println(dynamicArray.get(2));
    }


}
