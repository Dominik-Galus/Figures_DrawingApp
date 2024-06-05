import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * A class that represents a horizontal box of the buttons.
 * This class extends the HBox class.
 * This class is used to create a horizontal box for the buttons in the application.
 * The current drawer is stored in this class.
 */
public class MyHBox extends HBox {
    private static Drawer currentDrawer; // The current drawer of the application that is used to draw shapes.

    /**
     * Constructor of the MyHBox class.
     * Initializes the preferred width and height of the horizontal box.
     * @param root The vertical box that contains the horizontal box.
     */
    public MyHBox(VBox root) {
        this.prefWidthProperty().bind(root.widthProperty());
        this.prefHeightProperty().bind(root.heightProperty().multiply(0.1));
    }

    /**
     * Returns the current drawer.
     * @return The current drawer.
     */
    public static Drawer getCurrentDrawer() {
        return currentDrawer;
    }

    /**
     * Sets the current drawer.
     * @param drawer The drawer to set as the current drawer.
     */
    public static void setCurrentDrawer(Drawer drawer) {
        currentDrawer = drawer;
    }

}
