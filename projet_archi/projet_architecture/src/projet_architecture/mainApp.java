package projet_architecture;

import view.View;
import model.*;
import controller.Controller;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class mainApp extends Application {

	View view;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		view = new View();
		//Model m = new Model();
		//Controller c = new Controller(m);
		view.init(primaryStage);
	}

}
