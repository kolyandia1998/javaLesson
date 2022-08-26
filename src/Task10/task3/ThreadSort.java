package Task10.task3;

import Task10.task1.MySort;
import Task10.task1.compare;
import com.sun.jdi.event.ThreadDeathEvent;
import com.sun.jdi.request.ThreadDeathRequest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ThreadSort extends MySort {

    private ArrayList<IShowStatus> listener = new ArrayList<>();

    public void addListener(IShowStatus status) {
        listener.add(status);
    }

    public void removeListener(IShowStatus status) {
        listener.remove(status);
    }

    private void onDone(String[] str) {
        for (IShowStatus listener : listener) {
            listener.show(str);
        }
    }


    public void threadBubbleSorter(String[] array, compare obj) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                var copy = array.clone();
                bubbleSorter(copy, obj);
                onDone(copy);
            }
        };
        Thread sortThread = new Thread(runnable);
        sortThread.start();
    }
}

