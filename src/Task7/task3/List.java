package Task7.task3;

import Task7.task2.Interfaces.ISeries;
import Task7.task3.Interfaces.IIndexable;

public class List implements ISeries, IIndexable {


    private double[] series;
    private int currentIndex;

    public List(double[] series) {
        this.series = series;
        currentIndex = 0;
    }

    public double GetCurrent() {
        return series[currentIndex];
    }

    public boolean MoveNext() {
        currentIndex = currentIndex < series.length - 1 ? currentIndex + 1 : 0;
        return true;
    }

    public void Reset() {
        currentIndex = 0;
    }


    @Override
    public double thisElement(int index) {
        while (currentIndex != index) {
            MoveNext();
        }
        return GetCurrent();

    }
}


