import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Killing files");
        Image ico = new Image("images/icon.png");
        primaryStage.getIcons().add(ico);
        primaryStage.setResizable(false);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style/darkstyle.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
