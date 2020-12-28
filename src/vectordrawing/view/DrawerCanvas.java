package vectordrawing.view;

import vectordrawing.controller.DrawerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * A class for the central JPanel, referred to as canvas.
 */
public class DrawerCanvas extends JPanel implements MouseListener {


    private final DrawerController controller;

    /** The start x,y-coordinate pair. */
    private Point drawStartPosition;
    /** The end x,y-coordinate pair. */
    private Point drawEndPosition;
    /** The DrawShapeListener interface. */
    private DrawShapeListener drawShapeListener;

    /**
     * A constructor for the DrawerCanvas class.
     * @param controller An instance of the controller component.
     */
    public DrawerCanvas(DrawerController controller) {
        this.controller = controller;
        this.addMouseListener(this);
    }

    /**
     * A standard getter for drawStartPosition.
     */
    public Point getDrawStartPosition() {
        return drawStartPosition;
    }

    /**
     * A standard getter for drawEndPosition.
     */
    public Point getDrawEndPosition() {
        return drawEndPosition;
    }

    /**
     * A method to add a drawShapeListener;
     */
    public void addDrawShapeListener(DrawShapeListener drawShapeListener) {
        this.drawShapeListener = drawShapeListener;
    }

    /**
     * A not implemented method inherited from the {@link MouseListener} class.
     * @param e The event to be listened for.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // Not implemented
    }

    /**
     * A method inherited from the {@link MouseListener} class.
     * Gets the x,y-coordinate pair where the mouse button is pressed.
     * @param e The event to be listened for.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        drawStartPosition = new Point(e.getX(), e.getY());
        drawEndPosition = null;
    }

    /**
     * A method inherited from the {@link MouseListener} class.
     * Gets the x,y-coordinate pair where the mouse button is released and draws the appropriate shape.
     * @param e The event to be listened for.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        drawEndPosition = new Point(e.getX(), e.getY());

        if(drawShapeListener != null) {
            drawShapeListener.drawShape(this);
        }

        this.repaint();
    }

    /**
     * A not implemented method inherited from the {@link MouseListener} class.
     * @param e The event to be listened for.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        // Not implemented
    }

    /**
     * A not implemented method inherited from the {@link MouseListener} class.
     * @param e The event to be listened for.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        // Not implemented
    }

    /**
     * A method to paint drawingOperations.
     * @param g Context utilised to draw onto components.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        controller.getShapes().forEach(shape -> shape.draw(g));
    }
}
