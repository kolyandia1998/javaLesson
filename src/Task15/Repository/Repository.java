package Task15.Repository;

import Task14v1.Rewards;
import Task14v1.Unit;
import Task14v1.User.Users;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
public class Repository implements IRepository {

    private ObservableList<Users> UsersRepository = FXCollections.observableArrayList();
    private ObservableList<Rewards> RewardsRepository = FXCollections.observableArrayList();

    public void RemoveRewardFromEachUser(Rewards rewards) {
        for (Users user : UsersRepository) {
            user.rewards.remove(rewards);
        }
    }

    public ObservableList<Users> getUsersRepository ( ) {return UsersRepository;}
    public ObservableList<Rewards> getRewardsRepository() {
        return RewardsRepository;
    }

    public Unit GetUnitFromID(int ID) {
        Users users = null;
        for (Users user : UsersRepository) {
            if (user.getId() == ID) {
                users = user;
                break;
            }
        }
        return users;
    }
    @Override
    public void AddUser(Users user) {
        UsersRepository.add(user);
    }
    @Override
    public void RemoveUnit(Users user) {
        UsersRepository.remove(user);
    }
    @Override
    public void AddReward(Rewards reward) {
        RewardsRepository.add(reward);
    }
    @Override
    public void RemoveReward(Rewards reward) {
        RewardsRepository.remove(reward);
    }

}
