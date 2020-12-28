package vectordrawing.model;

import java.awt.Graphics;

/**
 * The ShapeModel interface, implemented by {@link Shape}'s represented in the model.
 */
public interface ShapeModel {

    /**
     * A method to draw a {@link Shape}.
     * @param graphics Context utilised to draw onto components.
     */
    void draw(Graphics graphics);

}
