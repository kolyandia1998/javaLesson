package Task14;

import Task14.User.Users;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserCreateController {

    public TextField ID ;
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

    private Boolean modalResult = false;
    public void onSaveClick(ActionEvent event) {
        this.modalResult = true; // ставим результат модального окна на true
        // закрываем окно к которому привязана кнопка
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }

    public Users GetUser () {

          Users result = new Users(Name.getText(),SecondName.getText(),Birthday.getValue());
          return result;

    }

    public boolean getModalResult() {
        return modalResult;
    }
}
