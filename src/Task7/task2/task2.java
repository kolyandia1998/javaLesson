package Task7.task2;

import Task7.task2.Interfaces.ISeries;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class task2 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Progression progression = new Progression(Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine()));
            Progression.PrintSeries(progression);
        } catch (NumberFormatException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

