package vectordrawing.view;

import vectordrawing.controller.DrawerController;
import vectordrawing.model.DrawerModel;
import vectordrawing.model.Shape;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;

/**
 * A class for the view component.
 */
public class DrawerView {

    private static final String FRAME_TITLE = "StacsPaint";
    private static final int DEFAULT_FRAME_WIDTH = 600;
    private static final int DEFAULT_FRAME_HEIGHT = 800;

    private final DrawerModel drawerModel;
    private final DrawerController drawerController;


    private final JFrame mainFrame;
    private final JToolBar buttonBar;
    private final JToolBar colorBar;
    private final DrawerCanvas canvas;

    private Shape selectedShape;
    private Color color;

    /**
     * A constructor for the DrawerView class.
     * @param drawerModel An instance of the model component.
     * @param drawerController An instance of the controller component.
     */
    public DrawerView(DrawerModel drawerModel, DrawerController drawerController) {
        this.drawerModel = drawerModel;
        this.drawerController = drawerController;

        // Initialise main frame
        mainFrame = new JFrame(FRAME_TITLE);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT); // Set frame size

        this.buttonBar = renderButtonBar();
        this.colorBar = renderBottomBar();
        this.canvas = renderCanvas();

        mainFrame.setVisible(true); // display frame
    }

    /**
     * A method to render the tool bar at the top of the main frame, which contains buttons for all {@link Shape}'s
     * represented in the model. The user can select the specific shape they want to draw by clicking the respective
     * button.
     */
    private JToolBar renderButtonBar() {
        JToolBar buttonBar = new JToolBar();

        for(Shape shape : Shape.values()) {
            JButton button = new JButton(shape.name());
            button.addActionListener(e -> selectedShape = shape);
            buttonBar.add(button);
        }

        mainFrame.add(buttonBar, BorderLayout.NORTH);

        return buttonBar;
    }

    /**
     * A method to render the tool bar at the bottom of the main frame, which contains a button for selecting the colour
     * subsequent {@link Shape}s will be drawn in as well as buttons for undo and redo actions.
     * Note: Colour selection must be confirmed by clicking OK at the bottom of the dialogue box.
     */
    private JToolBar renderBottomBar() {
        JToolBar bottomBar = new JToolBar();

        JButton colorButton = new JButton("Choose colour");
        JColorChooser jColorChooser = new JColorChooser();
        colorButton.addActionListener(e -> {
            color = JColorChooser.showDialog(jColorChooser, "Choose colour", null);
        });
        bottomBar.add(colorButton);


        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> {
            drawerController.undo();
            canvas.repaint();
        });
        bottomBar.add(undoButton);

        JButton redoButton = new JButton("Redo");
        redoButton.addActionListener(e -> {
            drawerController.redo();
            canvas.repaint();
        });
        bottomBar.add(redoButton);

        mainFrame.add(bottomBar, BorderLayout.SOUTH);

        return bottomBar;
    }

    /**
     * A method to render the canvas, an instance of DrawerCanvas and the main frame's central JPanel.
     */
    private DrawerCanvas renderCanvas() {
        DrawerCanvas canvas = new DrawerCanvas(drawerController);

        // The use of the method reference operator below was suggested by IntelliJ.
        canvas.addDrawShapeListener(this::drawShape);

        mainFrame.add(canvas, BorderLayout.CENTER);

        return canvas;
    }

    /**
     * A method to draw shapes.
     * @param canvas An instance of DrawerCanvas, the main frame's central JPanel.
     */
    private void drawShape(DrawerCanvas canvas) {
        if(selectedShape == null) {
            return;
        }

        Point start = canvas.getDrawStartPosition();
        Point end = canvas.getDrawEndPosition();

        drawerController.createShape(selectedShape, start, end, color);
    }
}
