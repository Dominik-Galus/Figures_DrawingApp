import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


/**
 * A class that represents a triangle shape.
 * This class extends the Polygon class and implements the Serializable interface.
 * This class is used to create a triangle shape that can be serialized and deserialized.
 */
public class MyTriangle extends Polygon implements Serializable {

    private Color color; // The fill color of the triangle.


    /**
     * Constructor of the MyTriangle class.
     * Initializes the stroke color to black and the fill color to white.
     */
    public MyTriangle() {
        setStroke(Color.BLACK);;
        color = Color.WHITE;
        setFill(color);

    }

    /**
     * Writes the state of the object to an ObjectOutputStream.
     * This method is called when the object is being serialized.
     * @param s The ObjectOutputStream to write to.
     * @throws IOException If an I/O error occurs while writing to the stream.
     */
    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        color = (Color) getFill(); // gets the fill color of the triangle
        s.writeObject(getPoints().toArray(new Double[0])); // saves points
        s.writeDouble(getLayoutX()); // saves layout x and y
        s.writeDouble(getLayoutY());
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
     * Reads the state of the object from an ObjectInputStream.
     * This method is called when the object is being deserialized.
     * @param s The ObjectInputStream to read from.
     * @throws IOException If an I/O error occurs while reading from the stream.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    @Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        getPoints().setAll((Double[]) s.readObject()); // reads points
        setLayoutX(s.readDouble()); // reads layout x and y
        setLayoutY(s.readDouble());
        setScaleX(s.readDouble()); // reads scale x and y
        setScaleY(s.readDouble());
        setRotate(s.readDouble()); // reads rotation
        color = new Color(s.readDouble(), s.readDouble(), s.readDouble(), s.readDouble()); // reads color
        setFill(color);
        setStrokeWidth(s.readDouble()); // reads stroke width
        setStroke(Color.BLACK); // sets stroke color to black
    }


}
