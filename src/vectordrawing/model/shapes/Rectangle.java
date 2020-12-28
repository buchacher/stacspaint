package vectordrawing.model.shapes;

import java.awt.*;

/**
 * A class for a Rectangle {@link Shape}
 */
public class Rectangle extends AbstractShapeModel{

    /**
     * A constructor for the Rectangle class.
     * @param start The start x,y-coordinate pair.
     * @param end The end x,y-coordinate pair.
     * @param color The colour the {@link vectordrawing.model.Shape} is to be drawn in.
     */
    public Rectangle(Point start, Point end, Color color) {
        super(start, end, color);
    }

    /**
     * A method do draw a Rectangle.
     * @param graphics Context utilised to draw onto components.
     */
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.drawRect(upperLeft.x, upperLeft.y, width, height);
    }
}
