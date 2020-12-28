package vectordrawing.model;

import vectordrawing.model.shapes.*;
import vectordrawing.model.shapes.Rectangle;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The implementation of the {@link DrawerModel} interface.
 */
public class DrawerModelImpl implements DrawerModel {

    /** A list of {@link Shape}'s within runtime. */
    private final List<AbstractShapeModel> shapes = new ArrayList<>();
    /** A Stack for undo and redo actions. */
    private final Stack<AbstractShapeModel> undoneLog = new Stack<>();

    /**
     * Calls createNewShape to create the specified {@link Shape}. Called in the implementation of the controller
     * component, {@link vectordrawing.controller.DrawerControllerImpl}.
     * @return The {@link Shape}.
     */
    @Override
    public AbstractShapeModel createShape(Shape shape, Point start, Point end, Color color) {
        AbstractShapeModel newShape = createNewShape(shape, start, end, color);
        if(newShape != null) {
            shapes.add(newShape);
        }
        return newShape;
    }

    /**
     * A method to create a new specified {@link Shape}.
     * @param shape The type of {@link Shape} to be created.
     * @param start The start x,y-coordinate pair.
     * @param end The end x,y-coordinate pair.
     * @param color The colour the {@link Shape} is to be drawn in.
     * @return The {@link Shape}.
     */
    private AbstractShapeModel createNewShape(Shape shape, Point start, Point end, Color color) {
        switch (shape) {
            case Line:
                return new Line(start, end, color);
            case Rectangle:
                return new Rectangle(start, end, color);
            case Square:
                return new Square(start, end, color);
            case Ellipse:
                return new Ellipse(start, end, color);
            case Circle:
                return new Circle(start, end, color);
            case Star:
                return new Star(start, end, color);
        }
        return null;
    }

    /**
     * A standard getter for shapes.
     */
    @Override
    public List<AbstractShapeModel> getShapes() {
        return shapes;
    }

    /**
     * A method to undo actions.
     */
    @Override
    public void undo() {
        if(!shapes.isEmpty()) {
            AbstractShapeModel lastShape = shapes.get(shapes.size() - 1);
            shapes.remove(shapes.size() - 1);
            undoneLog.push(lastShape);
        }
    }

    /**
     * A method to redo actions.
     */
    @Override
    public void redo() {
        if(!undoneLog.empty()) {
            shapes.add(undoneLog.pop());
        }
    }
}
