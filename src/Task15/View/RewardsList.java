package Task15.View;

import Task14v1.Rewards;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class RewardsList {

    AnchorPane anchorPane = new AnchorPane();

    TableView<Rewards> rewardTable = new TableView<>();
    TableColumn<Rewards, Integer> rewardID = new TableColumn<>("ID");
    TableColumn<Rewards, String> rewardTittle = new TableColumn<>("Наименование");
    TableColumn<Rewards, String> rewardDescription = new TableColumn<>("Описание");

    private Button add = new Button("Добавить");

    public AnchorPane createList () {
        rewardTable.getColumns().addAll(rewardID, rewardTittle, rewardDescription);
        rewardTable.setMaxSize(700,700);
        rewardTable.setMinSize(600,600);
        add.setLayoutX(240);
        add.setLayoutY(650);
        anchorPane.getChildren().addAll(rewardTable,add);

        return anchorPane;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
    public TableView<Rewards> getRewardTable() {
        return rewardTable;
    }
    public TableColumn<Rewards, Integer> getRewardID() {
        return rewardID;
    }
    public TableColumn<Rewards, String> getRewardTittle() {
        return rewardTittle;
    }
    public TableColumn<Rewards, String> getRewardDescription() {
        return rewardDescription;
    }
    public Button getAdd() {
        return add;
    }
    public void startForm(EventHandler eventAdd) {
        add.setOnAction(eventAdd);
        Scene scene = new Scene(createList(), 600, 700);
        Stage stage = new Stage();
        stage.setScene(scene);
        javafx.scene.image.Image icon = new Image("Task15/View/Oda.bmp");
        stage.setTitle("Odant");
        stage.getIcons().add(icon);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }


}
