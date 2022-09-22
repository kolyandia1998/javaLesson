package Task14;

import Task14.User.Users;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.awt.*;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView table = new TableView();
        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("Имя");
        TableColumn lastNameCol = new TableColumn("Фамилия");
        TableColumn emailCol = new TableColumn("Электронная почта");

        table.getColumns().addAll (firstNameCol, lastNameCol, emailCol);
        Scene primaryScene = new Scene(table);
        primaryStage.setScene(primaryScene);
        primaryStage.show();

    }

    }


