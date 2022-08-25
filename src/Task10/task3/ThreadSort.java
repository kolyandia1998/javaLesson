package Task10.task3;

import Task10.task1.MySort;
import Task10.task1.compare;
import com.sun.jdi.event.ThreadDeathEvent;
import com.sun.jdi.request.ThreadDeathRequest;

public class ThreadSort extends MySort {
    public static void threadBubbleSorter(String[] array, compare obj, IShowStatus status) throws InterruptedException {
        Runnable main = () -> bubbleSorter(array, obj);
        Thread mainThread = new Thread(main);
        mainThread.start();
        while (mainThread.isAlive()){}
         status.show(mainThread.isAlive());
        }
    }

