import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


/**
 * A class that represents a shape button.
 * This class is used to create a shape button that allows the user to draw a specific shape.
 * The drawer of the shape is stored in this class.
 */
public class ShapeButton extends Button {

    private final Drawer drawer; // The drawer of the shape;


    /**
     * Constructor of the ShapeButton class.
     * Initializes the preferred width and height of the shape button.
     * Sets the drawer type of the shape and the text of the shape button.
     * @param menu The horizontal box that contains the shape buttons.
     * @param drawer The drawer of the shape.
     * @param text The text of the shape button.
     */
    public ShapeButton(HBox menu, Drawer drawer, String text) {
        this.prefHeightProperty().bind(menu.heightProperty()); // Set the preferred height and width of the shape button.
        this.prefWidthProperty().bind(menu.widthProperty().multiply(0.125));
        this.setText(text);
        this.drawer = drawer; // Set the drawer of the shape.

        // Set the action of the shape button.
        this.setOnAction(e -> {
            MyHBox.setCurrentDrawer(drawer); // Set the drawer of the drawing area to the drawer of the shape button.
        });
    }



}