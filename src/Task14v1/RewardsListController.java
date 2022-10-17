package Task14v1;

import Task14.Rewards.Rewards;
import Task14.User.Users;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

import static Task14.MainWindowController.rewardsData;


public class RewardsListController {

    private static  ObservableList<Rewards> rewardData = rewardsData;

    public TableView<Rewards> TableRewards;
    public TableColumn<Rewards, Integer> RewardsID;
    public TableColumn<Rewards, String> RewardName;
    public TableColumn<Rewards, String> RewardDescription;
    private boolean modalResult = false;
    public Button Add;

    public boolean GetModalResult() {
        return modalResult;
    }
    @FXML
    private void initialize() {
        RewardsID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        RewardName.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        RewardDescription.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
        TableRewards.setItems(rewardsData);
        }



    public Rewards GetReward() {
        return (Rewards) TableRewards.getSelectionModel().getSelectedItem();
    }

    public void OnAddClick(ActionEvent event) {
    }
}
