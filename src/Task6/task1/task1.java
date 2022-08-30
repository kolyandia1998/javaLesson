package Task6.task1;

import Task5.task1.Exception.NameException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task1 {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        Employer employer = new Employer();
        try {
            System.out.println("Введите имя");
            employer.setName(bufferedReader.readLine());
            System.out.println("Введите Фамилию");
            employer.setSurname(bufferedReader.readLine());
            System.out.println("Введите отчество");
            employer.setMiddleName(bufferedReader.readLine());
        } catch (NameException e) {
            System.out.println(e.getMessage());
        }

        try {

            System.out.println("Введите дату рождения");
            System.out.println("Год");
            int year = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Месяц");
            int month = Integer.parseInt(bufferedReader.readLine());
            System.out.println("День");
            int day = Integer.parseInt(bufferedReader.readLine());
            employer.setBirthDay(year, month, day);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Введите должность");

        employer.setJobTitle(bufferedReader.readLine());
        System.out.println("Введите стаж");
        try {
            employer.setWorkExperience(Integer.parseInt(bufferedReader.readLine()));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(employer.toString());

    }
}
