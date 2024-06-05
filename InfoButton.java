import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;


/**
 * A class that represents an info button.
 * This class is used to create an info button that shows the information about the program.
 */
public class InfoButton extends Button {
    
    /**
     * Constructor of the InfoButton class.
     * @param menu The menu that contains the info button.
     */
    public InfoButton(HBox menu) {
        prefWidthProperty().bind(menu.widthProperty().multiply(0.125)); // Set the preferred width of the button.
        prefHeightProperty().bind(menu.heightProperty()); // Set the preferred height of the button.
        setText("INFO");

        // Set the action of the button.
        setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Program Info"); // Set the title of the alert.
            alert.setHeaderText("Author: Dominik Galus\nProgram: Figure Drawing App"); // Info about author and program.
            
            String shapes = "To modify the figures that are placed on the panel, simply click on them interact\n"; // Info about the shapes.
            String resize = "To resize figure: scroll up or down\n"; // Info about resizing.
            String rotate = "To rotate figure: hold the control and scroll up or down\n"; // Info about rotating.
            String delete = "To delete the selected figure: click backspace\n"; // Info about deleting.
            String color = "To change the color of the active figure: you need to right click on the active figure and the menu with colors will pop up"; // Info about changing the color.

            alert.setContentText(shapes + resize + rotate + delete + color);
            
            
            alert.showAndWait();
        });
    }


}
