package Task4.task3;


import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class task3 {

    private static void getLocaleInfo(String a, String b) {


        Locale locale1 = Locale.forLanguageTag(a);
        Locale locale2 = Locale.forLanguageTag(b);
        double number = 1111111.2222222;
        Date date = new Date();


        System.out.println(locale1.getDisplayName() + " " + NumberFormat.getInstance(locale1).format(number)
                + " vs " + locale2.getDisplayName() + " " + NumberFormat.getInstance(locale2).format(number) + "\n"
                + locale1.getDisplayName() + " " + DateFormat.getTimeInstance(DateFormat.FULL, locale1).format(date) + " vs " + locale2.getDisplayName()
                + " " + DateFormat.getTimeInstance(DateFormat.FULL, locale2).format(date)
        );


    }

    public static void main(String[] args) {


        getLocaleInfo("en-UK", "ru-Ru");
        getLocaleInfo("ru-Ru", "en-US");

    }


}




