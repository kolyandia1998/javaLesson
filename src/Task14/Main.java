package Task14;

import Task14.User.Users;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.InputStream;
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
        primaryStage.setTitle("ODANT");
        Image image = new Image("C:\\Users\\ArtemS\\Desktop\\Oda.bmp");
        primaryStage.getIcons().add(image);
        primaryStage.setWidth(800);
        primaryStage.setHeight(750);




        javafx.scene.control.Button button = new javafx.scene.control.Button();
          button.setText("Click");
          button.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent actionEvent) {
                     TableView RewardsView = new TableView();
                     UnitFactory unitFactory = new UnitFactory();
                     ObservableList<Users> data = FXCollections.emptyObservableList();

                          TableColumn ID = new TableColumn("ID");
                     TableColumn RewardsName = new TableColumn("Reward name");
                     RewardsView.getColumns().addAll(ID,RewardsName);
                     Scene RewardsScene = new Scene(RewardsView);

                     RewardsView.getItems();
                     primaryStage.setScene(RewardsScene);
                   /*  RewardsView.getColumns().add(ID);*/

              }
          });
          Scene scene = new Scene(button);
          primaryStage.setScene(scene);





    /*    TableView table = new TableView();
        table.setEditable(true);
        TableView RewardsTable = new TableView();
        TableColumn ColID = new TableColumn("ID");
        TableColumn ColTitle = new TableColumn("Title");
        TableColumn ColDescription = new TableColumn("Description");
        RewardsTable.getColumns().addAll(ColID,ColTitle,ColDescription);
        TableColumn firstNameCol = new TableColumn("Имя");
        TableColumn lastNameCol = new TableColumn("Фамилия");
        TableColumn emailCol = new TableColumn("Электронная почта");
        table.getColumns().addAll (firstNameCol, lastNameCol, emailCol);
        Scene primaryScene = new Scene(table);
        Scene RewardsScene = new Scene(RewardsTable);
        primaryStage.setScene(primaryScene);
        primaryStage.setScene(RewardsScene);*/

        primaryStage.show();

    }

    }


