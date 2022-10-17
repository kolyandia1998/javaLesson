package Task14v1;

import Task14.Rewards.Rewards;
import Task14.Unit;
import Task14.User.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class UserForm implements IControllerFabric{
    public TextField NameField;
    public TextField SecondNameField;
    public DatePicker BirthdayField;
    public TextField AgeField;
    public Button Save;

    public TableView<Rewards> TableRewards;

    private  ObservableList<Rewards> UsersRewardsData = FXCollections.observableArrayList();

    public TableColumn RewardID;
    public TableColumn RewardName;

    public Button Add;
    public Button Delete;


  /*  public Users GetUser () {
        Users user = new Users(NameField.getText(),SecondNameField.getText(),BirthdayField.getValue());
        user.rewards.addAll(UsersRewardsData);
        return user;
    }*/


    public void OnSaveAction(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
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
        stage.initModality(Modality.WINDOW_MODAL);

        stage.showAndWait();
        RewardsListController ListController = loader.getController();


      /* RewardsListController rewardsListController = new RewardsListController();
        rewardsListController.GetUnit();
        rewardsListController  = loader.getController();
        Unit unit =  rewardsListController.GetUnit();
        UsersRewardsData.add((Rewards) unit);
        TableRewards.refresh();*/
    }

    public void OnDeleteAction(ActionEvent event) {
    }


    @Override
    public Unit GetUnit() {
        Users user = new Users(NameField.getText(),SecondNameField.getText(),BirthdayField.getValue());
        user.rewards.addAll(UsersRewardsData);
        return user;
    }


   public void SetUnit (Users users) {
        NameField.setText(users.getFirstName());
        SecondNameField.setText(users.getLastName());
        BirthdayField.setValue(users.getBirthDay());
        AgeField.setText(String.valueOf(users.getAge()));
   }
}
