package Task2.task5;

public class task5 {


    public static void main(String[] args) {
        int res = 0;
        for (int i = 1; i < 1000; i++) {

            if (i % 3 == 0 || i % 5 == 0) {
                res += i;

            }
        }

        System.out.println(res);
    }

}