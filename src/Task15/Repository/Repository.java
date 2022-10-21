package Task15.Repository;

import Task14v1.Rewards;
import Task14v1.Unit;
import Task14v1.User.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.stream.Collectors;
public class Repository implements IRepository {

    private ObservableList<Users> UsersRepository = FXCollections.observableArrayList();
    private ObservableList<Rewards> RewardsRepository = FXCollections.observableArrayList();

    public ObservableList<Users> getUsersRepository() {
        return UsersRepository;
    }
    public ObservableList<Rewards> getRewardsRepository() {
        return RewardsRepository;
    }

    @Override
    public Users GetUserFromID(Integer userID) {
        return UsersRepository.stream().filter(a -> a.getId() == userID).collect(Collectors.toList()).get(0);
    }
    @Override
    public Rewards GetRewardFromID(Integer rewardID) {
        return RewardsRepository.stream().filter(a -> a.getId() == rewardID).collect(Collectors.toList()).get(0);
    }

    @Override
    public void AddUser(Users user) {
        UsersRepository.add(user);
    }
    @Override
    public void AddReward(Rewards reward) {
        RewardsRepository.add(reward);
    }

    @Override
    public boolean RemoveUser(Integer ID) {
        return UsersRepository.remove(GetUserFromID(ID));
    }
    @Override
    public boolean RemoveReward(Integer ID) {
        Rewards rewardForRemove = GetRewardFromID(ID);
        for (Users user : UsersRepository) {
            if (user.rewards.contains(rewardForRemove)) {
                user.rewards.remove(rewardForRemove);
            }
        }
        return RewardsRepository.remove(rewardForRemove);
    }

    @Override
    public boolean RewardUser(Integer userID, Integer rewardID) {
        Users userForReward = GetUserFromID(userID);
        Rewards rewardForUser = GetRewardFromID(rewardID);
        if (!userForReward.rewards.contains(rewardForUser)) {
            return userForReward.rewards.add(rewardForUser);
        } else {
            return false;
        }
    }
    @Override
    public boolean UpdateUser(Users user) {
        Users userForUpdate = GetUserFromID(user.getId());
        userForUpdate.setBirthDay(user.getBirthDay());
        userForUpdate.setFirstName(user.getFirstName());
        userForUpdate.setLastName(user.getLastName());
        userForUpdate.setRewards(user.rewards);
        return true;
    }
    @Override
    public boolean UpdateReward(Rewards reward) {
        Rewards rewardForUpdate = GetRewardFromID(reward.getId());
        rewardForUpdate.setTittle(reward.getTittle());
        rewardForUpdate.setDescription(reward.getDescription());
        return true;
    }
    @Override
    public boolean DeleteRewardFromUser(Integer userID, Integer rewardID) {
        Users userForDeletingReward = GetUserFromID(userID);
        Rewards rewardForDelete = GetRewardFromID(rewardID);
        userForDeletingReward.rewards.remove(rewardForDelete);
        return true;
    }
}
