package vectordrawing;

import vectordrawing.controller.DrawerControllerImpl;
import vectordrawing.model.DrawerModelImpl;
import vectordrawing.view.DrawerView;

/**
 * A Main class in which the graphical user interface is created.
 */
public class VectorDrawingMain {

    /**
     * Main method.
     * @param args None.
     */
    public static void main(String[] args) {

        // Create View (GUI)
        var drawerModel = new DrawerModelImpl();
        new DrawerView(drawerModel, new DrawerControllerImpl(drawerModel));
    }
}
