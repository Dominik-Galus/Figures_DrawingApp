import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;


/**
 * A class that represents a menu bar for the file menu.
 * This class extends the MenuBar class and is used to create a menu bar for the file menu.
 * The file menu contains options to save and load the scene.
 */
public class MyFileBar extends MenuBar {

    Pane pane; // The drawing area.

    /**
     * Constructor of the MyFileBar class.
     * This constructor creates a menu bar for the file menu.
     * The file menu contains options to save and load the scene.
     * @param pane The drawing area.
     * @param root The root container.
     */
    public MyFileBar(Pane pane, VBox root) {
        this.pane = pane; // Set the drawing area.
        prefWidthProperty().bind(pane.widthProperty());
        prefHeightProperty().bind(root.heightProperty().multiply(0.05));

        Menu file = new Menu("File"); // Create a file menu.
        MenuItem save = new MenuItem("Save"); // Create a save menu item.
        save.setOnAction(e -> saveScene()); // Set the action of the save menu item.

        MenuItem load = new MenuItem("Load"); // Create a load menu item.
        load.setOnAction(e -> loadScene()); // Set the action of the load menu item.
        file.getItems().add(save);
        file.getItems().add(load);
        getMenus().addAll(file);
    }

    /**
     * Saves the scene to a file.
     * The scene is saved as a list of nodes from the pane.
     * The file is chosen by the user with a FileChooser.
     */
    private void saveScene() {
        FileChooser fileChooser = new FileChooser(); // Create a FileChooser object to choose a file to save
        File file = fileChooser.showSaveDialog(null); // Show the save dialog and get the file to save
        if (file != null) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) { // Create an ObjectOutputStream to write the scene to the file
                ObservableList<Node> children = pane.getChildren(); // Get the list of nodes from the pane to save
                out.writeObject(new ArrayList<>(children)); // Write the list of nodes to the ObjectOutputStream
            } catch (IOException ex) {
                ex.printStackTrace(); 
            }
        }
    }

    /**
     * Loads the scene from a file.
     * The scene is loaded as a list of nodes to the pane.
     * The file is chosen by the user with a FileChooser.
     */
    private void loadScene() {
        FileChooser fileChooser = new FileChooser(); // Create a FileChooser object to choose a file to load
        File file = fileChooser.showOpenDialog(null); // Show the open dialog and get the file to load
        if (file != null) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) { // Create an ObjectInputStream to read the scene from the file
                List<Node> children = (List<Node>) in.readObject(); // Read the list of nodes from the ObjectInputStream
                pane.getChildren().setAll(children); // Set the list of nodes to the pane
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }


}



