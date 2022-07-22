package Task4.task4;

import java.time.Duration;
import java.time.Instant;

public class task4 {
    public interface MyInterface {

        void Bench(String input, int N);

    }


    public static MyInterface strInterface = new MyInterface() {
        @Override
        public void Bench(String input, int N) {

            for (int i = 0; i < N; i++) {
                input += "*";
            }
        }
    };
   public static MyInterface sbInterface = new MyInterface() {
        @Override
        public void Bench(String input, int N) {
            StringBuilder sb = new StringBuilder(input);
            for (int i = 0; i < N; i++) {
                sb.append('*');
            }
        }
    };

    public static long benchTest(MyInterface myInterface, String input, int N) {


        Instant start = Instant.now();
        myInterface.Bench(input, N);
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();

    }


    public static void main(String[] args) {
        String input = "";
        int N = 1000000;



        long resStr = benchTest(strInterface, input, N);
        long resSb = benchTest(sbInterface, input, N);


        System.out.println("Результат String:  " + resStr);
        System.out.println("Результат StringBuilder:  " + resSb);
        System.out.println(resStr/resSb);
    }
}