import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This is the driver class of the App
 */
public class ScreenSaver extends Application {
    final int WIDTH = 600;
    final int HEIGHT = 600;

    /**
     * Driver function
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // start the app
        launch(args);
    }

    /**
     * Overridden from JavaFX Application. Starts the app
     * @param stage Stage of application
     * @throws Exception exception handling
     */
    @Override
    public void start(Stage stage) throws Exception {

        // load fxml file
        Parent root = FXMLLoader.load(getClass().getResource("ScreenSaver.fxml"));
        stage.setTitle("Screen Saver");
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        stage.setHeight(HEIGHT);
        stage.setWidth(WIDTH);
        stage.setScene(scene);

        // show the stage
        stage.show();
    }

}
