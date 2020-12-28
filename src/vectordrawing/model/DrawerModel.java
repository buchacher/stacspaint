package vectordrawing.model;

import vectordrawing.model.shapes.AbstractShapeModel;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

/**
 * The DrawerModel interface.
 */
public interface DrawerModel {

    AbstractShapeModel createShape(Shape shape, Point start, Point end, Color color);

    List<AbstractShapeModel> getShapes();

    void undo();

    void redo();

}
