package Task15.View;

import Task14v1.Rewards;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class UserForm {
    private TextField userName = new TextField();
    private TextField userSecondName = new TextField();
    private DatePicker userBirthday = new DatePicker();

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

    private HBox hBox = new HBox(add,delete);

    private AnchorPane createUserForm() {
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


        anchorPane.getChildren().addAll(userName, userNameLabel, userSecondName, userSecondNameLabel, userBirthday, userBirthdayLabel, rewardsTable
        ,add,delete,save);
        return anchorPane;
    }

    public TextField getUserName() {
        return userName;
    }
    public TextField getUserSecondName() {
        return userSecondName;
    }
    public DatePicker getUserBirthday() {
        return userBirthday;
    }
    public Label getUserNameLabel() {
        return userNameLabel;
    }
    public Label getUserSecondNameLabel() {
        return userSecondNameLabel;
    }
    public Label getUserBirthdayLabel() {
        return userBirthdayLabel;
    }
    public Button getSave() {
        return save;
    }
    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
    public TableView<Rewards> getRewardsTable() {
        return rewardsTable;
    }
    public TableColumn<Rewards, Integer> getRewardID() {
        return rewardID;
    }
    public TableColumn<Rewards, String> getRewardTittle() {
        return rewardTittle;
    }
    public Button getAdd() {
        return add;
    }
    public Button getDelete() {
        return delete;
    }
    public HBox gethBox() {
        return hBox;
    }
    public void startForm(EventHandler eventSave,EventHandler eventAdd, EventHandler eventDelet ) {
        save.setOnAction(eventSave);
        delete.setOnAction(eventDelet);
        add.setOnAction(eventAdd);
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
