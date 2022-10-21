package Task15.View;

import Task14v1.Rewards;
import Task14v1.User.Users;
import Task15.Controllers.Controller;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
public class RewardsList {

    AnchorPane anchorPane = new AnchorPane();

    TableView<Rewards> rewardTable = new TableView<>();
    TableColumn<Rewards, Integer> rewardID = new TableColumn<>("ID");
    TableColumn<Rewards, String> rewardTittle = new TableColumn<>("Наименование");
    TableColumn<Rewards, String> rewardDescription = new TableColumn<>("Описание");

    private Button add = new Button("Добавить");

    private AnchorPane createList() {
        rewardTable.getColumns().addAll(rewardID, rewardTittle, rewardDescription);
        rewardTable.setMaxSize(700, 700);
        rewardTable.setMinSize(600, 600);
        add.setLayoutX(240);
        add.setLayoutY(650);
        anchorPane.getChildren().addAll(rewardTable, add);
        return anchorPane;
    }

    private void initialize(Controller controller) {
        rewardID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        rewardTittle.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        rewardDescription.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
        rewardTable.setItems(controller.GetRewardDataFromRepository());
    }

    private void OnAddAction(Controller controller, ObservableList<Rewards> rewardsData) {
        add.setOnAction(event -> {
            Rewards selectedReward = rewardTable.getSelectionModel().getSelectedItem();
            if (selectedReward != null && !rewardsData.contains(selectedReward)) {
                rewardsData.add(controller.GetRewardFromID(selectedReward.getId()));
            }
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        });
    }

    public void startForm(Controller controller, ObservableList<Rewards> rewardsData) {
        OnAddAction(controller, rewardsData);
        initialize(controller);
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
