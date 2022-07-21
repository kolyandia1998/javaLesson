package Task4.task4;

import java.time.Duration;
import java.time.Instant;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task4 {
    public static void main(String[] args) {

        String str = "";
        StringBuilder sb = new StringBuilder();


        int N = 100000;
        Instant start = Instant.now();
        for (int i = 0; i < N; i++) {
            str += "*";
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toNanos();

        Instant start2 = Instant.now();
        for (int i = 0; i < N; i++) {
            sb.append('*');
        }
        Instant finish2 = Instant.now();
        long elapsed2 = Duration.between(start2, finish2).toNanos();
        System.out.println(elapsed + "ns - String star" + "\n" + elapsed2 + "ns - StringBuilderStar" + "\n" + "В " + elapsed / elapsed2 + " раза StringBuilder быстрее");
    }
}
