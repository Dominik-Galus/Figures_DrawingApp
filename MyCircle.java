import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * A class that represents a circle shape.
 * This class extends the Circle class and implements the Serializable interface.
 * This class is used to create a circle shape that can be serialized and deserialized.
 */
public class MyCircle extends Circle implements Serializable {
    
    private Color color; // The fill color of the circle.

    /**
     * Constructor of the MyCircle class.
     * Initializes the stroke color to black and the fill color to white.
     */
    public MyCircle() {
        setStroke(Color.BLACK);
        color = Color.WHITE;
        setFill(color);

    }

    /**
     * Writes the state of the circle to an ObjectOutputStream during serialization.
     * The state includes the center, radius, layout x and y, scale x and y, color, stroke width, and translation.
     * @param s The ObjectOutputStream to which to write the state.
     * @throws IOException If an I/O error occurs while writing to the ObjectOutputStream.
     */
    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        color = (Color) getFill();
        s.writeDouble(getCenterX()); // saves the center
        s.writeDouble(getCenterY());
        s.writeDouble(getRadius()); // saves the radius
        s.writeDouble(getLayoutX()); // saves layout x and y
        s.writeDouble(getLayoutY());
        s.writeDouble(getScaleX()); // saves scale x and y
        s.writeDouble(getScaleY());
        s.writeDouble(color.getRed()); // saves color
        s.writeDouble(color.getGreen());
        s.writeDouble(color.getBlue());
        s.writeDouble(color.getOpacity());
        s.writeDouble(getStrokeWidth()); // saves stroke width
    }

    /**
     * Reads the state of the circle from an ObjectInputStream during deserialization.
     * The state includes the center, radius, layout x and y, scale x and y, and color.
     * @param s The ObjectInputStream from which to read the state.
     * @throws IOException If an I/O error occurs while reading from the ObjectInputStream.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    @Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        setCenterX(s.readDouble()); // reads the center
        setCenterY(s.readDouble());
        setRadius(s.readDouble()); // reads the radius
        setLayoutX(s.readDouble()); // reads layout x and y
        setLayoutY(s.readDouble());
        setScaleX(s.readDouble()); // reads scale x and y
        setScaleY(s.readDouble());
        color = new Color(s.readDouble(), s.readDouble(), s.readDouble(), s.readDouble()); // reads color
        setFill(color); // sets the fill color
        setStrokeWidth(s.readDouble()); // reads stroke width
        setStroke(Color.BLACK); // sets the stroke color to black
    }

}
