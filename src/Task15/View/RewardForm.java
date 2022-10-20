package Task15.View;

import Task14v1.Rewards;
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
  private   AnchorPane anchorPane = new AnchorPane();

  private TextField rewardTittle = new TextField();
  private TextArea  rewardDescription = new TextArea();

  private Button save = new Button("Сохранить");

  private final Label  labelID = new Label("ID");
  private final Label  labelTittle = new Label("Наименование");
  private final Label  labelDescription = new Label("Описание");



  public AnchorPane createRewardForm () {



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
      anchorPane.getChildren().addAll( rewardTittle, rewardDescription,save,labelID,labelTittle,labelDescription);

      return anchorPane;
  }

    public TextField getRewardTittle() {
        return rewardTittle;
    }
    public TextArea getRewardDescription() {
        return rewardDescription;
    }
    public Button getSave() {
        return save;
    }


    public void startForm(EventHandler event) {
          save.setOnAction(event);
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


