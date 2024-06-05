# Program Description
In this program you can draw with mouse figures between **Rectangle**, **Circle** and **Triangle**. <br>
This drawing app let you **interact** and **modify** the figures on the screen. <br>
The options to modify the figures on the screen are: <br>
    - Scaling by using mouse scroll <br>
    - Rotating by holding the control button and using mouse scroll <br>
    - Deleting the figure by pressing the backspace button <br>

The Program also supports saving the figures from the screen to file and load from the other files
## Ovierview
- [MainApp](classMainApp.html) - Entry point of the application.
    - [MainUI](classMainUI.html) - Main user interface of the application.
        - [MyFileBar](classMyFileBar.html) - Menu for saving the figures to the file and to load from the other files.
        - [MyHBox](classMyHBox.html) - Horizontal box that contains Shape buttons and also info buttons.
            - [ShapeButton](classShapeButton.html) - Button that sets the type of figure to be drawn.
            - [InfoButton](classInfoButton.html) - Button that shows the information about the application.
        - [MyPane](classMyPane.html) - The drawing area which handles mouse and key events.
            - [Drawer](classDrawer.html) - The class that is drawing the selected type of figure.
                - [RectangleDrawer](classRectangleDrawer.html) - The drawer that is drawing the rectangle shape.
                  - [MyRectangle](classMyRectangle.html) - The rectangle shape which can be chosen by user.
                - [CircleDrawer](classCircleDrawer.html) - The drawer that are drawing the circle shape.
                    - [MyCircle](classMyCircle.html) - The circle shape which can be chosen by user.
                - [TriangleDrawer](classTriangleDrawer.html) - The drawer that are drawing the cricle shape.
                    - [MyTriangle](classMyTriangle.html) - The triangle shape which can be chosen by user.
            - [InteractionBorder](classInteractionBorder.html) - The border that shows which figure is selected.
            - [MyColorPicker](classMyColorPicker.html) - The color picker where user can choose a color to modify the fill of the figure.