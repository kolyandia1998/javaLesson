package Task14v1.User;

import Task14v1.Rewards;
import Task14v1.Unit;
import Task15.Serrializer.LocalDateDeserialize;
import Task15.Serrializer.LocalDateSerialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@JsonRootName(value = "$OBJECT")
public class Users extends Unit implements Serializable {

    public ArrayList<Rewards> rewards = new ArrayList<>();

    public Users() {
    }
    ;

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

    @JsonFormat( pattern=  "yyyy-mm-dd" )
    @JsonDeserialize(using = LocalDateDeserialize.class)
    @JsonProperty("Birthday")
    @JsonSerialize(using = LocalDateSerialize.class)
    public LocalDate BirthDay = LocalDate.now();

    @JsonProperty("Age")
    public int Age;

    public Users(String firstName, String lastName, LocalDate BirthDay) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.BirthDay = BirthDay;
        this.Age = GetAge();
    }

    public void setRewards(ArrayList<Rewards> rewards) {
        this.rewards = rewards;
    }

    @JsonProperty(value = "Age")
    public int GetAge() {
        return
                LocalDate.now().getYear() - BirthDay.getYear();
    }

    public void SetAge() {
        this.Age = GetAge();
    }

    public String getFirstName() {
        return FirstName;
    }

    @JsonProperty(value = "Name")
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }
    @JsonProperty("Age")
    public int getAge() {
        return Age;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @JsonProperty("Birthday")
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
