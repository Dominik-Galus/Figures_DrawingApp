import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * A class that represents the main user interface of the application.
 * This class is used to create the main user interface of the application.
 * The main user interface consists of a menu bar, a horizontal box for the buttons, and a drawing area.
 */
public class MainUI {

    /**
     * Constructor of the MainUI class.
     * This constructor creates the main user interface of the application.
     * It creates the menu bar, the horizontal box for the buttons, and the drawing area.
     * @param stage The primary stage of the application.
     */
    public MainUI(Stage stage) {
        
        VBox root = new VBox(); // Create a vertical box for the menu bar, buttons, and drawing area.
        root.setPrefSize(1000, 1000);

        HBox menu = new MyHBox(root); // Create a horizontal box for the buttons.
        MyPane drawingArea = new MyPane(root); // Create a drawing area.
        Button rectButton = new ShapeButton(menu, new RectangleDrawer(drawingArea), "Rectangle"); // Create a rectangle button 
        Button circButton = new ShapeButton(menu, new CircleDrawer(drawingArea), "Circle"); // Create a circle button
        Button triangleButton = new ShapeButton(menu, new TriangleDrawer(drawingArea), "Triangle"); // Create a triangle button
        Button infoButton = new InfoButton(menu); // Create an info button
        //ColorPicker colorPicker = new MyColorPicker(menu);
        MenuBar fileBar = new MyFileBar(drawingArea, root); // Create a menu bar for the file options.

        menu.setBackground(new Background(new BackgroundFill(Color.AQUA, new CornerRadii(2f), Insets.EMPTY))); // Set the background color of the menu.
        //menu.getChildren().add(colorPicker);
        menu.getChildren().add(rectButton); // Add the buttons to the menu.
        menu.getChildren().add(circButton);
        menu.getChildren().add(triangleButton);
        menu.getChildren().add(infoButton);
        root.getChildren().add(fileBar); // Add the containers to the root.
        root.getChildren().add(menu);
        root.getChildren().add(drawingArea);
        Scene scene = new Scene(root); // Create a scene with the root.
        stage.setTitle("Paint_FX");
        stage.setScene(scene); // Set the scene to the stage.
        stage.show(); // Show the stage.
    }
}