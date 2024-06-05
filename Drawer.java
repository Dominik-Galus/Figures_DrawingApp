import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 * A class that represents a drawer.
 * This class is used to create a drawer to draw shapes on the drawing area.
 * The selected color and the drawing area are stored in this class.
 */
public abstract class Drawer {
    protected Color selectedColor; // The selected color.
    protected Pane pane; // The drawing area.

    /**
     * Constructor of the Drawer class.
     * @param pane The drawing area.
     */
    public Drawer(Pane pane) {
        this.pane = pane; // Set the drawing area.
    }

    public abstract void startDrawing(MouseEvent e);
    public abstract void continueDrawing(MouseEvent e);
    public abstract void stopDrawing(MouseEvent e);

}
