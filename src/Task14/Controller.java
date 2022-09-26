package Task14;

import Task14.User.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class Controller {

    private final ObservableList<Users> usersData = FXCollections.observableArrayList();
    @FXML
    private Button add = new Button("Add");
    @FXML
    private Button delete = new Button("Delete");
    @FXML
    private TableView<Users> tableUsers;
    @FXML
    private TableColumn<Users, Integer> idColumn;
    @FXML
    private TableColumn<Users, String> nameColumn;
    @FXML
    private TableColumn<Users, String> secondNameColumn;
    @FXML
    private TableColumn<Users, LocalDate> BirthdayColumn;




    @FXML
    private void initialize() {

        initData();


        idColumn.setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Users, String>("FirstName"));
        secondNameColumn.setCellValueFactory(new PropertyValueFactory<Users, String>("LastName"));
        BirthdayColumn.setCellValueFactory(new PropertyValueFactory<Users, LocalDate>("BirthDay"));
        tableUsers.setItems(usersData);

    }
    private void initData() {
        add.setOnAction(actionEvent -> {
            Parent root;
            try {

                  root = FXMLLoader.load(getClass().getResource("views/UserCreaterView.fxml"));
                Stage stage = new Stage();
                stage.setTitle("My New Stage Title");
                stage.setScene(new Scene(root, 450, 450));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } );
        delete.setOnAction(actionEvent ->  usersData.remove(tableUsers.getSelectionModel().getSelectedItem()));
    }
    }