package vectordrawing.model.shapes;

import java.awt.*;

/**
 * A class for a Star {@link Shape}
 */
public class Star extends AbstractShapeModel {

    /**
     * A constructor for the Star class.
     * @param start The start x,y-coordinate pair.
     * @param end The end x,y-coordinate pair.
     * @param color The colour the {@link vectordrawing.model.Shape} is to be drawn in.
     */
    public Star(Point start, Point end, Color color) {
        super(start, end, color);
    }

    /**
     * A method do draw a Star.
     * @param graphics Context utilised to draw onto components.
     */
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);

        int[] x = new int[] {
                upperLeft.x + 14*10,
                upperLeft.x + 18*10,
                upperLeft.x + 28*10,
                upperLeft.x + 21*10,
                upperLeft.x + 24*10,
                upperLeft.x + 14*10,
                upperLeft.x + 4*10,
                upperLeft.x + 7*10,
                upperLeft.x,
                upperLeft.x + 10*10,
        };

        int[] y = new int[] {
                upperLeft.y,
                upperLeft.y + 10*10,
                upperLeft.y + 11*10,
                upperLeft.y + 18*10,
                upperLeft.y + 28*10,
                upperLeft.y + 23*10,
                upperLeft.y + 28*10,
                upperLeft.y + 18*10,
                upperLeft.y + 11*10,
                upperLeft.y + 10*10,
        };

        graphics.drawPolygon(x, y, 10);
    }
}
