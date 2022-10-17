package Task14v1;

import Task14.Rewards.Rewards;
import Task14.Unit;
import Task14.User.Users;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RewardsForm implements IControllerFabric {
    public TextArea Description;
    public TextField Name;
    public Button Save;

    public void OnSave(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @Override
    public Unit GetUnit() {
        Rewards reward = new Rewards(Name.getText(),Description.getText());
        return reward;
    }

    public void SetUnit (Rewards rewards) {
        Name.setText(rewards.getTittle());
        Description.setText(rewards.getDescription());
    }
}
