package vectordrawing.model.shapes;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * A Test class for the model component and associated classes and interfaces.
 *
 */
public class ShapeTest {

    /**
     * Asserts that, when creating a {@link Rectangle} object by drawing in the negative x-direction, the start and end
     * x,y-coordinate pairs given by a user's mouse drag start and end position translate to a rectangle of width and
     * height corresponding to magnitudes of distance travelled in the x and y direction respectively.
     */
    @Test
    public void testDrawRectangleFromRightToLeft() {
        Point start = new Point(30, 10);
        Point end = new Point(10, 20);

        Rectangle rectangle = new Rectangle(start, end, Color.BLACK);

        Assert.assertEquals(rectangle.getUpperLeft(), new Point(10, 10));
        Assert.assertEquals(rectangle.getWidth(), 20);
        Assert.assertEquals(rectangle.getHeight(), 10);
    }

    /**
     * Asserts that, when creating a {@link Square} object, the start and end x,y-coordinate pairs given by a user's
     * mouse drag start and end position, though not of equal distance travelled in the x and y direction, translate to
     * a rectangle with all four sides equal. The length of the sides being the larger of the magnitudes of distance
     * travelled in the x and y direction respectively.
     */
    @Test
    public void testDrawSquareWithSameLengthSizes() {
        Point start = new Point(30, 10);
        Point end = new Point(10, 20);

        Square square = new Square(start, end, Color.BLACK);

        Assert.assertEquals(Math.max(Math.abs(end.x - start.x), Math.abs(end.y - start.y)), Math.max(square.getWidth(), square.getHeight()));
    }
}
