package vectordrawing.controller;

import vectordrawing.model.Shape;
import vectordrawing.model.ShapeModel;
import vectordrawing.model.shapes.AbstractShapeModel;

import java.awt.*;
import java.util.List;

/**
 * The DrawerController interface.
 */
public interface DrawerController {

    ShapeModel createShape(Shape shape, Point start, Point end, Color color);

    List<AbstractShapeModel> getShapes();

    void undo();

    void redo();

}
