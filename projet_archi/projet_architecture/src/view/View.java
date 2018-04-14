package view;

import model.*;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import images.*;

public class View {
	HBox hbox1;
	BorderPane root;
	Scene scene;
	Label labelNom;
	Button save;
	Button load;
	Button undo;
	Button redo;
	Button delete;
	VBox vbox1;
	ListView<IShape> listView1;
	
	public View() {}
	
	public void init(Stage primaryStage) {
		primaryStage.setTitle("fenetre");
		root = new BorderPane();
		scene = new Scene(root,800,600);
		primaryStage.setScene(scene);
		
		hbox1 = new HBox();
		hbox1.setPadding(new Insets(10));
		hbox1.setSpacing(10);
		labelNom = new Label("Fruits: ");
		
		
		ImageView imgSave = new ImageView("images/save.png");
		imgSave.setFitHeight(20);
		imgSave.setFitWidth(20);
		save = new Button();
		save.setGraphic(imgSave);
		save.setMaxSize(20, 20);
		
		ImageView imgLoad = new ImageView("images/computer-from-floppy-load-512.png");
		imgLoad.setFitHeight(20);
		imgLoad.setFitWidth(20);
		load = new Button();
		load.setGraphic(imgLoad);
		load.setMaxSize(20, 20);
		
		ImageView imgUndo = new ImageView("images/undo.png");
		imgUndo.setFitHeight(20);
		imgUndo.setFitWidth(20);
		undo = new Button();
		undo.setGraphic(imgUndo);
		undo.setMaxSize(20, 20);
		
		ImageView imgRedo = new ImageView("images/redo.png");
		imgRedo.setFitHeight(20);
		imgRedo.setFitWidth(20);
		redo = new Button();
		redo.setGraphic(imgRedo);
		redo.setMaxSize(20, 20);
		
		ImageView imgDelete = new ImageView("images/trash.png");
		imgDelete.setFitHeight(20);
		imgDelete.setFitWidth(20);
		delete = new Button();
		delete.setGraphic(imgDelete);
		delete.setMaxSize(20, 20);
		
		hbox1.getChildren().addAll(save,load,undo,redo);
		
		vbox1 = new VBox();
		vbox1.setPadding(new Insets(10));
		vbox1.setSpacing(10);
		
		
		
		Polygon pA = new Polygon();
		
		
		pA.getPoints().addAll(new Double[] { 90.0, 90.0,
		100.0, 100.0,
		80.0, 100.0});
		//pA.setStroke(Color.DARKRED);
		//pA.setStrokeWidth(3);
		//pA.setFill(Color.LIGHTYELLOW);
		
		
		
		listView1 = new ListView<IShape>();
		listView1.setMaxHeight(500);
		listView1.setMaxWidth(80);
		//listView1.getItems().add(pA);
		
		
		vbox1.getChildren().addAll(listView1,delete);
		
		root.setLeft(listView1);
		root.setTop(hbox1);
		root.setBottom(delete);
		primaryStage.show();
	}
	

	public Button getSave() {
		return save;
	}

	public Button getLoad() {
		return load;
	}

	public Button getUndo() {
		return undo;
	}

	public Button getRedo() {
		return redo;
	}

	public Button getDelete() {
		return delete;
	}
}
