package Task5.task1;

import Task5.task1.Exception.NameException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.regex.Pattern;

public class People {
    private String surname;
    private String name;
    private String middleName;
    private LocalDate birthDay = LocalDate.of(1900, 1, 1);


    public void setBirth_day(int year, int month, int dayOfMonth) throws Exception {
        try {
            this.birthDay = LocalDate.of(year, Month.of(month), dayOfMonth);
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public LocalDate getBirth_day() {
        return birthDay;
    }
    private String reg = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$";

    public int getAge() {
        return LocalDate.now().compareTo(this.birthDay);
    }

    public void setName(String name) throws NameException {
        if (name == null || !name.matches(reg)) {
            throw new NameException("Имя  должно состоять из букв");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) throws NameException {

        if (surname == null || !surname.matches(reg)) {
            throw new NameException("Фамилия должна состоять из букв");
        }
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setMiddle_name(String middle_name) throws NameException {

        if (middle_name == null || !middle_name.matches(reg)) {
            throw new NameException("Фамилия должна состоять из букв");
        }
        this.middleName = middle_name;
    }

    public String getMiddle_name() {
        return middleName;
    }


}


