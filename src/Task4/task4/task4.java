package Task4.task4;

import java.time.Duration;
import java.time.Instant;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task4 {

    public static long bench(int N, String str) {

        Instant start = Instant.now();
        for (int i = 0; i < N; i++) {
            str += "*";
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();

    }

    public static long bench(int N, StringBuilder a) {

        Instant start2 = Instant.now();
        for (int i = 0; i < N; i++) {
            a.append('*');
        }
        Instant finish2 = Instant.now();
        return Duration.between(start2, finish2).toNanos();

    }

    public static void main(String[] args) {

        String str = "";
        StringBuilder sb = new StringBuilder();


        int N = 100000;

        System.out.println(bench(N, str) + "ns - String star" + "\n" + bench(N, sb) + "ns - StringBuilderStar" + "\n" + "В " + bench(N, str) / bench(N, sb) + " раза StringBuilder быстрее");
    }
}
