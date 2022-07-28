package Task7.task3;

import Task7.task2.Interfaces.ISeries;
import Task7.task3.Interfaces.IIndexable;

public class ArithmeticalProgression implements ISeries, IIndexable {
    double start, step;
    int currentIndex, index;

    public ArithmeticalProgression(double start, double step) {
        this.start = start;
        this.step = step;
        this.currentIndex = 1;
    }

    public double GetCurrent() {
        return start + step * currentIndex;
    }

    public boolean MoveNext() {
        currentIndex++;
        return true;
    }

    public void Reset() {
        currentIndex = 1;
    }

    public static void PrintSeries(ISeries series) {
        series.Reset();
        for (int i = 0; i < 10; i++) {
            System.out.println(series.GetCurrent());
            series.MoveNext();
        }
    }

    @Override
    public double thisElement(int index) {
        return start + step * index;
    }
}


