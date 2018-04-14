package view;

import controller.Controller;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.shape.MyPolygon;
import model.shape.MyRectangle;
import model.shape.PolyFX;
import model.shape.RectFX;


public class ToolbarView {

    private static ToolbarView toolbarView;
    private static ContextMenu contextMenu;

	private ToolbarView() {
    	contextMenu = new ContextMenu();
    }
    
    public static ToolbarView getInstance() {
        if (toolbarView == null)
            toolbarView = new ToolbarView();
        return toolbarView;
    }

    private void initContextMenu() { ;
        final MenuItem item1 = new MenuItem("edit");
        final MenuItem item2 = new MenuItem("split");
        contextMenu.getItems().addAll(item1, item2);
    }
    

    public void drawToolbarView(VBox vBox, Stage primaryStage){
        initContextMenu();
        MyRectangle rect = new RectFX((Rectangle) Controller.getInstance().getFactoryDragAndDrop().createRect(0, 200, 30, 20));
        MyPolygon poly = new PolyFX((Polygon) Controller.getInstance().getFactoryDragAndDrop().createPoly(0, 100, 20));
        poly.clone();
        Controller.getInstance().getRootToolbarShapeGroup().add(rect);
        Controller.getInstance().getRootToolbarShapeGroup().add(poly);
        ((Node) rect.getShape()).addEventHandler(MouseEvent.MOUSE_PRESSED, Controller.DragPressed);
        ((Node) poly.getShape()).addEventHandler(MouseEvent.MOUSE_PRESSED, Controller.DragPressed);
        ((Node) rect.getShape()).addEventHandler(MouseEvent.MOUSE_RELEASED, Controller.RectDragReleased);
        ((Node) poly.getShape()).addEventHandler(MouseEvent.MOUSE_RELEASED, Controller.PolyDragReleased);
        ((Node) rect.getShape()).setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {

                contextMenu.show((Node) rect.getShape(), event.getScreenX(), event.getScreenY());
            }
        });

        vBox.getChildren().add((Rectangle) rect.getShape());
        vBox.getChildren().add((Polygon) poly.getShape());
        





    }
}