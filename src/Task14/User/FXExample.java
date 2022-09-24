package Task14.User;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FXExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ODANT");
        Image image = new Image("C:\\Users\\ArtemS\\Desktop\\Oda.bmp");
        primaryStage.getIcons().add(image);
        primaryStage.setWidth(800);
        primaryStage.setHeight(750);

        Group group = new Group();


        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
