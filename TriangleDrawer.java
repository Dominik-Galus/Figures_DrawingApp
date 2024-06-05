import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


/**
 * A class that represents a drawer of a triangle shape.
 * This class extends the Drawer class.
 * This class is used to create a triangle shape on the drawing area.
 */
public class TriangleDrawer extends Drawer {
    private MyTriangle triangle = null; // The triangle that is being drawn.
    private double initialX; // The x-coordinate of the initial/starting point.
    private double initialY; // The y-coordinate of the initial/starting point.

    /**
     * Constructor of the TriangleDrawer class.
     * With the given drawing area, the constructor initializes the drawing area.
     * @param pane The drawing area. 
     */
    public TriangleDrawer(Pane pane) {
        super(pane);
    }

    /**
     * Start drawing a triangle when the mouse is pressed.
     * @param e The mouse event.
     */
    @Override
    public void startDrawing(MouseEvent e) {
        initialX = e.getX(); // Get the x-coordinate of the mouse as the initial point.
        initialY = e.getY(); // Get the y-coordinate of the mouse as the initial point.
        triangle = new MyTriangle();
        triangle.getPoints().addAll( // Set the starting points of the triangle.
            initialX, initialY,
            initialX, initialY,
            initialX, initialY
        );
        pane.getChildren().add(triangle); // Add the triangle to the drawing area.
    }

    /**
     * Continue drawing a triangle when the mouse is dragged.
     * @param e The mouse event.
     */
    @Override
    public void continueDrawing(MouseEvent e) {
        triangle.getPoints().set(0, Math.abs(initialX + e.getX()) / 2); // Change the position of the center of the triangle.
        triangle.getPoints().set(3, e.getY()); // Change the position of the third corner of the triangle.
        triangle.getPoints().set(4, e.getX()); // Change the position of the second corner of the triangle.
        triangle.getPoints().set(5, e.getY()); // Change the position of the fifth corner of the triangle.
    }

    /**
     * Stop drawing a triangle when the mouse is released.
     * @param e The mouse event.
     */
    @Override
    public void stopDrawing(MouseEvent e) {
        triangle = null;
    }

}
