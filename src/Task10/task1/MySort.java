package Task10.task1;

import java.security.PrivilegedAction;
import java.util.Comparator;

public class MySort   {
    public static void bubbleSorter(String[] array, compare obj) {
        for (int out = array.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {

                if (obj.compared(array[in], array[in + 1])) {
                    String temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
            }
        }
    }
}


