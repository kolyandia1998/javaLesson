package Task14v1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static Task14v1.MainController.rewardsData;

public class RewardsListController implements IControllerFabric {

    public TableView<Rewards> TableRewards;
    public TableColumn<Rewards, Integer> RewardsID;
    public TableColumn<Rewards, String> RewardName;
    public TableColumn<Rewards, String> RewardDescription;
    private boolean ModalResult = false;
    public Button Add;

    @Override
    public Unit GetUnit() {
        return TableRewards.getSelectionModel().getSelectedItem();
    }

    public boolean GetModalResult() {
        return ModalResult;
    }
    @FXML
    private void initialize() {
        RewardsID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        RewardName.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        RewardDescription.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
        TableRewards.setItems(rewardsData);
    }

    public Rewards GetReward() {
        return (Rewards) TableRewards.getSelectionModel().getSelectedItem();
    }

    public void OnAddClick(ActionEvent event) {
        if (!(TableRewards.getSelectionModel().getSelectedItem() == null)) {
            this.ModalResult = true;
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        }
    }
}
