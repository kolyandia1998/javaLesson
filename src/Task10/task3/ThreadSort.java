package Task10.task3;

import Task10.task1.MySort;
import Task10.task1.compare;

import java.util.ArrayList;

public class ThreadSort extends MySort {

    private ArrayList<IStatus> listener = new ArrayList<>();

    public void addListener(IStatus status) {
        listener.add(status);
    }

    public void removeListener(IStatus status) {
        listener.remove(status);
    }

    private void onDone(String[] str) {
        for (IStatus listener : listener) {
            listener.done(str);
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

