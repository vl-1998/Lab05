package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

	private Model model;

    @FXML
    void doCalcola(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	
    	String parola = txtParola.getText();
    	
    	if (parola.isEmpty()) {
    		txtCorretti.appendText("Inserire parola!");
    		return;
    	}
    	    
    	List <String> corrette= new ArrayList <> ();
    	List <String> errate= new ArrayList <> ();
    	try {
    		corrette= this.model.risultatoCorrette(this.model.anagrammi(parola));
        	errate= this.model.risultatoErrate(this.model.anagrammi(parola));
    	} catch (IllegalStateException se) {
    		txtCorretti.appendText(se.getMessage());
    	}
    	
    	
    	for (String s :corrette) {
    		txtCorretti.appendText(s+"\n");
    	}
    	for (String s :errate) {
    		txtErrati.appendText(s+"\n");
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
	}
}
