/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.DeSeriisRoberta;



import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import it.polito.tdp.DeSeriisRoberta.model.Model;
import it.polito.tdp.DeSeriisRoberta.model.RendimentoRegione;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController {
	private Model model; 

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxParamRicorsione"
    private ChoiceBox<String> boxParamRicorsione; // Value injected by FXMLLoader

    @FXML // fx:id="btnAvvia"
    private Button btnAvvia; // Value injected by FXMLLoader

    @FXML // fx:id="btnRendimentoEolico"
    private Button btnRendimentoEolico; // Value injected by FXMLLoader

    @FXML // fx:id="btnRendimentoFotovoltico"
    private Button btnRendimentoFotovoltico; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnRendimentoTot"
    private Button btnRendimentoTot; // Value injected by FXMLLoader


    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="cmbAreaDiRiferimento"
    private ChoiceBox<String> cmbAreaDiRiferimento; // Value injected by FXMLLoader

    @FXML // fx:id="txtBudget"
    private TextField txtBudget; // Value injected by FXMLLoader

    @FXML // fx:id="clRegione"
    private TableColumn<RendimentoRegione, String> clRegione; // Value injected by FXMLLoader


    @FXML // fx:id="clRendimentoEolico"
    private TableColumn<RendimentoRegione, Double> clRendimentoEolico; // Value injected by FXMLLoader


    @FXML // fx:id="clRendimentoSolareFotovoltaico"
    private TableColumn<RendimentoRegione, Double> clRendimentoSolareFotovoltaico; // Value injected by FXMLLoader
    
    @FXML // fx:id="tblOutput"
    private TableView<RendimentoRegione> tblOutput; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
  
    
    @FXML
    void doRendimentoEolico(ActionEvent event) {
    	//sistemare formula rendimento
    	txtResult.clear();

    	String areaScelta = this.cmbAreaDiRiferimento.getValue();
    	
    	if(areaScelta==null) {
    		txtResult.appendText("Seleziona un area di riferimento");
    		return;
    	}
    	
    	if(areaScelta.compareTo("Italia")==0) {
    		List<RendimentoRegione> rendimento = model.getRegioni();
    		model.calcolaRendimentoEolico(rendimento);
    		tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    	
    	if(areaScelta.compareTo("Italia: PS")==0) {
    		List<RendimentoRegione> rendimento = model.statoRegioni("PS");
    			tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    	if(areaScelta.compareTo("Italia: MS")==0) {
    		List<RendimentoRegione> rendimento = model.statoRegioni("MS");
    			tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    	if(areaScelta.compareTo("Italia: IT")==0) {
    		List<RendimentoRegione> rendimento = model.statoRegioni("IT");
    			tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    }

    @FXML
    void doRendimentoFotovoltaico(ActionEvent event) {
    	 txtResult.clear();
    	 
    	 String areaScelta = this.cmbAreaDiRiferimento.getValue();
     	
     	if(areaScelta==null) {
     		txtResult.appendText("Seleziona un area di riferimento");
     		return;
     	}
     	
    	if(areaScelta.compareTo("Italia")==0) {
    		List<RendimentoRegione> rendimento = model.calcolaRendimentoSolare(model.getRegioni());
    		tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    	
    	if(areaScelta.compareTo("Italia: PS")==0) {
    		List<RendimentoRegione> rendimento = model.statoRegioni("PS");
    			tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    	
    	if(areaScelta.compareTo("Italia: MS")==0) {
    		List<RendimentoRegione> rendimento = model.statoRegioni("MS");
    			tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    	
    	if(areaScelta.compareTo("Italia: IT")==0) {
    		List<RendimentoRegione> rendimento = model.statoRegioni("IT");
    			tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    }
    
    @FXML
    void doRendimentotot(ActionEvent event) {
    	txtResult.clear();

    	String areaScelta = this.cmbAreaDiRiferimento.getValue();
    	
    	if(areaScelta==null) {
    		txtResult.appendText("Seleziona un area di riferimento");
    		return;
    	}
    	
    	if(areaScelta.compareTo("Italia")==0) {
    		List<RendimentoRegione> rendimento = model.getRegioni();
    		model.calcolaRendimentoEolico(rendimento);
    		model.calcolaRendimentoSolare(rendimento);
    		tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    	
    	if(areaScelta.compareTo("Italia: PS")==0) {
    		List<RendimentoRegione> rendimento = model.statoRegioni("PS");
    			tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    	if(areaScelta.compareTo("Italia: MS")==0) {
    		List<RendimentoRegione> rendimento = model.statoRegioni("MS");
    			tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}
    	if(areaScelta.compareTo("Italia: IT")==0) {
    		List<RendimentoRegione> rendimento = model.statoRegioni("IT");
    			tblOutput.setItems(FXCollections.observableArrayList(rendimento));
    	}

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doRicorsione(ActionEvent event) {
    	
    	this.txtResult.setText(model.calcolaBudget(200000000).toString());

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxParamRicorsione != null : "fx:id=\"boxParamRicorsione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAvvia != null : "fx:id=\"btnAvvia\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRendimentoEolico != null : "fx:id=\"btnRendimentoEolico\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRendimentoFotovoltico != null : "fx:id=\"btnRendimentoFotovoltico\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRendimentoTot != null : "fx:id=\"btnRendimentoTot\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clRegione != null : "fx:id=\"clRegione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clRendimentoEolico != null : "fx:id=\"clRendimentoEolico\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clRendimentoSolareFotovoltaico != null : "fx:id=\"clRendimentoSolareFotovoltaico\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbAreaDiRiferimento != null : "fx:id=\"cmbAreaDiRiferimento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tblOutput != null : "fx:id=\"tblOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtBudget != null : "fx:id=\"txtBudget\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    
        clRegione.setCellValueFactory(new PropertyValueFactory<RendimentoRegione, String>("regione")); //NON FUNZIONA QUESTA RIGA
       
		clRendimentoEolico.setCellValueFactory(new PropertyValueFactory<RendimentoRegione, Double>("rendimentoEol"));
		
		clRendimentoSolareFotovoltaico.setCellValueFactory(new PropertyValueFactory<RendimentoRegione, Double>("rendimentoSol"));
        
    }
    
    public void setModel(Model model) {
    	this.model = model;
    	this.cmbAreaDiRiferimento.getItems().add("Italia");
    	this.cmbAreaDiRiferimento.getItems().add("Italia: PS");
    	this.cmbAreaDiRiferimento.getItems().add("Italia: MS");
    	this.cmbAreaDiRiferimento.getItems().add("Italia: IT");
    	
    	this.boxParamRicorsione.getItems().add("Eolico");
    	this.boxParamRicorsione.getItems().add("Solare Fotovoltaico");
    	this.boxParamRicorsione.getItems().add("Eolico e Solare Fotovoltaico");
    }
}

   



