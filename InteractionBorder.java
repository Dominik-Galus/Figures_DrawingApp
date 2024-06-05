import java.io.Serializable;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 * A class that represents a border around a shape.
 * This class extends the Rectangle class and implements the Serializable interface.
 * This class is used to create a border around a shape when user interacts with shape.
 */
public class InteractionBorder extends Rectangle implements Serializable {

    /**
     * Constructor of the InteractionBorder class.
     * That calls the constructor of the Rectangle class.
     */
    public InteractionBorder() {
        super(); // call the constructor of the Rectangle class
    }

    /**
     * Make the border of the shape when the shape is selected
     * It adjust the border to the shape size and position
     * 
     * @param shape
     */
    public void CreateBorder(Shape shape) {
        this.setWidth(shape.getBoundsInParent().getWidth()); // set the width and height of the border to the shape
        this.setHeight(shape.getBoundsInParent().getHeight());
        setLayoutX(shape.getBoundsInParent().getMinX()); // set the x and y of the border to the shape
        setLayoutY(shape.getBoundsInParent().getMinY());
        setFill(null); // set the fill of the border to null
        setStroke(Color.CHOCOLATE); // set the color of the border
        setStrokeWidth(4); // set the width of the border
    }
}