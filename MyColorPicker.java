import java.io.Serializable;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * A class that represents a color picker.
 * This class extends the ColorPicker class.
 * This class is used to create a color picker to change the color of the given shape.
 * The selected color is stored in this class.
 */
public class MyColorPicker extends ColorPicker implements Serializable {

    private Color selectedColor; // Color selected by the user to fill the shape.

    public MyColorPicker(Shape shape, Pane pane) {

        setPrefWidth(150);;
        setPrefHeight(45);

        setOnAction(e -> {
            selectedColor = this.getValue(); // get the selected color from user
            shape.setFill(selectedColor);  // set the fill of the selected shape to the selected color
            setVisible(false); // hide the color picker
            pane.getChildren().remove(this); // remove the color picker from the drawing area
        });

    }
    
}
