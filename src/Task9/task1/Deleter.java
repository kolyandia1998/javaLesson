package Task9.task1;

import java.util.*;
import java.util.function.Consumer;

public class Deleter {

    private static int GetDesiredIndex(int size, int k) {
        if (size == 1)
            return 1;
        else
            return (GetDesiredIndex(size - 1, k) + k - 1) % size + 1;
    }

    public static <T> void RemoveEachSecondItem(List<T> list, int step) {
        int Index = GetDesiredIndex(list.size(), step);
        int count = 1;
        T object = null;
        for (T obj : list) {
            if (count == Index) {
                object = obj;
                break;
            }
            count++;
        }
        list.clear();
        list.add(object);

    }



  /*  public static <T> void   RemoveEachSecondItem  (List<T> list, int step) {
        int start = 0;
        while (list.stream().count() > 1) {
            int count = 0;
            int Start=(start + step)%list.size();
             for (T obj:list)
             {
                 if (count == Start)
                 { list.remove(obj);
                   break;}
                  count++;
             }
             count=0;
            start = Start;
        }
    }*/
}



