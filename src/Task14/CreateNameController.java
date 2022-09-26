package Task14;

import Task14.User.Users;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.lang.model.element.Name;

public class CreateNameController {



    @FXML
    private TextField Name;
    @FXML
    private TextField SecondName;
    @FXML
    private DatePicker BirthDay;

    @FXML
    private Button save;

    public void initData () {

         save.setOnAction(actionEvent -> { new Users(Name.getPromptText(), SecondName.getPromptText(), BirthDay.getValue());});
}
}