package Task14v1;

import Task14v1.User.Users;
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
import java.time.format.DateTimeParseException;

import static Task14v1.MainController.AlertWindowShow;

public class UserForm implements IControllerFabric {
    public TextField NameField;
    public TextField SecondNameField;
    public DatePicker BirthdayField;
    public TextField AgeField;
    public Button Save;
    public TableView<Rewards> TableRewards;

    private ObservableList<Rewards> UsersRewardsData = FXCollections.observableArrayList();

    public TableColumn RewardID;
    public TableColumn RewardName;

    public Button Add;
    public Button Delete;

    private boolean ModalResult = false;

    @FXML
    private void initialize() {
        RewardID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        RewardName.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        TableRewards.setItems(UsersRewardsData);
    }

    public void OnSaveAction(ActionEvent event) {
        if (LocalDate.now().compareTo(BirthdayField.getValue()) < 0 || LocalDate.now().compareTo(BirthdayField.getValue()) > 150) {
            AlertWindowShow("Неверная дата");
        } else {
            this.ModalResult = true;
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        }
    }

    public void onCancelClick(ActionEvent actionEvent) {
        this.ModalResult = false;
        ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }

    public boolean GetModalResult() {
        return ModalResult;
    }

    public void OnAddActon(ActionEvent event) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RewardsList.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        RewardsListController ListController = loader.getController();
        if (ListController.GetModalResult()) {
            Rewards rewards = (Rewards) ListController.GetUnit();
            if (!UsersRewardsData.contains(rewards)) {
                UsersRewardsData.add((Rewards) ListController.GetUnit());
                TableRewards.refresh();
            }
        }
    }

    public void OnDeleteAction(ActionEvent event) {
        UsersRewardsData.remove(TableRewards.getSelectionModel().getSelectedItem());
    }

    @Override
    public Unit GetUnit() {
        Users users = new Users(NameField.getText(), SecondNameField.getText(), BirthdayField.getValue());
        users.rewards.addAll(UsersRewardsData);
        return users;
    }

    public void SetUnit(Users users) {
        NameField.setText(users.getFirstName());
        SecondNameField.setText(users.getLastName());
        BirthdayField.setValue(users.getBirthDay());
        AgeField.setText(String.valueOf(users.getAge()));
        UsersRewardsData.addAll(users.rewards);
    }
}
