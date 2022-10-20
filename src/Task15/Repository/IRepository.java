package Task15.Repository;

import Task14v1.Rewards;
import Task14v1.Unit;
import Task14v1.User.Users;
import javafx.collections.ObservableList;

import java.util.ArrayList;
public interface IRepository {
    public void AddUser(Users user);
    public void RemoveUnit(Users user);
    public void AddReward(Rewards reward);
    public void RemoveReward(Rewards reward);
    ObservableList<Users> getUsersRepository();

    ObservableList<Rewards> getRewardsRepository();
}
