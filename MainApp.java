import javafx.application.Application;
import javafx.stage.Stage;


/**
 * The MainApp class is the entry point of the application.
 * This class extends the Application class.
 * The main method is called to launch the application.
 */
public class MainApp extends Application {
    /**
     * The main method is called to launch the application.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method is called to start the application.
     * @param stage The primary stage of the application.
     */
    @Override
    public void start(Stage stage) {
        new MainUI(stage);
    }
}