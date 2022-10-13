package Task14;

import Task14.Rewards.Rewards;
import Task14.User.Users;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static Task14.MainWindowController.AlertWindowShow;
import static Task14.UserCreateController.CheckTextField;

public class RewardCreateController {
    private Boolean modalResult = false;
    public TextField ID;
    public Button Save;
    public TextField Name;
    public TextField Description;

    public void onSaveClick(ActionEvent event) {

        if (CheckTextField(Name) && (Description.getText().length() <= 250 && Description.getText().length() > 0)) {
            this.modalResult = true; // ставим результат модального окна на true
            // закрываем окно к которому привязана кнопка
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } else {
            AlertWindowShow("Наименование > 0 и < 50 символов, оасание не более 250 и не менее 0");
        }
    }

    public Rewards GetReward() {
        Rewards result = new Rewards(Name.getText(), Description.getText());
        return result;
    }

    public void SetReward(Rewards reward) {
        Name.setText(reward.getTittle());
        Description.setText(reward.getDescription());
        ID.setText(String.valueOf(reward.getId()));
    }

    public boolean getModalResult() {
        return modalResult;
    }
}
