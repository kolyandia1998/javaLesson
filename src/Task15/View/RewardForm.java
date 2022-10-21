package Task15.View;

import Task14v1.Rewards;
import Task14v1.User.Users;
import Task15.Controllers.Controller;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
public class RewardForm {

    public RewardForm() {
    }
    ;
    public RewardForm(Rewards reward) {
        rewardTittle.setText(reward.getTittle());
        rewardDescription.setText(reward.getDescription());
        ID.setText(String.valueOf(reward.getId()));
    }

    private AnchorPane anchorPane = new AnchorPane();

    private TextField rewardTittle = new TextField();
    private TextArea rewardDescription = new TextArea();

    private TextField ID = new TextField();

    private Button save = new Button("Сохранить");

    private final Label labelID = new Label("ID");
    private final Label labelTittle = new Label("Наименование");
    private final Label labelDescription = new Label("Описание");

    private void OnSaveAction(Controller controller) {
        save.setOnAction(event -> {
            Rewards newReward = new Rewards(rewardTittle.getText(), rewardDescription.getText());
            if (ID.getText().length() > 0) {
                newReward.setID(Integer.parseInt(ID.getText()));
                controller.UpdateReward(newReward);
            } else {
                controller.AddReward(newReward);
            }
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        });
    }

    private AnchorPane createRewardForm() {
        ID.setVisible(false);
        labelID.setVisible(false);
        ID.setLayoutX(180);
        ID.setLayoutY(200);
        ID.setEditable(false);
        labelID.setLayoutY(200);
        labelID.setLayoutX(90);
        rewardTittle.setLayoutX(180);
        rewardTittle.setLayoutY(240);
        labelTittle.setLayoutY(240);
        labelTittle.setLayoutX(90);
        rewardDescription.setLayoutY(280);
        rewardDescription.setLayoutX(180);
        labelDescription.setLayoutX(90);
        labelDescription.setLayoutY(280);
        save.setLayoutX(300);
        save.setLayoutY(500);
        anchorPane.getChildren().addAll(ID, rewardTittle, rewardDescription, save, labelID, labelTittle, labelDescription);
        return anchorPane;
    }

    public void startForm(Controller controller) {
        OnSaveAction(controller);
        Scene scene = new Scene(createRewardForm(), 700, 700);
        Stage stage = new Stage();
        stage.setScene(scene);
        javafx.scene.image.Image icon = new Image("Task15/View/Oda.bmp");
        stage.setTitle("Odant");
        stage.getIcons().add(icon);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}


