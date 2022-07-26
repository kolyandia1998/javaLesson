package Task5.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task1 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        People man = new People();
        System.out.println("Введите имя");
        man.setName(bufferedReader.readLine());
        System.out.println("Введите Фамилию");
        man.setSurname(bufferedReader.readLine());
        System.out.println("Введите отчество");
        man.setMiddleName(bufferedReader.readLine());
        System.out.println("Введите дату рождения");
        System.out.println("Год");
        int year = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Месяц");
        int month = Integer.parseInt(bufferedReader.readLine());
        System.out.println("День");
        int day = Integer.parseInt(bufferedReader.readLine());
        man.setBirthDay(year, month, day);

        System.out.println(man.getSurname() + " " + man.getName() + " " + man.getMiddleName() + "\n" + man.getBirthDay() + "г.рождения" + "\n" + man.getAge() + " года");
    }

}
