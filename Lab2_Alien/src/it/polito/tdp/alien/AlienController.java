package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
    
    private AlienDictionaryDUE dizionario;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	dizionario = new AlienDictionaryDUE();
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String array[] = txtWord.getText().split(" ");
    	
    	Pattern p = Pattern.compile("[a-zA-Z?]");
    	boolean hasSpecialChar = p.matcher(array[0]).find();
    	if(hasSpecialChar==false)
    		txtResult.appendText( "\n" + array[0]+ "Errore inserimento dati!");
    	// oppure fai stringa.matches("[a-zA-Z]*")==false
    	else{
    		if(array[0].indexOf("?")==-1){
		    	if(array.length==1){
		    		if(dizionario.contieneGia(array[0])==false){
		    			txtResult.appendText("\nLa parola "+array[0]+" non è presente nel dizionario!");
		    		}
		    		else
		    			txtResult.appendText("\nLa traduzione/i è/sono: "+dizionario.traslateWord(array[0]));
		    	}
		    	/*if(array.length==2){
		    		dizionario.addWord(array[0], array[1]);
		    		txtResult.appendText("\nParola aggiunta con traduzione: "+array[1]);
		    	}*/
		    	if(array.length>1){
		    		boolean agg = dizionario.contieneGia(array[0]);
		    		int i;
		    		StringBuilder parole = new StringBuilder();
		    		for(i = 1 ; i<array.length ; i++){
		    			dizionario.addWord(array[0], array[i]);
		    			//parole += array[i]+" ";
		    			parole.append(array[i]+" ");
		    		}
		    		if(agg == false)
		    			txtResult.appendText("\nParola aggiunta con traduzione/i: " + parole);
		    		else
		    			txtResult.appendText("\nParola ha avuto una/delle nuova/e traduzione/i: "+parole);
		    	}
		    	txtWord.clear();
    		}
    		else{
		    	if(dizionario.contieneGiaWild(array[0])==false){
		    		txtResult.appendText("\nLa parola "+array[0]+" non è presente nel dizionario!");
		    	}
		    	else
		    		txtResult.appendText("\nLa traduzione/i è/sono: "+dizionario.traslateWild(array[0]));
    		    }
    			txtWord.clear();
    		}
    	    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	dizionario.pulisci();
    	txtResult.setText("");
    }
    
}
