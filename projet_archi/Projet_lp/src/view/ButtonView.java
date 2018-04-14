package view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


import controller.Controller;

public class ButtonView {

    private static ButtonView buttonView;

    public static ButtonView getInstance() {
        if (buttonView == null)
            buttonView = new ButtonView();
        return buttonView;
    }

    public void drawButtonView(HBox hbox, Stage primaryStage){
        Button buttonSave = new Button("Save");
        
        Button buttonOpen = new Button("Open");
        Button buttonEdit = new Button("Edit");
        Button buttonSplit = new Button("Split");
        Button buttonUndo = new Button("Undo");
        Button buttonRedo = new Button("Redo");
        Controller.getInstance();
		buttonSave.setOnAction(Controller.eventHandlerButtonSave);
        buttonOpen.setOnAction(Controller.eventHandlerButtonOpen);
        buttonEdit.setOnAction(Controller.eventHandlerButtonEdit);


        hbox.setSpacing(10);
        hbox.getChildren().addAll(buttonSave, buttonOpen, buttonEdit, buttonSplit, buttonUndo, buttonRedo);
    }
}