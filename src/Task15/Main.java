package Task15;

import Task14v1.Rewards;
import Task14v1.User.Users;
import Task15.Controllers.Controller;
import Task15.Repository.Repository;
import Task15.View.MainView;
import Task15.View.RewardsList;
import Task15.View.UserForm;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainView mainView = new MainView();
        Controller controller = new Controller();
        mainView.startForm(controller);
    }

    public static void main(String[] args) {
        launch(args);
    }
}