package Task7.task2;

import Task7.task2.Interfaces.ISeries;

public class Progression implements ISeries {
    public double famousProgressionMember, denominatorOfProgression;
    public double degree;

    public Progression(double famousProgressionMember, double denominatorOfProgression) {
        this.denominatorOfProgression = denominatorOfProgression;
        this.famousProgressionMember = famousProgressionMember;
        this.degree = 0;
    }

    @Override
    public double GetCurrent() {
        return famousProgressionMember * Math.pow(denominatorOfProgression, degree);
    }

    @Override
    public boolean MoveNext() {
        degree++;
        return true;
    }

    @Override
    public void Reset() {
        degree = 0;

    }

    public static void PrintSeries(ISeries series) {
        series.Reset();
        for (int i = 0; i < 10; i++) {
            System.out.println(series.GetCurrent());
            series.MoveNext();
        }
    }
}
