package Task14.User;

import Task14.Rewards.Rewards;
import Task14.Unit;
import javafx.collections.ObservableArray;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;



public class Users extends Unit   {


    public ArrayList<Rewards> rewards = new ArrayList<>();
    private String FirstName;
    private String LastName;
    private LocalDate BirthDay;
    public final int Age;
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
