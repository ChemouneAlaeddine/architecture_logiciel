package controller;

import java.io.File;
import java.util.ArrayList;

import com.sun.javafx.scene.control.skin.LabeledText;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import model.shape.ConcreteShapeGroup;
import model.shape.MyPolygon;
import model.shape.MyRectangle;
import model.shape.MyShape;
import model.shape.ShapeFX;
import model.shape.ShapeFactory;
import view.GlobalView;

import static javafx.geometry.Pos.BOTTOM_RIGHT;

public class Controller {

	/**
	 * Single instance of the controller
	 */
	private static Controller instance = null;
	private GlobalView globalView = null;
	private static Stage stage;
	private static ContextMenu contextMenu;
    private static ArrayList<Node> selectionModel;
    private ShapeFactory factoryDragAndDrop;
    private static ConcreteShapeGroup rootGlobalShapeGroup;
    private static ConcreteShapeGroup rootToolbarShapeGroup;


	public static Controller getInstance() {
		if (instance == null)
			instance = new Controller();
		return instance;
	}

	private Controller(){
		globalView = GlobalView.getInstance();
		contextMenu = new ContextMenu();
        selectionModel = new ArrayList<Node>();
        factoryDragAndDrop = new ShapeFX();
        rootGlobalShapeGroup = new ConcreteShapeGroup();
    	rootToolbarShapeGroup = new ConcreteShapeGroup();
	}
	
	public ShapeFactory getFactoryDragAndDrop() {
		return factoryDragAndDrop;
	}
	
	public ConcreteShapeGroup getRootGlobalShapeGroup() {
		return rootGlobalShapeGroup;
	}

	public ConcreteShapeGroup getRootToolbarShapeGroup() {
		return rootToolbarShapeGroup;
	}
	
