package Task15.View;

import Task14v1.Rewards;
import Task14v1.User.Users;
import Task15.Controllers.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainView {

    private SplitPane splitPane = new SplitPane();

    TabPane tabPane = new TabPane();
    Tab users = new Tab();
    Tab rewards = new Tab();
    Button add = new Button();
    Button delete = new Button();
    Button edit = new Button();

    VBox leftControl = new VBox(add, delete, edit);

    TableView<Users> userTable = new TableView<>();
    TableView<Rewards> rewardTable = new TableView<>();

    TableColumn<Users, String> userName = new TableColumn<>("Имя");
    TableColumn<Users, String> userSecondName = new TableColumn<>("Фамилия");
    TableColumn<Users, Integer> userAge = new TableColumn<>("Возраст");
    TableColumn<Users, Integer> userID = new TableColumn<>("ID");
    TableColumn<Users, LocalDate> userBirthday = new TableColumn<>("Дата рождения");

    TableColumn<Rewards, Integer> rewardID = new TableColumn<>("ID");
    TableColumn<Rewards, String> rewardTittle = new TableColumn<>("Наименование");
    TableColumn<Rewards, String> rewardDescription = new TableColumn<>("Описание");

    private SplitPane splitPane() {
        add.setText("Добавить");
        delete.setText("Удалить");
        edit.setText("Изменить");
        add.setMaxSize(100, 100);
        delete.setMaxSize(100, 100);
        edit.setMaxSize(100, 100);
        leftControl.setMaxSize(100, 100);
        userTable.getColumns().addAll(userID, userName, userSecondName, userBirthday, userAge);
        rewardTable.getColumns().addAll(rewardID, rewardTittle, rewardDescription);
        users.setText("Пользователи");
        users.setContent(userTable);
        rewards.setText("Награды");
        rewards.setContent(rewardTable);
        tabPane.getTabs().addAll(users, rewards);
        leftControl.setFillWidth(true);
        splitPane.getItems().addAll(leftControl, tabPane);
        return splitPane;
    }

    private void OnAddAction(Controller listener) {
        add.setOnAction(event -> {
            if (users.isSelected()) {
                UserForm userForm = new UserForm();
                userForm.startForm(listener);
                userTable.refresh();
            } else if (rewards.isSelected()) {
                RewardForm rewardForm = new RewardForm();
                rewardForm.startForm(listener);
                rewardTable.refresh();
            }
        });
    }

    private void OnDeleteAction(Controller controller) {
        delete.setOnAction(event -> {
                    if (users.isSelected()) {
                        Users selectedUser = userTable.getSelectionModel().getSelectedItem();
                        if (selectedUser != null) {
                            controller.DeleteUser(selectedUser.getId());
                            userTable.refresh();
                        }
                    } else if (rewards.isSelected()) {
                        Rewards selectedReward = rewardTable.getSelectionModel().getSelectedItem();
                        if (selectedReward != null) {
                            controller.DeleteReward(selectedReward.getId());
                            rewardTable.refresh();
                        }
                    }
                }
        );
    }

    private void OnEditAction(Controller controller) {
        edit.setOnAction(event -> {
            if (users.isSelected()) {
                Users selectedUser = userTable.getSelectionModel().getSelectedItem();
                UserForm userForm = new UserForm(controller.GetUserFromID(selectedUser.getId()));
                userForm.startForm(controller);
                userTable.refresh();
            } else if (rewards.isSelected()) {
                Rewards selectedReward = rewardTable.getSelectionModel().getSelectedItem();
                RewardForm rewardForm = new RewardForm(controller.GetRewardFromID(selectedReward.getId()));
                rewardForm.startForm(controller);
                rewardTable.refresh();
            }
        });
    }

    private void InitializeTable(Controller controller) {
        userID.setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
        userName.setCellValueFactory(new PropertyValueFactory<Users, String>("FirstName"));
        userSecondName.setCellValueFactory(new PropertyValueFactory<Users, String>("LastName"));
        userBirthday.setCellValueFactory(new PropertyValueFactory<Users, LocalDate>("BirthDay"));
        userAge.setCellValueFactory(new PropertyValueFactory<Users, Integer>("Age"));
        rewardID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        rewardTittle.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        rewardDescription.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
        rewardTable.setItems(controller.GetRewardDataFromRepository());
        userTable.setItems(controller.GetUserDataFromRepository());
    }

    public void startForm(Controller controller) {
        OnEditAction(controller);
        OnDeleteAction(controller);
        OnAddAction(controller);
        InitializeTable(controller);
        SplitPane splitPane = splitPane();
        Scene scene = new Scene(splitPane, 700, 700);
        Stage stage = new Stage();
        stage.setScene(scene);
        Image icon = new Image("Task15/View/Oda.bmp");
        stage.setTitle("Odant");
        stage.getIcons().add(icon);
        stage.show();
    }
}
