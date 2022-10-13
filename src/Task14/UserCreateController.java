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

import static Task14.MainWindowController.AlertWindowShow;


public class UserCreateController {
    private final ObservableList<Rewards> rewardsData = FXCollections.observableArrayList();
    @FXML
    private TableView<Rewards> TableRewards;
    public TextArea ID;
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
    private Boolean ModalResult = false;

    public void OnSaveClick(ActionEvent event) {
        if (CheckTextField(Name) && CheckTextField(SecondName) && (LocalDate.now().compareTo(Birthday.getValue()) <= 150 && LocalDate.now().compareTo(Birthday.getValue()) >= 0)) {
            this.ModalResult = true;
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } else {
            AlertWindowShow("Имя и фамилия должны быть < 50 символов и > 0, а возраст не более 150 лет");
        }
    }

    public static boolean CheckTextField(TextField textField) {
        if (textField.getText().length() > 0 && textField.getText().length() <= 50) {
            return true;
        } else return false;
    }

    public Users GetUser() {
        Users user = new Users(Name.getText(), SecondName.getText(), Birthday.getValue());
        user.rewards.addAll(rewardsData);
        user.setRewardsStr();
        return user;
    }

    public void SetUser(Users user) {
        Name.setText(user.getFirstName());
        SecondName.setText(user.getLastName());
        Birthday.setValue(user.getBirthDay());
        ID.setText(String.valueOf(user.getId()));
        Age.setText(String.valueOf(user.Age));
        rewardsData.addAll(user.rewards);
        user.setRewardsStr();
    }

    public boolean getModalResult() {
        return ModalResult;
    }
    @FXML
    private void initialize() {
        RewardsID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        RewardName.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        RewardDescription.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
        TableRewards.setItems(rewardsData);
    }

    public void OnAddClick(ActionEvent event) {
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
        if (reawardListController.GetModalResult()) {
            Rewards reward = reawardListController.GetReward();
            if (rewardsData.contains(reward)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Пользователь уже имеет данную награду!");
                alert.showAndWait();
            } else {
                this.rewardsData.add(reward);
            }
        }

    }
}
