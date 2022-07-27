package Task7.task2;

import Task7.task2.Interfaces.ISeries;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;

public class task2 implements ISeries {
    public static double famousProgressionMember;
    public static int denominatorOfProgression ;


    @Override
    public double GetCurrent() {

        return 0;
    }

    @Override
    public boolean MoveNext() {
        return false;
    }

    @Override
    public void Reset() {

    }

    public static void PrintSeries(ISeries series)
    {
        series.Reset();
        for (int i = 0; i < 10; i++)
        {
            System.out.println(series.GetCurrent());
            series.MoveNext();
        }
    }
}