	public static EventHandler<ActionEvent> eventHandlerButtonSave = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			File file = new File("");
			GlobalView.getInstance().createSaveFileChooser(file, stage);
		}
	};

	public static EventHandler<ActionEvent> eventHandlerButtonOpen = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			File file = new File("");
			GlobalView.getInstance().createOpenFileChooser(file, stage);
		}
	};

	public static EventHandler<ActionEvent> eventHandlerButtonEdit = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			GridPane grid = new GridPane();

			Label width = new Label("Width: ");
			grid.add(width, 0, 1);
			TextField widthTextField = new TextField();
			grid.add(widthTextField, 1, 1);

			Label height = new Label("Height: ");
			grid.add(height, 0, 2);
			TextField heightTextField = new TextField();
			grid.add(heightTextField, 1, 2);

			Button btn = new Button("Apply");
			btn.setOnMousePressed(new EventHandler<MouseEvent>() {

				public void handle(MouseEvent event) {
					System.out.println(widthTextField.getText());
					System.out.println(heightTextField.getText());
				}
			});
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1, 4);

			Scene secondScene = new Scene(grid, 200, 100);
			Stage secondStage = new Stage();
			secondStage.setTitle("Edit");
			secondStage.setScene(secondScene);
			secondStage.show();
		}
	};


	public static EventHandler<MouseEvent> DragPressed = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event)
		{
		    if (event.getButton() == MouseButton.PRIMARY) {
                System.out.println("press");
                event.setDragDetect(true);
            }
            if (event.getButton() == MouseButton.SECONDARY){
                MenuItem item1 = new MenuItem("Menu Item 1");
                MenuItem item2 = new MenuItem("Menu Item 2");
                contextMenu.getItems().addAll(item1, item2);

            }
		}
	};

	public static EventHandler<MouseEvent> RectDragReleased = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
		    if (event.getButton() == MouseButton.PRIMARY) {
                /* Verification qu'on drop dans la zone de dessin et pas ailleurs */
                if (!(event.getPickResult().getIntersectedNode() instanceof HBox) &&
                		!(event.getPickResult().getIntersectedNode() instanceof VBox) &&
                		!(event.getPickResult().getIntersectedNode() instanceof Button) &&
                		!GlobalView.getInstance().getVbox().getChildren().contains(event.getPickResult().getIntersectedNode()) &&
                		!(event.getPickResult().getIntersectedNode() instanceof LabeledText)) {
                    System.out.println("release");
                    if (event.getSource() instanceof Shape) {
                        MyShape myShapeSource = rootToolbarShapeGroup.whoContains((Shape) event.getSource());
                        if (myShapeSource == null) {
                            System.err.println("error MyShape not found !");
                        } else {
                            MyRectangle myNewShape = (MyRectangle) myShapeSource.clone();
                            ((Rectangle) myNewShape.getShape()).setX(event.getSceneX());
                            ((Rectangle) myNewShape.getShape()).setY(event.getSceneY());
                            rootGlobalShapeGroup.add(myNewShape);
                            ((Node) myNewShape.getShape()).addEventFilter(MouseEvent.MOUSE_CLICKED, Controller.eventHandlerSelection);
							((Node) myNewShape.getShape()).addEventHandler(MouseEvent.MOUSE_PRESSED, Controller.DragPressed);
							((Node) myNewShape.getShape()).addEventHandler(MouseEvent.MOUSE_RELEASED, Controller.GlobalRectDragReleased);
                            myNewShape.draw(GlobalView.getInstance().getRoot());
                        }
                    }
                }
            }
		}
	};

	public static EventHandler<MouseEvent> GlobalRectDragReleased = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if (event.getButton() == MouseButton.PRIMARY) {
				/* On drop dans la toolbar */
				if(event.getPickResult().getIntersectedNode().equals(
						GlobalView.getInstance().getVbox())) {
					if (event.getSource() instanceof Shape) {
                        MyShape myShapeSource = rootGlobalShapeGroup.whoContains((Shape) event.getSource());
                        if (myShapeSource == null) {
                            System.err.println("error MyShape not found !");
                        } else {
                            MyRectangle myNewShape = (MyRectangle) myShapeSource.clone();
                            ((Rectangle) myNewShape.getShape()).setX(event.getSceneX());
                            ((Rectangle) myNewShape.getShape()).setY(event.getSceneY());
                            rootToolbarShapeGroup.add(myNewShape);
							((Node) myNewShape.getShape()).addEventHandler(MouseEvent.MOUSE_PRESSED, Controller.DragPressed);
							((Node) myNewShape.getShape()).addEventHandler(MouseEvent.MOUSE_RELEASED, Controller.RectDragReleased);
                            GlobalView.getInstance().getVbox().getChildren().add((Rectangle) myNewShape.getShape());
                        }
                    }
				}
				/* On drop dans la zone de dessin */
				else if (!(event.getPickResult().getIntersectedNode() instanceof HBox) &&
                		!(event.getPickResult().getIntersectedNode() instanceof VBox) &&
                		!(event.getPickResult().getIntersectedNode() instanceof Button) &&
                		!GlobalView.getInstance().getVbox().getChildren().contains(event.getPickResult().getIntersectedNode()) &&
                		!(event.getPickResult().getIntersectedNode() instanceof LabeledText)) {
					System.out.println("release");
					if (event.getSource() instanceof Shape) {
						MyShape myShapeSource = rootGlobalShapeGroup.whoContains((Shape) event.getSource());
						if (myShapeSource == null) {
							System.err.println("error MyShape not found !");
						} else {
							((Rectangle) ((MyRectangle) myShapeSource).getShape()).setX(event.getSceneX());
							((Rectangle) ((MyRectangle) myShapeSource).getShape()).setY(event.getSceneY());
						}
					}
				}
			}
		}
	};

	public static EventHandler<MouseEvent> GlobalPolyDragReleased = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
		    if (event.getButton() == MouseButton.PRIMARY) {
                /* On drop dans la toolbar */
		    	if(event.getPickResult().getIntersectedNode().equals(
						GlobalView.getInstance().getVbox())) {
		    		if (event.getSource() instanceof Shape) {
						MyShape myShapeSource = rootGlobalShapeGroup.whoContains((Shape) event.getSource());
						if (myShapeSource == null) {
							System.err.println("error MyShape not found !");
						} else {
							MyPolygon myNewShape = (MyPolygon) myShapeSource.clone();
							double space = myNewShape.get_space();
							double newX = event.getSceneX();
							double newY = event.getSceneY();
							((Polygon) myNewShape.getShape()).getPoints().clear();
							((Polygon) myNewShape.getShape()).getPoints().addAll(
									new Double[]{
											newX, newY, newX + space, newY - space,
											newX + space * 2, newY, newX + (3 * space / 2), newY + space,
											newX + (space / 2), newY + space
									});
							rootToolbarShapeGroup.add(myNewShape);
							((Node) myNewShape.getShape()).addEventHandler(MouseEvent.MOUSE_PRESSED, Controller.DragPressed);
							((Node) myNewShape.getShape()).addEventHandler(MouseEvent.MOUSE_RELEASED, Controller.PolyDragReleased);
							GlobalView.getInstance().getVbox().getChildren().add((Polygon) myNewShape.getShape());
						}
					}
				}
		    	/* On drop dans la zone de dessin */
                if (!(event.getPickResult().getIntersectedNode() instanceof HBox) &&
                		!(event.getPickResult().getIntersectedNode() instanceof VBox) &&
                		!(event.getPickResult().getIntersectedNode() instanceof Button) &&
                		!GlobalView.getInstance().getVbox().getChildren().contains(event.getPickResult().getIntersectedNode()) &&
                		!(event.getPickResult().getIntersectedNode() instanceof LabeledText)) {
                    System.out.println("release");
                    if (event.getSource() instanceof Shape) {
                        MyShape myShapeSource = rootGlobalShapeGroup.whoContains((Shape) event.getSource());
                        if (myShapeSource == null) {
                            System.err.println("error MyShape not found !");
                        } else {
                            double space = ((MyPolygon) myShapeSource).get_space();
                            double newX = event.getSceneX();
                            double newY = event.getSceneY();
                            ((Polygon) ((MyPolygon) myShapeSource).getShape()).getPoints().clear();
                            ((Polygon) ((MyPolygon) myShapeSource).getShape()).getPoints().addAll(
                                    new Double[]{
                                            newX, newY, newX + space, newY - space,
                                            newX + space * 2, newY, newX + (3 * space / 2), newY + space,
                                            newX + (space / 2), newY + space
                                    });	
                        }
                    }
                }
            }
		}
	};

	public static EventHandler<MouseEvent> PolyDragReleased = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if (event.getButton() == MouseButton.PRIMARY) {
				/* Verification qu'on drop dans la zone de dessin et pas ailleurs */
				if (!(event.getPickResult().getIntersectedNode() instanceof HBox) &&
                		!(event.getPickResult().getIntersectedNode() instanceof VBox) &&
                		!(event.getPickResult().getIntersectedNode() instanceof Button) &&
                		!GlobalView.getInstance().getVbox().getChildren().contains(event.getPickResult().getIntersectedNode()) &&
                		!(event.getPickResult().getIntersectedNode() instanceof LabeledText)) {
					System.out.println("release");
					if (event.getSource() instanceof Shape) {
						MyShape myShapeSource = rootToolbarShapeGroup.whoContains((Shape) event.getSource());
						if (myShapeSource == null) {
							System.err.println("error MyShape not found !");
						} else {
							MyPolygon myNewShape = (MyPolygon) myShapeSource.clone();
							double space = myNewShape.get_space();
							double newX = event.getSceneX();
							double newY = event.getSceneY();
							((Polygon) myNewShape.getShape()).getPoints().clear();
							((Polygon) myNewShape.getShape()).getPoints().addAll(
									new Double[]{
											newX, newY, newX + space, newY - space,
											newX + space * 2, newY, newX + (3 * space / 2), newY + space,
											newX + (space / 2), newY + space
									});
							rootGlobalShapeGroup.add(myNewShape);
							((Node) myNewShape.getShape()).addEventFilter(MouseEvent.MOUSE_CLICKED, Controller.eventHandlerSelection);
							((Node) myNewShape.getShape()).addEventHandler(MouseEvent.MOUSE_PRESSED, Controller.DragPressed);
							((Node) myNewShape.getShape()).addEventHandler(MouseEvent.MOUSE_RELEASED, Controller.GlobalPolyDragReleased);
							myNewShape.draw(GlobalView.getInstance().getRoot());
						}
					}
				}
			}
		}
	};

	public static EventHandler<MouseEvent> eventHandlerSelection = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if( event.isControlDown()) {
				if(!selectionModel.contains((Node) event.getSource()))
					selectionModel.add( (Node) event.getSource());

				// logging
				System.out.println("Items in model:");
				selectionModel.forEach(n -> System.out.println(n));
			}
			else {
				selectionModel.clear();
				selectionModel.add( (Node) event.getSource());
				
				// logging
				System.out.println("Items in model:");
				selectionModel.forEach(n -> System.out.println(n));
			}
		}
	};
	
	public static EventHandler<MouseEvent> eventHandlerClearSelection = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if( !event.isControlDown()) {
				if(event.getPickResult().getIntersectedNode() instanceof Shape) {
					if(GlobalView.getInstance().getVbox().getChildren().contains(event.getPickResult().getIntersectedNode())) {
						selectionModel.clear();
					}
				}
				else {
					selectionModel.clear();
				}

				// logging
				System.out.println("Items in model:");
				selectionModel.forEach(n -> System.out.println(n));
			}
		}
	};

	public void start(Stage primaryStage) throws Exception {
		Controller.stage = primaryStage;
		globalView.createGlobalView(stage);

	}
}
