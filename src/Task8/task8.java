package Task8;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class task8 {
    public static void main(String[] args) throws Exception {

        DynamicArray<Double> dynamicArray = new DynamicArray<Double>(100);
        for (int i = 0 ; i < 100; i++){

            dynamicArray.add(Math.random());
        }
         Double[] array = new Double[100];
         for (int i = 0; i < array.length; i++){
             array[i] = Math.random();
         }


         System.out.println(dynamicArray.size() + "  " + dynamicArray.get(123));
    }


}
