package Task5.task4;

import javax.xml.stream.events.Characters;

public class MyString {
    private final char[] chars;

    public char[] getChars() {
        return chars;
    }

    public MyString(char[] chars) {
        this.chars = chars;
    }

    public static MyString add(MyString first, MyString second) {
        char[] result = new char[first.chars.length + second.chars.length];
        for (int i = 0; i < first.chars.length; i++) {
            result[i] = first.chars[i];
        }
        int count = 0;
        for (int i = first.chars.length; i < result.length; i++) {
            result[i] = second.chars[count];
            count++;
        }
        return new MyString(result);
    }

    public static MyString minus(MyString first, int substring) throws Exception {

        if (first.chars.length < substring) {
            throw new Exception("Номер подстроки не может быть больше строки");
        }
        char[] result = new char[first.chars.length - substring];
        for (int i = 0; i < first.chars.length - substring; i++) {
            result[i] = first.chars[i];
        }
        return new MyString(result);

    }

    public static boolean theSame(MyString obj1, MyString obj2) {
        if (obj1.chars.length != obj2.chars.length) {
            return false;
        }
        boolean flag = true;
        for (int i = 0; i < obj1.chars.length; i++) {
            if (obj1.chars[i] != obj2.chars[i]) {
                flag = false;
            }
        }
        return flag;

    }

    public static String myStringToString(MyString ob) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ob.chars.length; i++) {
            sb = sb.append(ob.chars[i]);
        }
        return sb.toString();
    }
}

