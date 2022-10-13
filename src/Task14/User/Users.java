package Task14.User;

import Task14.Rewards.Rewards;
import Task14.Unit;
import javafx.collections.ObservableArray;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Users extends Unit {
    public ArrayList<Rewards> rewards = new ArrayList<>();
    public String rewardsStrId;
    public String getRewardsStrId() {
        return rewardsStrId;
    }
    public void setRewardsStr() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Rewards reward : rewards) {
            stringBuilder.append(reward.getId());
            stringBuilder.append('|');
        }
        rewardsStrId = stringBuilder.toString();
    }
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

    private int GetAge() {
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

    public void setID(int id) {
        this.id = id;
    }
}
