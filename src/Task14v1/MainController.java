package Task14v1;

import Task14.Rewards.Rewards;
import Task14.Unit;
import Task14.User.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class MainController {
    @FXML
    public Button Add;
    @FXML
    public Button Delete;
    @FXML
    public Button Edit;
    private  ObservableList<Users> usersData = FXCollections.observableArrayList();
    public static   ObservableList<Rewards> rewardsData = FXCollections.observableArrayList();


    @FXML
    public Tab UsersTab;
    @FXML
    public Tab RewardsTab;
    @FXML
    public TableColumn<Users, Integer> UserID;
    @FXML
    public TableColumn<Users, String> UserName;
    @FXML
    public TableColumn<Users, String> UserSecondName;

    @FXML
    public TableColumn<Users,LocalDate>  UserBirthday;

    @FXML
    public TableColumn<Users, Integer> UserAge;
    @FXML
    public TableColumn<Users, String> UserStrRewards;
    @FXML
    public TableColumn<Rewards, Integer> RewardID;
    @FXML
    public TableColumn<Rewards, String> RewardTittle;
    @FXML
    public TableColumn<Rewards, String> RewardDescription;
    @FXML
    private TableView<Users> TableUsers;
    @FXML
    private  TableView<Rewards> TableRewards;



    @FXML
    private void initialize() {
        UserID.setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
        UserName.setCellValueFactory(new PropertyValueFactory<Users, String>("FirstName"));
        UserSecondName.setCellValueFactory(new PropertyValueFactory<Users, String>("LastName"));
        UserBirthday.setCellValueFactory(new PropertyValueFactory<Users, LocalDate>("BirthDay"));
        UserAge.setCellValueFactory(new PropertyValueFactory<Users, Integer>("Age"));
        RewardID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        RewardTittle.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        RewardDescription.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
        UserStrRewards.setCellValueFactory(new PropertyValueFactory<Users, String>("rewardsStrId"));
        TableUsers.setItems(usersData);
        TableRewards.setItems(rewardsData);
    }

    public static void AlertWindowShow(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }

    private void CreateModalWindow ( String resourceXml,IControllerFabric ModalController) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(resourceXml));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();
         ModalController  = loader.getController();
         Unit unit =  ModalController.GetUnit();
         if (UsersTab.isSelected()) {
             this.usersData.add( (Users) unit);
         }
         else if (RewardsTab.isSelected()) {
             rewardsData.add((Rewards) unit);
         }
    }

      private void CreateUnitForm () {
           if (UsersTab.isSelected()) {
               CreateModalWindow("UserForm.fxml",new UserForm());
           }
           else if (RewardsTab.isSelected()) {
               CreateModalWindow("RewardForm.fxml",new RewardsForm());
           }
      }
    public void OnAddAction(ActionEvent event) {
          CreateUnitForm();
    }

    public void OnDeleteAction(ActionEvent event) {

        if (UsersTab.isSelected()) {
            usersData.remove (TableUsers.getSelectionModel().getSelectedItem());
            TableUsers.refresh();
        }
        else if (RewardsTab.isSelected()) {
            rewardsData.remove (TableRewards.getSelectionModel().getSelectedItem());
            TableRewards.refresh();
        }

    }








    public void OnEditAction(ActionEvent event)  {
        if (UsersTab.isSelected()) {
            String resourceXml = "UserForm.fxml";
            Parent root = null;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(resourceXml));
            try {
                root = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            UserForm userForm = new UserForm();
            userForm = loader.getController();
            try {
                userForm.SetUnit(usersData.get(usersData.indexOf(TableUsers.getSelectionModel().getSelectedItem())));
                stage.showAndWait();
                Users users = (Users) userForm.GetUnit();
                usersData.get(usersData.indexOf(TableUsers.getSelectionModel().getSelectedItem())).setFirstName(users.getFirstName());
                usersData.get(usersData.indexOf(TableUsers.getSelectionModel().getSelectedItem())).setLastName(users.getLastName());
                usersData.get(usersData.indexOf(TableUsers.getSelectionModel().getSelectedItem())).setBirthDay(users.getBirthDay());
                TableUsers.refresh();
            }
            catch (RuntimeException e) {
                AlertWindowShow("Не выбран объект");
            }
        }
        else if (RewardsTab.isSelected()) {

            String resourceXml = "RewardForm.fxml";
            Parent root = null;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(resourceXml));
            try {
                root = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            RewardsForm rewForm = new RewardsForm();
            rewForm = loader.getController();
            try {
                rewForm.SetUnit(rewardsData.get(rewardsData.indexOf(TableRewards.getSelectionModel().getSelectedItem())));
                stage.showAndWait();
                Rewards rewards = (Rewards) rewForm.GetUnit();
                rewardsData.get(rewardsData.indexOf(TableRewards.getSelectionModel().getSelectedItem())).setTittle(rewards.getTittle());
                rewardsData.get(rewardsData.indexOf(TableRewards.getSelectionModel().getSelectedItem())).setDescription(rewards.getDescription());
                TableRewards.refresh();
            }
            catch (RuntimeException e) {
                AlertWindowShow("Не выбран объект");
            }

        }


    }
}
