package Task14v1;

import Task14.Rewards.Rewards;
import Task14.Unit;
import Task14.User.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UserForm implements IControllerFabric{
    public TextField NameField;
    public TextField SecondNameField;
    public DatePicker BirthdayField;
    public TextField AgeField;
    public Button Save;

    public TableView<Rewards> TableRewards;

    private final ObservableList<Rewards> UsersRewardsData = FXCollections.observableArrayList();
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
    }

    public void OnDeletAction(ActionEvent event) {
    }


    @Override
    public Unit GetUnit() {
        Users user = new Users(NameField.getText(),SecondNameField.getText(),BirthdayField.getValue());
        user.rewards.addAll(UsersRewardsData);
        return user;
    }
}
