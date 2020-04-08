package it.polito.tdp.anagrammi;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.anagrammi.FXMLController;
import it.polito.tdp.anagrammi.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Model model = new Model();
	    
		FXMLController controller;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
	    Parent root = loader.load();
	    Scene scene = new Scene(root);

	    controller = loader.getController();
		
	    controller.setModel(model);
	    
	    
	    stage.setTitle("JavaFX and Maven");
	    stage.setScene(scene);
	    stage.show();
	}

	public static void main(String[] args) {
	    launch(args);
	}
  
}



