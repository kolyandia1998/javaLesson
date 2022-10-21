package Task15.Controllers;

import Task14v1.Rewards;
import Task14v1.User.Users;
import Task15.Repository.IRepository;
import Task15.Repository.Repository;
import Task15.View.MainView;
import Task15.View.RewardForm;
import Task15.View.RewardsList;
import Task15.View.UserForm;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Controller {

    private IRepository repository = new Repository();

    public ObservableList<Users> GetUserDataFromRepository() {
        return repository.getUsersRepository();
    }
    public ObservableList<Rewards> GetRewardDataFromRepository() {
        return repository.getRewardsRepository();
    }

    public boolean AddUser(Users user) {
        try {
            repository.AddUser(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AddReward(Rewards reward) {
        try {
            repository.AddReward(reward);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean UpdateUser(Users user) {
        try {
            return repository.UpdateUser(user);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean UpdateReward(Rewards reward) {
        try {
            return repository.UpdateReward(reward);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean DeleteUser(int ID) {
        try {
            return repository.RemoveUser(ID);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean DeleteReward(int ID) {
        try {
            return repository.RemoveReward(ID);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AddRewardToUser(int userID, int rewardID) {
        try {
            return repository.RewardUser(userID, rewardID);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean DeleteRewardFromUser(Integer userID, Integer rewardID) {
        try {
            return repository.DeleteRewardFromUser(userID, rewardID);
        } catch (Exception e) {
            return false;
        }
    }

    public Users GetUserFromID(int userID) {
        return repository.GetUserFromID(userID);
    }
    public Rewards GetRewardFromID(int rewardID) {
        return repository.GetRewardFromID(rewardID);
    }
}
