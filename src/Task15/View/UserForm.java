package Task15.View;

import Task14v1.Rewards;
import Task14v1.User.Users;
import Task15.Controllers.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
public class UserForm {

    public UserForm() {
    }
    public UserForm(Users users) {
        userName.setText(users.getFirstName());
        userSecondName.setText(users.getLastName());
        userBirthday.setValue(users.getBirthDay());
        userID.setText(String.valueOf(users.getId()));
        initialize(users);
    }

    private TextField userID = new TextField();
    private TextField userName = new TextField();
    private TextField userSecondName = new TextField();
    private DatePicker userBirthday = new DatePicker();

    private Label userIDLabel = new Label("ID");
    private Label userNameLabel = new Label("Имя");
    private Label userSecondNameLabel = new Label("Фамилия");
    private Label userBirthdayLabel = new Label("Дата рождения");

    private Button save = new Button("Сохранить");
    private AnchorPane anchorPane = new AnchorPane();

    private TableView<Rewards> rewardsTable = new TableView<>();

    private TableColumn<Rewards, Integer> rewardID = new TableColumn<>();
    private TableColumn<Rewards, String> rewardTittle = new TableColumn<>();

    private Button add = new Button("Добавить");
    private Button delete = new Button("Удалить");

    private HBox hBox = new HBox(add, delete);

    private AnchorPane createUserForm() {
        userID.setVisible(false);
        userIDLabel.setVisible(false);
        userID.setLayoutX(180);
        userID.setLayoutY(200);
        userIDLabel.setLayoutX(70);
        userIDLabel.setLayoutY(200);
        userID.setEditable(false);
        userName.setLayoutX(180);
        userName.setLayoutY(240);
        userNameLabel.setLayoutY(240);
        userNameLabel.setLayoutX(70);
        userSecondName.setLayoutY(280);
        userSecondName.setLayoutX(180);
        userSecondNameLabel.setLayoutX(70);
        userSecondNameLabel.setLayoutY(280);
        userBirthday.setLayoutX(180);
        userBirthday.setLayoutY(320);
        userBirthdayLabel.setLayoutY(320);
        userBirthdayLabel.setLayoutX(70);
        save.setLayoutX(300);
        save.setLayoutY(500);
        rewardID.setText("ID");
        rewardTittle.setText("Наименование");
        rewardsTable.getColumns().addAll(rewardID, rewardTittle);
        rewardsTable.setMaxSize(250, 250);
        rewardsTable.setLayoutX(400);
        rewardsTable.setLayoutY(200);
        userBirthday.setEditable(false);
        add.setLayoutX(430);
        add.setLayoutY(460);
        delete.setLayoutY(460);
        delete.setLayoutX(500);
        save.setLayoutX(330);
        save.setLayoutY(550);
        anchorPane.getChildren().addAll(userID, userIDLabel, userName, userNameLabel, userSecondName, userSecondNameLabel, userBirthday, userBirthdayLabel, rewardsTable
                , add, delete, save);
        return anchorPane;
    }
    public static void AlertWindowShow(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }

    private ObservableList<Rewards> rewardsData = FXCollections.observableArrayList();

    private void initialize(Users user) {
        rewardsData.addAll(user.rewards);
        rewardID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        rewardTittle.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        rewardsTable.setItems(rewardsData);
    }

    private void OnSaveAction(Controller controller) {
        save.setOnAction(event -> {
                    if (userBirthday.getValue() == null || LocalDate.now().compareTo(userBirthday.getValue()) < 0) {
                        AlertWindowShow("Заполните дату рождения");
                    } else {
                        Users user = new Users(userName.getText(), userSecondName.getText(), userBirthday.getValue());
                        user.rewards.addAll(rewardsTable.getItems());
                        if (userID.getText().length() > 0) {
                            user.setID(Integer.parseInt(userID.getText()));
                            controller.UpdateUser(user);
                        } else {
                            controller.AddUser(user);
                        }
                        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
                    }
                }
        );
    }

    private void OnAddAction(Controller controller) {
        add.setOnAction(event -> {
            RewardsList rewardsList = new RewardsList();
            rewardsList.startForm(controller, rewardsData);
            rewardID.setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
            rewardTittle.setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
            rewardsTable.setItems(rewardsData);
            rewardsTable.refresh();
        });
    }

    private void OnDeleteAction(Controller controller) {
        delete.setOnAction(event -> {
            Rewards selectedReward = rewardsTable.getSelectionModel().getSelectedItem();
            rewardsData.remove(selectedReward);
            controller.DeleteRewardFromUser(Integer.parseInt(userID.getText()), selectedReward.getId());
            rewardsTable.refresh();
        });
    }

    public void startForm(Controller controller) {
        OnDeleteAction(controller);
        OnAddAction(controller);
        OnSaveAction(controller);
        Scene scene = new Scene(createUserForm(), 700, 700);
        Stage stage = new Stage();
        stage.setScene(scene);
        javafx.scene.image.Image icon = new Image("Task15/View/Oda.bmp");
        stage.setTitle("Odant");
        stage.getIcons().add(icon);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
