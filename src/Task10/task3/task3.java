package Task10.task3;

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
        ThreadSort sort = new ThreadSort();
        IStatus consoleOut = (str) -> {
            for (String string : str) {
                System.out.println(string);
            }
        };
        sort.addListener(consoleOut);
        String[] a = new String[] {"ab","bc"};
        sort.threadBubbleSorter(a, (String str1, String str2) -> str1.length() > str2.length() || (isFirstGreaterThanSecond(str1, str2)));
    }
}

