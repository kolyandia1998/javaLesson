package Task15.Repository;

import Task14v1.Rewards;
import Task14v1.Unit;
import Task14v1.User.Users;
import javafx.collections.ObservableList;

import java.util.ArrayList;
public interface IRepository {
    void AddUser(Users user);
    void AddReward(Rewards reward);
    boolean RemoveUser(Integer ID);
    boolean RemoveReward(Integer ID);
    ObservableList<Users> getUsersRepository();
    ObservableList<Rewards> getRewardsRepository();
    boolean RewardUser ( Integer userID, Integer rewardID);
    boolean UpdateUser (Users user);
    boolean UpdateReward (Rewards reward);
    boolean DeleteRewardFromUser (Integer userID, Integer rewardID);

    Users GetUserFromID(Integer userID);
    Rewards GetRewardFromID(Integer rewardID);
}
