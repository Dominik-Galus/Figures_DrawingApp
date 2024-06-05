import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 * A class that represents a drawing area.
 * This class extends the Pane class.
 * This class is used to create a drawing area where the shapes can be drawn and interacted with.
 */
public class MyPane extends Pane {
    
    private Shape selectedShape = null; // The selected shape that is being interacted with.
    private InteractionBorder border; // The border that is used to interact with the selected shape.
    private double offsetX; // The x-coordinate of the difference between the mouse and the shape.
    private double offsetY; // The y-coordinate of the difference between the mouse and the shape.

    public MyPane(VBox root) {
        
        this.prefWidthProperty().bind(root.widthProperty()); // Set the preferred width and height of the drawing area from the root.
        this.prefHeightProperty().bind(root.heightProperty().multiply(0.85));
        setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(2f), Insets.EMPTY))); // Set the background color of the drawing area.

        Rectangle clip = new Rectangle(); // Create a clip to prevent shapes from going outside the drawing area.
        clip.widthProperty().bind(this.widthProperty()); // Set the width and height of the clip to be the same as the drawing area.
        clip.heightProperty().bind(this.heightProperty());
        setClip(clip);

        border = new InteractionBorder(); // Create an interaction border.
        border.setVisible(false); 
        getChildren().add(border); // Add the interaction border to the drawing area.


        // Set the action of the drawing area when the mouse is clicked.
        this.setOnMouseClicked(e -> {

            // If the target of the mouse event is a shape, then select the shape.
            if(e.getTarget() instanceof Shape) {
                if(e.getButton() == MouseButton.PRIMARY) { // If the left mouse button is clicked, then select the shape.
                    selectedShape = (Shape) e.getTarget(); // Set the selected shape.

                    this.requestFocus(); // Focus the pane to enable key events

                    border.CreateBorder(selectedShape); // Create a border around the selected shape.
                    border.setVisible(true); // Set the border to be visible.

                    getChildren().remove(border); // bring the interaction border to top
                    getChildren().add(border);//
                }
                    getChildren().remove(selectedShape); // bring shape to top
                    getChildren().add(selectedShape); //

                if(e.getButton() == MouseButton.SECONDARY) { // If the right mouse button is clicked, then create a color picker.
                    MyColorPicker colorPicker = new MyColorPicker(selectedShape, this); // Create a color picker for the selected shape to change its color.
                    getChildren().add(colorPicker); // Add the color picker to the drawing area.
                    colorPicker.setLayoutX(e.getX()); // Set the coordinates of the color picker.
                    colorPicker.setLayoutY(e.getY());
                }
            }
            // If the target of the mouse event is not a shape, then deselect the shape.
            else {
                selectedShape = null;
                border.setVisible(false); // Set the border to be invisible.
            }
        });

        // Set the action of the drawing area when the mouse is pressed.
        this.setOnMousePressed(e -> {
            if(e.getButton() == MouseButton.PRIMARY) { // If the left mouse button is pressed, then start dragging the shape.
                Drawer drawer = MyHBox.getCurrentDrawer(); // Set the current drawer of the drawing area to draw a shape.
                if(selectedShape != null) { // If a shape is selected, then start dragging the shape.
                    offsetX = e.getSceneX() - selectedShape.getLayoutX(); // Set the offset coordinates of the shape.
                    offsetY = e.getSceneY() - selectedShape.getLayoutY();
                }
                else if(drawer != null) { // If a drawer is selected but no shape is selected, then start drawing a shape.
                    drawer.startDrawing(e);
                }            
            }
        });

        // Set the action of the drawing area when the mouse is dragged.
        this.setOnMouseDragged(e -> {
            if(e.getButton() == MouseButton.PRIMARY) { // If the left mouse button is dragged, then drag the shape.
                Drawer drawer = MyHBox.getCurrentDrawer(); // Set the current drawer of the drawing area to draw a shape.
                if(selectedShape != null) { // If a shape is selected, then drag the shape.
                    selectedShape.setLayoutX(e.getSceneX() - offsetX); // Move the shape to the new coordinates of the mouse event minus the offset.
                    selectedShape.setLayoutY(e.getSceneY() - offsetY);
                    border.CreateBorder(selectedShape); // Create a border around the selected shape.
                } else if(drawer != null) { // If a drawer is selected but no shape is selected, then continue drawing a shape.
                    drawer.continueDrawing(e); // Continue drawing the shape.
                }
            }
        });

        // Set the action of the drawing area when the mouse is released.
        this.setOnMouseReleased(e -> {
            Drawer drawer = MyHBox.getCurrentDrawer(); // Set the current drawer of the drawing area to draw a shape.
            if(selectedShape != null) { // If a shape is selected, then stop dragging the shape.
                offsetX = e.getSceneX(); // Set the ending offset coordinates of the shape.
                offsetY = e.getSceneY(); 
            } else if(drawer != null) {
                drawer.stopDrawing(e);
            }
        });

        // Set the action of the drawing area when the mouse is scrolled.
        this.setOnScroll(e -> {
            double zoomFactor = 1.05; // Set the zoom factor.
            double deltaY = e.getDeltaY(); // Get the y-coordinate of the mouse event.
            if(deltaY < 0) { 
                zoomFactor = 2.0 - zoomFactor; 
            }
            if(e.isControlDown()) { // If the control key is pressed, then rotate the selected shape.
                selectedShape.setRotate(selectedShape.getRotate() + e.getDeltaY() / 2); // Rotate the selected shape.
                border.CreateBorder(selectedShape); // Create a border around the rotated shape.
            } else { // If not, scale the selected shape
            selectedShape.setScaleX(selectedShape.getScaleX() * zoomFactor); // Scale the selected shape.
            selectedShape.setScaleY(selectedShape.getScaleY() * zoomFactor); // Scale the selected shape.
            border.CreateBorder(selectedShape); // Create a border around scaled shape.
            }
        });

        this.setFocusTraversable(true); // Enable key events

        // Set the action of the drawing area when a key is pressed.
        this.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.BACK_SPACE) { // If the backspace key is pressed, then delete the selected shape.
                if(selectedShape != null) {
                    getChildren().remove(selectedShape); // Remove the selected shape from the drawing area.
                    selectedShape = null; // Set the selected shape to null.
                    border.setVisible(false); // Set the border to be invisible.
                }
            }
        });

    }

}
