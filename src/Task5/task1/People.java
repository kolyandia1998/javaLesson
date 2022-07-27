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
    private LocalDate birthDay;




    public void setBirthDay(int year, int month, int dayOfMonth) throws Exception {
        if (LocalDate.now().getYear() < year || (month > 12 || month < 1) || dayOfMonth > 31) {
            throw new Exception("Не правильно указана дата");
        }

        this.birthDay = LocalDate.of(year, Month.of(month), dayOfMonth);

    }


    public LocalDate getBirthDay() {
        return birthDay;
    }

    private String onlyLettersRegex = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$";

    public int getAge() {
        return LocalDate.now().compareTo(this.birthDay);
    }

    public void setName(String name) throws NameException {
        if (name == null || !name.matches(onlyLettersRegex)) {
            throw new NameException("Имя  должно состоять из букв");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) throws NameException {

        if (surname == null || !surname.matches(onlyLettersRegex)) {
            throw new NameException("Фамилия должна состоять из букв");
        }
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setMiddleName(String middle_name) throws NameException {

        if (middle_name == null || !middle_name.matches(onlyLettersRegex)) {
            throw new NameException("Фамилия должна состоять из букв");
        }
        this.middleName = middle_name;
    }

    public String getMiddleName() {
        return middleName;
    }


}


