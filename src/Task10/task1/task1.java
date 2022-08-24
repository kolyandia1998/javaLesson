package Task10.task1;

public class task1 implements compare {
    @Override
    public boolean compared(String a, String b) {
        int alength = a.length();
        int blength = b.length();
        if (alength != blength)
        { return false;}
        else {
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


    public static void main(String[] args) {
        task1 task = new task1();
        String[] a = new String[4];
        a[0] = "aaa";
        a[1] = "c";
        a[2] = "fdggg";
        a[3] = "a";

        MySort.bubbleSorter(a, (String str1, String str2) -> str1.length() > str2.length() || (task.compared(str1, str2)));
        for (String str :
                a) {
            System.out.println(str);
        }


    }


}
