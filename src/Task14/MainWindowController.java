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
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class MainWindowController {


    private final ObservableList<Users> usersData = FXCollections.observableArrayList();
    private final ObservableList<Rewards> rewardsData = FXCollections.observableArrayList();


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
    private TableView<Users> TableUsers;
    @FXML
    private TableView<Rewards> TableRewards;
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

        /*      UsersBirthday.setCellValueFactory(new PropertyValueFactory<Users, LocalDate>("UserRewards"));*/
        TableUsers.setItems(usersData);
        TableRewards.setItems(rewardsData);
    }

    private void RemoveSelected(TableView<? extends Unit> tableView, ObservableList unitList) {
        unitList.remove(tableView.getSelectionModel().getSelectedItem());
    }




    public void onAddClick(ActionEvent event) {
        Add.setOnAction(actionEvent -> {
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
            });

        Delete.setOnAction(actionEvent -> {
            if (UsersTab.isSelected()) {
                RemoveSelected(TableUsers, usersData);
            } else if (RewardsTab.isSelected()) {
                RemoveSelected(TableRewards, rewardsData);
            }

        });


    }

    private void editClick(ActionEvent event) {
        Edit.setOnAction(actionEvent -> {
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
        });
    }
}
