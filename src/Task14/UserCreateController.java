package Task14;

import Task14.Rewards.Rewards;
import Task14.User.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


public class UserCreateController {
    private final ObservableList<Rewards> rewardsData = FXCollections.observableArrayList();
    @FXML
    private TableView<Rewards> TableRewards;
    public TextArea ID ;
    public Button Save;
    public TextField Name;
    public TextField SecondName;
    public TextField Age;
    public TableColumn RewardsID;
    public TableColumn RewardName;
    public TableColumn RewardDescription;
    public Button Add;
    public Button Delete;
    public DatePicker Birthday;

    private Boolean modalResult = false;
    public void onSaveClick(ActionEvent event) {
        this.modalResult = true; // ставим результат модального окна на true
        // закрываем окно к которому привязана кнопка
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }




    public Users GetUser () {
          Users result = new Users(Name.getText(),SecondName.getText(),Birthday.getValue());
        result.rewards.addAll(rewardsData);
          return result;
    }


    public void SetUser (Users user) {
        Name.setText(user.getFirstName());
        SecondName.setText(user.getLastName());
        Birthday.setValue(user.getBirthDay());
        ID.setText(String.valueOf(user.getId()));
        Age.setText(String.valueOf(user.Age));
        rewardsData.addAll(user.rewards);
    }


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


    public void onAddClick(ActionEvent event) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/RewardsListForAdd.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();
        ReawardListController reawardListController = loader.getController();
        if (reawardListController.getModalResult()) {
            Rewards reward = reawardListController.GetReward();
            this.rewardsData.add(reward);
        }

    }
}
