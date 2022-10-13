package Task14;

import Task14.Rewards.Rewards;
import Task14.User.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;

import static Task14.MainWindowController.rewardsData;

public class ReawardListController {

    public TableView TableRewards;
    public TableColumn RewardsID;
    public TableColumn RewardName;
    public TableColumn RewardDescription;

    private boolean modalResult = false;



    private static final ObservableList<Rewards> rewardData = rewardsData;
    public Button Add;

    public boolean getModalResult() {
        return modalResult;
    }


    @FXML
    private void initialize() {

        RewardsID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        RewardName.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        RewardDescription.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
        TableRewards.setItems(rewardsData);
    }

    public Rewards GetReward () {
        return  (Rewards) TableRewards.getSelectionModel().getSelectedItem();
    }


    public void onAddClick(ActionEvent event) {
        Add.setOnAction(actionEvent -> {

            this.modalResult = true; // ставим результат модального окна на true
            // закрываем окно к которому привязана кнопка
            ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
        });
    }
}
