package vectordrawing.model.shapes;

import java.awt.*;

/**
 * A class for an Ellipse {@link Shape}
 */
public class Ellipse extends AbstractShapeModel{

    /**
     * A constructor for the Ellipse class.
     * @param start The start x,y-coordinate pair.
     * @param end The end x,y-coordinate pair.
     * @param color The colour the {@link vectordrawing.model.Shape} is to be drawn in.
     */
    public Ellipse(Point start, Point end, Color color) {
        super(start, end, color);
    }

    /**
     * A method do draw an Ellipse.
     * @param graphics Context utilised to draw onto components.
     */
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.drawOval(upperLeft.x, upperLeft.y, width, height);
    }

}
