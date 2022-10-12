package Task14;

import Task14.Rewards.Rewards;
import Task14.User.Users;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RewardCreateController {
    private Boolean modalResult = false;
    public  TextField ID ;
    public Button Save;
    public TextField Name;
    public TextField Description;


    public void onSaveClick(ActionEvent event) {
        this.modalResult = true; // ставим результат модального окна на true
        // закрываем окно к которому привязана кнопка
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }

    public Rewards GetReward () {
        Rewards result = new Rewards(Name.getText(),Description.getText());
        return result;
    }

    public void SetReward (Rewards reward) {
        Name.setText(reward.getTittle());
        Description.setText(reward.getDescription());
        ID.setText(String.valueOf(reward.getId()));
    }

    public boolean getModalResult() {
        return modalResult;
    }
}
