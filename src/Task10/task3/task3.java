package Task10.task3;

import Task10.task1.MySort;
import Task10.task1.compare;

public class task3 {

    public static boolean isFirstGreaterThanSecond(String a, String b) {
        int alength = a.length();
        int blength = b.length();
        if (alength != blength) {
            return false;
        } else {
            char[] achars = a.toLowerCase().toCharArray();
            char[] bchars = b.toLowerCase().toCharArray();
            boolean flag = false;
            for (int i = 0; i < achars.length; i++) {

                if (achars[i] > bchars[i]) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String[] a = new String[5];
        a[0] = "aaa";
        a[1] = "c";
        a[2] = "fdggg";
        a[3] = "a";
        a[4] = "d";
        ThreadSort.threadBubbleSorter(a, (String str1, String str2) -> str1.length() > str2.length() || (isFirstGreaterThanSecond(str1, str2)), (() -> {
            System.out.println("Сортировка завершена");
        }));

        for (String str :
                a) {
            System.out.println(str);
        }
        for (String str :
                a) {
            System.out.println(str);
        }
        for (String str :
                a) {
            System.out.println(str);
        }
    }

}

