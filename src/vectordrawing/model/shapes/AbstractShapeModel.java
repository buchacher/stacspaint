package vectordrawing.model.shapes;

import vectordrawing.model.Shape;
import vectordrawing.model.ShapeModel;

import java.awt.*;

/**
 * An abstract class implemented by {@link vectordrawing.model.Shape}'s in the model.
 */
public abstract class AbstractShapeModel implements ShapeModel {

    /** The start x,y-coordinate pair. */
    protected final Point start;
    /** The end x,y-coordinate pair. */
    protected final Point end;
    /** The magnitude of the user's mouse drag in the x direction. */
    protected final int width;
    /** The magnitude of the user's mouse drag in the y direction. */
    protected final int height;
    /** The upper left corner of a hypothetical rectangle Shape drawn by the user's mouse drag. */
    protected final Point upperLeft;
    /** The colour of the {@link Shape}. */
    protected final Color color;

    /**
     * A constructor for the AbstractShapeModel class.
     * @param start The start x,y-coordinate pair.
     * @param end The end x,y-coordinate pair.
     * @param color The colour the {@link Shape} is to be drawn in.
     */
    public AbstractShapeModel(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;

        width = Math.abs(start.x - end.x);
        height = Math.abs(start.y - end.y);

        Point left = start.x < end.x? start : end;
        Point right = left.equals(start)? end : start;

        upperLeft = left.y > right.y? new Point(left.x, left.y - height) : left;
    }

    /**
     * A method to draw a {@link Shape}.
     * @param graphics Context utilised to draw onto components.
     */
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
    }

    /**
     * A standard getter for start.
     */
    public Point getStart() {
        return start;
    }

    /**
     * A standard getter for end.
     */
    public Point getEnd() {
        return end;
    }

    /**
     * A standard getter for width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * A standard getter for height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * A standard getter for upperLeft.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }
}
