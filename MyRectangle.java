import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * A class that represents a rectangle shape.
 * This class extends the Rectangle class and implements the Serializable interface.
 * This class is used to create a rectangle shape that can be serialized and deserialized.
 */
public class MyRectangle extends Rectangle implements Serializable {

    private Color color; // The fill color of the rectangle.


    /**
     * Constructor of the MyRectangle class.
     * Initializes the fill color to white.
     */
    public MyRectangle() {
        super();
        color = Color.WHITE;
        setFill(color);
    }

    /**
     * Writes the state of the rectangle to an ObjectOutputStream during serialization.
     * The state includes the original and layout x and y coordinates, the width and height, the scale x and y, the rotation, the color, the stroke width, and the translation.
     * @param s The ObjectOutputStream to which to write the state.
     * @throws IOException If an I/O error occurs while writing to the ObjectOutputStream.
     */
    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        color = (Color) getFill();
        s.writeDouble(getX()); // saves original x and y
        s.writeDouble(getY());
        s.writeDouble(getLayoutX()); // saves layout x and y
        s.writeDouble(getLayoutY());
        s.writeDouble(getWidth()); // saves width and height
        s.writeDouble(getHeight());
        s.writeDouble(getScaleX()); // saves scale x and y
        s.writeDouble(getScaleY());
        s.writeDouble(getRotate()); // saves rotation
        s.writeDouble(color.getRed()); // saves color
        s.writeDouble(color.getGreen());
        s.writeDouble(color.getBlue());
        s.writeDouble(color.getOpacity());
        s.writeDouble(getStrokeWidth()); // saves stroke width
    }

    /**
     * Reads the state of the rectangle from an ObjectInputStream during deserialization.
     * The state includes the original and layout x and y coordinates, the width and height, the scale x and y, the rotation, and the color.
     * @param s The ObjectInputStream from which to read the state.
     * @throws IOException If an I/O error occurs while reading from the ObjectInputStream.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    @Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        setX(s.readDouble()); // reads original x and y
        setY(s.readDouble());
        setLayoutX(s.readDouble()); // reads layout x and y
        setLayoutY(s.readDouble());
        setWidth(s.readDouble()); // reads width and height
        setHeight(s.readDouble());
        setScaleX(s.readDouble()); // reads scale x and y
        setScaleY(s.readDouble());
        setRotate(s.readDouble()); // reads rotation
        color = new Color(s.readDouble(), s.readDouble(), s.readDouble(), s.readDouble()); // reads color
        setFill(color);
        setStrokeWidth(s.readDouble()); // reads stroke width
        setStroke(Color.BLACK); // set stroke color
    }

}