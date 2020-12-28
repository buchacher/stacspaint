package vectordrawing.model.shapes;

import java.awt.*;

/**
 * A class for a Line {@link Shape}
 */
public class Line extends AbstractShapeModel {

    /**
     * A constructor for the Line class.
     * @param start The start x,y-coordinate pair.
     * @param end The end x,y-coordinate pair.
     * @param color The colour the {@link vectordrawing.model.Shape} is to be drawn in.
     */
    public Line(Point start, Point end, Color color) {
        super(start, end, color);
    }

    /**
     * A method do draw a Line.
     * @param graphics Context utilised to draw onto components.
     */
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.drawLine(start.x, start.y, end.x, end.y);
    }
}
