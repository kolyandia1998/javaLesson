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

public class MainWindowController {



    public static void AlertWindowShow (String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();

    }

    private final ObservableList<Users> usersData = FXCollections.observableArrayList();
    public static  ObservableList<Rewards> rewardsData = FXCollections.observableArrayList();


    @FXML
    Tab UsersTab = new Tab();
    @FXML
    Tab RewardsTab = new Tab();
    @FXML
    private Button Add = new Button();
    @FXML
    private Button Delete = new Button();
    @FXML
    private Button Edit = new Button();
    @FXML
    private  TableView<Users> TableUsers;
    @FXML
    private   TableView<Rewards> TableRewards;
    @FXML
    private TableColumn<Users, Integer> UsersID;
    @FXML
    private TableColumn<Users, String> UsersName;
    @FXML
    private TableColumn<Users, String> UsersSecondName;
    @FXML
    private TableColumn<Users, LocalDate> UsersBirthday;
    @FXML
    private TableColumn<Users, Integer> UsersAge;
    @FXML
    private TableColumn<Users, String> UserRewards;

    @FXML
    private TableColumn<Rewards, Integer> RewardsID;
    @FXML
    private TableColumn<Rewards, String> RewardName;
    @FXML
    private TableColumn<Rewards, String> RewardDescription;


    @FXML
    private void initialize() {
        UsersID.setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
        UsersName.setCellValueFactory(new PropertyValueFactory<Users, String>("FirstName"));
        UsersSecondName.setCellValueFactory(new PropertyValueFactory<Users, String>("LastName"));
        UsersBirthday.setCellValueFactory(new PropertyValueFactory<Users, LocalDate>("BirthDay"));
        UsersAge.setCellValueFactory(new PropertyValueFactory<Users, Integer>("Age"));
        RewardsID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        RewardName.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        RewardDescription.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
        UserRewards.setCellValueFactory(new PropertyValueFactory<Users,String>("rewardsStrId"));
        TableUsers.setItems(usersData);
        TableRewards.setItems(rewardsData);
    }

    private void RemoveSelected(TableView<? extends Unit> tableView, ObservableList unitList) {
        unitList.remove(tableView.getSelectionModel().getSelectedItem());
    }

    public  Unit GetSelectedItem () {
        if (UsersTab.isSelected()) {
            return TableUsers.getSelectionModel().getSelectedItem();
        }
        else
            return TableRewards.getSelectionModel().getSelectedItem();
    }



    public void onAddClick(ActionEvent event) {
        Add.setOnAction(actionEvent -> {

            if (UsersTab.isSelected()) {

                Parent root = null;
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("views/UserObjForm.fxml"));
                try {
                    root = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.showAndWait();
                UserCreateController controller = loader.getController();
                if (controller.getModalResult()) {
                    Users user = controller.GetUser();
                    this.usersData.add(user);
                }

            }
            else if (RewardsTab.isSelected()) {
                Parent root = null;
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("views/RewardsObjForm.fxml"));
                try {
                    root = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.showAndWait();
                RewardCreateController controller = loader.getController();
                if (controller.getModalResult()) {
                    Rewards reward = controller.GetReward();
                    this.rewardsData.add(reward);
                }
            }

    });}




    public void onEditClick(ActionEvent event) {
        Edit.setOnAction(actionEvent -> {
            if (UsersTab.isSelected()) {
                Parent root = null;
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("views/UserObjForm.fxml"));
                try {
                    root = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                UserCreateController controller = loader.getController();
                controller.SetUser((Users) GetSelectedItem());
                stage.showAndWait();
                if (controller.getModalResult()) {
                    Users user = controller.GetUser();
                    RemoveSelected(TableUsers, usersData);
                    this.usersData.add(user);
                }
            }
            else if (RewardsTab.isSelected()) {
                Parent root = null;
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("views/RewardsObjForm.fxml"));
                try {
                    root = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                RewardCreateController controller = loader.getController();
                controller.SetReward((Rewards) GetSelectedItem());
                stage.showAndWait();
                if (controller.getModalResult()) {
                    Rewards rewards = controller.GetReward();
                    rewards.setID(((Rewards) GetSelectedItem()).id);
                    RemoveSelected(TableRewards, rewardsData);
                    rewardsData.add(rewards);
                }

            }
        });
    }






    public void onDeleteClick(ActionEvent event) {


        Delete.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete " +  " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {


                if (UsersTab.isSelected()) {
                    RemoveSelected(TableUsers, usersData);
                } else if (RewardsTab.isSelected()) {
                    for (Users users:usersData){
                       if (users.rewards.contains((Rewards) GetSelectedItem()));
                        {
                            users.rewards.remove((Rewards) GetSelectedItem());
                        }
                    }
                    RemoveSelected(TableRewards, rewardsData);
                }
            }

        });
    }
}
