package vectordrawing.model.shapes;

import java.awt.*;

/**
 * A class for a Circle {@link Shape}
 */
public class Circle extends AbstractShapeModel {

    /**
     * A constructor for the Circle class.
     * @param start The start x,y-coordinate pair.
     * @param end The end x,y-coordinate pair.
     * @param color The colour the {@link vectordrawing.model.Shape} is to be drawn in.
     */
    public Circle(Point start, Point end, Color color) {
        super(start, end, color);
    }

    /**
     * A method do draw a Circle.
     * @param graphics Context utilised to draw onto components.
     */
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.drawOval(upperLeft.x, upperLeft.y, Math.max(width, height), Math.max(width, height));
    }
}
