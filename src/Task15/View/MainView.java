package Task15.View;

import Task14v1.Rewards;
import Task14v1.User.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

    public void startForm() {
        SplitPane splitPane = splitPane();
        Scene scene = new Scene(splitPane, 700, 700);
        Stage stage = new Stage();
        stage.setScene(scene);
        Image icon = new Image("Task15/View/Oda.bmp");
        stage.setTitle("Odant");
        stage.getIcons().add(icon);
        stage.show();
    }

    public TableView<Users> getUserTable() {
        return userTable;
    }
    public TableView<Rewards> getRewardTable() {
        return rewardTable;
    }
    public TableColumn<Users, String> getUserName() {
        return userName;
    }
    public TableColumn<Users, String> getUserSecondName() {
        return userSecondName;
    }
    public TableColumn<Users, Integer> getUserAge() {
        return userAge;
    }
    public TableColumn<Users, Integer> getUserID() {
        return userID;
    }
    public TableColumn<Users, LocalDate> getUserBirthday() {
        return userBirthday;
    }
    public TableColumn<Rewards, Integer> getRewardID() {
        return rewardID;
    }
    public TableColumn<Rewards, String> getRewardTittle() {
        return rewardTittle;
    }
    public TableColumn<Rewards, String> getRewardDescription() {
        return rewardDescription;
    }

    public Tab getRewards() {
        return rewards;
    }
    public Button getAdd() {
        return add;
    }
    public Tab getUsers() {
        return users;
    }
    public Button getDelete() {
        return delete;
    }
    public Button getEdit() {
        return edit;
    }
}
