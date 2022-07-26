package Task5.task4;

import static Task5.task4.MyString.*;

public class task4 {
    public static void main(String[] args) throws Exception {
        char[] chars = new char[]{'a', 'b', 'd'};
        char[] chars2 = new char[]{'a', 'b', 'v', 'q'};

        MyString a = new MyString(chars);
        MyString b = new MyString(chars2);
        MyString q = add(a, b);

        for (int i = 0; i < q.getChars().length; i++) {

            System.out.println(q.getChars()[i]);
        }

        System.out.println(theSame(a, b));
        a = MyString.minus(a, 1);
        for (int i = 0; i < a.getChars().length; i++) {

            System.out.println(a.getChars()[i]);
        }
        System.out.println(myStringToString(a));

    }

}
