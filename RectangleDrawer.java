import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * A class that represents a drawer of a rectangle shape.
 * This class extends the Drawer class.
 * This class is used to create a rectangle shape on the drawing area.
 */
public class RectangleDrawer extends Drawer {
    private Rectangle rectangle = null; // The rectangle that is being drawn.
    private double initialX; // The x-coordinate of the initial/starting point.
    private double initialY; // The y-coordinate of the initial/starting point.

    /**
     * Constructor of the RectangleDrawer class.
     * With the given drawing area, the constructor initializes the drawing area.
     * @param pane The drawing area. 
     */
    public RectangleDrawer(Pane pane) {
        super(pane);
    }

    /**
     * Start drawing a rectangle when the mouse is pressed.
     * @param e The mouse event.
     */
    @Override
    public void startDrawing(MouseEvent e) {
        
        if(e.getButton() == MouseButton.PRIMARY) {
            initialX = e.getX(); // Get the coordinates of the mouse as the initial point.
            initialY = e.getY();
            rectangle = new MyRectangle(); 
            rectangle.setX(initialX); // Set the x-coordinate of the rectangle.
            rectangle.setY(initialY); // Set the y-coordinate of the rectangle.
            pane.getChildren().add(rectangle); // Add the rectangle to the drawing area.
        }
    }
    
    /**
     * Continue drawing a rectangle when the mouse is dragged.
     * @param e The mouse event.
     */
    @Override
    public void continueDrawing(MouseEvent e) {
        rectangle.setWidth(Math.abs(e.getX() - initialX)); // Change the width and height of the rectangle based on the mouse movement.
        rectangle.setHeight(Math.abs(e.getY() - initialY));
        rectangle.setX(Math.min(e.getX(), initialX)); // Change the position of first corner of the rectangle based on the mouse movement.
        rectangle.setY(Math.min(e.getY(), initialY)); // To prevent negative width and height.
        rectangle.setStroke(Color.BLACK); // Set the stroke color of the rectangle.
    }

    /**
     * Stop drawing a rectangle when the mouse is released.
     * @param e The mouse event.
     */
    @Override
    public void stopDrawing(MouseEvent e) {
        rectangle = null;
    }

}
