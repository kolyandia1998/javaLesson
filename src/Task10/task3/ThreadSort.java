package Task10.task3;

import Task10.task1.MySort;
import Task10.task1.compare;
import com.sun.jdi.event.ThreadDeathEvent;
import com.sun.jdi.request.ThreadDeathRequest;

public class ThreadSort extends MySort {
    public static void threadBubbleSorter(String[] array, compare obj, IShowStatus status ) throws InterruptedException {
         Runnable statusRun = () -> status.show();
         Thread statusThread = new Thread(statusRun);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bubbleSorter(array,obj);
                statusThread.start();
            }
        };
        Thread sortThread = new Thread(runnable);
        sortThread.start();
        }
}

