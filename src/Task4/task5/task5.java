package Task4.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task5 {
    public static void main(String[] args) {

        String html = " <b>Это</b> текст <i>с</i> <font color=”red”>HTML</font> кодами";
        Pattern pattern = Pattern.compile("<(\\\"[^\\\"]*\\\"|'[^']*'|[^'\\\">])*>");
        Matcher matcher = pattern.matcher(html);
        html = matcher.replaceAll("_");
        System.out.println(html);
    }
}
