package Task14.User;

import Task14.Unit;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import static Task14.ID.createID;

public class Users extends Unit {
    private String FirstName;
    private String LastName;
    private LocalDate BirthDay;
    private final int Age;
    public Users(String firstName, String lastName, LocalDate birthDay) {
     this.FirstName = firstName;
     this.LastName = lastName;
     this.BirthDay = birthDay;
     this.Age = GetAge();
    }

    private int GetAge()   {
        return LocalDate.now().compareTo(BirthDay);
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }
    public int getAge() {
        return Age;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public LocalDate getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        BirthDay = birthDay;
    }


}
