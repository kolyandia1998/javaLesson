package Task14v1;

import Task14.Rewards.Rewards;
import Task14.Unit;
import Task14.User.Users;
import Task14.UserCreateController;
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
    private  ObservableList<Rewards> rewardsData = FXCollections.observableArrayList();
    @FXML
    public Tab UsersTab;
    @FXML
    public Tab RewardsTab;
    @FXML
    public TableColumn UserID;
    @FXML
    public TableColumn UserName;
    @FXML
    public TableColumn UserSecondName;

    @FXML
    private TableColumn<Users,LocalDate>  UserBirthday;
    public TableColumn UserAge;
    @FXML
    public TableColumn UserStrRewards;
    @FXML
    public TableColumn RewardID;
    @FXML
    public TableColumn RewardTittle;
    @FXML
    public TableColumn RewardDescription;
    @FXML
    private TableView<Users> TableUsers;
    @FXML
    private TableView<Rewards> TableRewards;

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
             this.rewardsData.add((Rewards) unit);
         }
    }
    public void OnAddAction(ActionEvent event) {
        CreateModalWindow("UserForm.fxml",new UserForm());
    }

    public void OnDeleteAction(ActionEvent event) {
    }

    public void OnEditAction(ActionEvent event) {
    }
}
