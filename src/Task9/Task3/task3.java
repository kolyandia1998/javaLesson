package Task9.Task3;

import java.util.HashMap;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task3 {
    public static void main(String[] args) {
        String inputString = "zalupa.., zalupa+-  !!zalupa  ^^ &&  zalupa pupa pupa pupa  ";

        HashMap<String, Integer> words = new HashMap<String, Integer>();
        Pattern pattern = Pattern.compile("\\b\\w+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            String group = matcher.group().toLowerCase(Locale.ROOT);
            if (words.containsKey(group)) {
                words.computeIfPresent(group, (k, v) -> v + 1);
            } else {
                words.put(group, 1);
            }
        }
        words.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
    }


}
