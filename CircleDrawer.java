import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


/**
 * A class that represents a drawer of a circle shape.
 * This class extends the Drawer class.
 * This class is used to create a circle shape on the drawing area.
 */
public class CircleDrawer extends Drawer {
    private Circle circle = null; // The circle that is being drawn.
    private double initialX; // The x-coordinate of the initial/starting point.
    private double initialY; // The y-coordinate of the initial/starting point.

    /**
     * Constructor of the CircleDrawer class.
     * @param pane The drawing area. 
     */
    public CircleDrawer(Pane pane) {
        super(pane);
    }
    

    /**
     * Start drawing a circle when the mouse is pressed.
     * @param e The mouse event.
     */
    @Override
    public void startDrawing(MouseEvent e) {
        initialX = e.getX(); // Get the x-coordinate of the mouse as the initial point.
        initialY = e.getY(); // Get the y-coordinate of the mouse as the initial point.
        circle = new MyCircle();
        circle.setCenterX(initialX); // Set the x-coordinate of the center of the circle.
        circle.setCenterY(initialY); // Set the y-coordinate of the center of the circle.
        pane.getChildren().add(circle); // Add the circle to the drawing area.
    }

    /**
     * Continue drawing a circle when the mouse is dragged.
     * @param e The mouse event.
     */
    @Override
    public void continueDrawing(MouseEvent e) {
        circle.setCenterX((initialX + e.getX()) / 2); // Change the position of the center of the circle.
        circle.setCenterY((initialY + e.getY()) / 2);
        double radius = (Math.abs(e.getX() - initialX) + Math.abs(e.getY() - initialY)) / (Math.sqrt(2)*2); // Calculate the radius of the circle.
        circle.setRadius(radius); // Set the radius of the circle.

    }
    /**
     * Stop drawing a circle when the mouse is released.
     * @param e The mouse event.
     */
    @Override
    public void stopDrawing(MouseEvent e) {
        circle = null;
    }

}
