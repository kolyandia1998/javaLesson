package Task14v1;

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
    private boolean ModalResult = false;

    public void OnSave(ActionEvent event) {
        this.ModalResult = true;
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @Override
    public Unit GetUnit() {
        Rewards reward = new Rewards(Name.getText(), Description.getText());
        return reward;
    }

    @Override
    public boolean GetModalResult() {
        return ModalResult;
    }

    public void SetUnit(Rewards rewards) {
        Name.setText(rewards.getTittle());
        Description.setText(rewards.getDescription());
    }

    public void onCancelClick(ActionEvent actionEvent) {
        this.ModalResult = false;
        ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }
}
