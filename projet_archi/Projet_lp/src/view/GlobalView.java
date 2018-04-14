package view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import controller.Controller;

public class GlobalView {

    private static GlobalView globalView;
    private ButtonView buttonView;
    private ToolbarView toolbarView;
    private Group root;
    private HBox hbox;
    private VBox vbox;

    public HBox getHbox() {
		return hbox;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void createSaveFileChooser(File file, Stage stage) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        file = fileChooser.showSaveDialog(stage);

        if (file != null) {
        }
    }

    public void createOpenFileChooser(File file, Stage stage) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        file = fileChooser.showOpenDialog(stage);

        if(file != null){

        }
    }


	public static GlobalView getInstance() {
        if (globalView == null)
            globalView = new GlobalView();
        return globalView;
    }

    public Group getRoot() {
		return root;
	}

	private GlobalView() {
        toolbarView = ToolbarView.getInstance();
        buttonView = ButtonView.getInstance();
    }

    public void createGlobalView(Stage primaryStage){
        BorderPane border = new BorderPane();
        border.addEventHandler(MouseEvent.MOUSE_PRESSED, Controller.eventHandlerClearSelection);
        root = new Group();
        root.setManaged(false);

        Scene scene = new Scene(border, 1300, 700);
        primaryStage.setTitle("Projet");
        primaryStage.setScene(scene);
        primaryStage.show();
        hbox = new HBox(8);
        hbox.setStyle("-fx-border-color: black;");
        hbox.setPickOnBounds(true);
        
        vbox = new VBox(8);
        vbox.setStyle("-fx-border-color: black;");
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPickOnBounds(true);
        
        border.setTop(hbox);
        border.setLeft(vbox);
        border.setCenter(root);
        buttonView.drawButtonView(hbox, primaryStage);
       // toolbarView.createContextMenu();
        toolbarView.drawToolbarView(vbox, primaryStage);





        //root.getChildren().addAll(hbox, vbox);

    }
}