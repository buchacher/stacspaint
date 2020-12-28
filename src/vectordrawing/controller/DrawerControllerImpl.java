package vectordrawing.controller;

import vectordrawing.model.DrawerModel;
import vectordrawing.model.Shape;
import vectordrawing.model.ShapeModel;
import vectordrawing.model.shapes.AbstractShapeModel;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

/**
 * An implementation of the {@link DrawerController} interface.
 */
public class DrawerControllerImpl implements DrawerController {

    private final DrawerModel drawerModel;

    public DrawerControllerImpl(DrawerModel drawerModel) {
        this.drawerModel = drawerModel;
    }

    /**
     * A method to create a {@link Shape}
     * @param shape The type of {@link Shape} to be created.
     * @param start The start x,y-coordinate pair.
     * @param end The end x,y-coordinate pair.
     * @return The shape to be created.
     */
    @Override
    public ShapeModel createShape(Shape shape, Point start, Point end, Color color) {
        return drawerModel.createShape(shape, start, end, color);
    }

    @Override
    public List<AbstractShapeModel> getShapes() {
        return drawerModel.getShapes();
    }

    @Override
    public void undo() {
        drawerModel.undo();
    }

    @Override
    public void redo() {
        drawerModel.redo();
    }

}
