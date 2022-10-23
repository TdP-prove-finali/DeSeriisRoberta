/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.DeSeriisRoberta;



import java.net.URL;
import java.util.List;
import java.util.Map;
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
import it.polito.tdp.DeSeriisRoberta.model.Regione;
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

    @FXML // fx:id="btnProduzioneTot"
    private Button btnProduzioneTot; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="clProdEolico"
    private TableColumn<Regione, Double> clProdEolico; // Value injected by FXMLLoader

    @FXML // fx:id="clProdSolareFotovoltaico"
    private TableColumn<Regione, Double> clProdSolareFotovoltaico; // Value injected by FXMLLoader

    @FXML // fx:id="clRegione"
    private TableColumn<Regione, String> clRegione; // Value injected by FXMLLoader

    @FXML // fx:id="cmbAreaDiRiferimento"
    private ChoiceBox<String> cmbAreaDiRiferimento; // Value injected by FXMLLoader

    @FXML // fx:id="tblOutput"
    private TableView<Regione> tblOutput; // Value injected by FXMLLoader

    @FXML // fx:id="txtBudget"
    private TextField txtBudget; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumeroComuni"
    private TextField txtNumeroComuni; // Value injected by FXMLLoader
   
    boolean produzione=false;
    String areaScelta;
    String produzioneDi;
  
    /*
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
    		List<Regione> produzioneC = model.getRegioni();
    		model.calcolaProduzioneEolicoComune(produzioneC);
    		tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}
    	
    	if(areaScelta.compareTo("Italia: PS")==0) {
    		List<Regione> produzioneC = model.statoRegioni("PS");
    			tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}
    	if(areaScelta.compareTo("Italia: MS")==0) {
    		List<Regione> produzioneC = model.statoRegioni("MS");
    			tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}
    	if(areaScelta.compareTo("Italia: IT")==0) {
    		List<Regione> produzioneC = model.statoRegioni("IT");
    			tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
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
    		List<Regione> produzioneC = model.calcolaProduzioneFotovoltaicoComune(model.getRegioni());
    		tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}
    	
    	if(areaScelta.compareTo("Italia: PS")==0) {
    		List<Regione> produzioneC = model.statoRegioni("PS");
    			tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}
    	
    	if(areaScelta.compareTo("Italia: MS")==0) {
    		List<Regione> produzioneC = model.statoRegioni("MS");
    			tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}
    	
    	if(areaScelta.compareTo("Italia: IT")==0) {
    		List<Regione> produzioneC = model.statoRegioni("IT");
    			tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}
    }
    */
   
    
    
    @FXML
    void doProduzionetot(ActionEvent event) {
    	txtResult.clear();
    	produzione=true;

    	areaScelta = this.cmbAreaDiRiferimento.getValue();
    	
		this.btnProduzioneTot.setDisable(false);
		this.btnAvvia.setDisable(false);
    	this.btnReset.setDisable(false);
    	
    	if(areaScelta==null) {
    		txtResult.appendText("Seleziona un area di riferimento");
    		return;
    	}
    	
    	if(areaScelta.compareTo("Italia")==0) {
    		List<Regione> produzioneC = model.getRegioni();
    		model.calcolaProduzioneEolicoComune(produzioneC);
    		model.calcolaProduzioneFotovoltaicoComune(produzioneC);
    		tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}
    	
    	if(areaScelta.compareTo("Italia: PS")==0) {
    		List<Regione> produzioneC = model.statoRegioni("PS");
    			tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}
    	if(areaScelta.compareTo("Italia: MS")==0) {
    		List<Regione> produzioneC = model.statoRegioni("MS");
    			tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}
    	if(areaScelta.compareTo("Italia: IT")==0) {
    		List<Regione> produzioneC = model.statoRegioni("IT");
    			tblOutput.setItems(FXCollections.observableArrayList(produzioneC));
    	}

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doRicorsione(ActionEvent event) {
    	txtResult.clear();
    	areaScelta = this.cmbAreaDiRiferimento.getValue();
    	produzioneDi= this.boxParamRicorsione.getValue();

    	int numeroComuni;
    	float budgetFinanziamento;
    	
    	try {
    		numeroComuni=Integer.parseInt(this.txtNumeroComuni.getText());
    		budgetFinanziamento=Float.parseFloat(this.txtBudget.getText());
    	}catch(NumberFormatException e) {
    		txtResult.clear();
    		txtResult.appendText("Inserire numero Regioni e budget validi");
    		return;
    	}
    	if(areaScelta==null) {
    		txtResult.appendText("Seleziona un area di riferimento");
    		return;
    	}
    	if(produzione==false) {
    		txtResult.appendText("Calcolare prima la produzione per comune");
    	}
		
    	if(produzioneDi.compareTo("Eolico")==0) {
    		//far restituire solo la produzione Eolica, modificare toString
    		txtResult.appendText("Regioni a cui assegnare i finaniamenti per l'Eolico:\n");
    		for(Regione r: model.cercaMiglioreEOL(numeroComuni)) {
        		txtResult.appendText(r+ " " + r.getComuniMeno5000() + " ");
        		txtResult.appendText("Budget assegnato "+ model.calcolaBudget(budgetFinanziamento, model.cercaMiglioreEOL(numeroComuni))*r.getComuniMeno5000() + "\n");
        	}
    	}
    	if(produzioneDi.compareTo("Fotovoltaico")==0) {
    		//far restituire solo la produzione Solare, modificare toString
    		txtResult.appendText("Regioni a cui assegnare i finaniamenti per il Solare Fotovoltaico:\n");
    		for(Regione r: model.cercaMiglioreSOL(numeroComuni)) {
    			txtResult.appendText(r+ " " + r.getComuniMeno5000() + " ");
        		txtResult.appendText("BUDGET assegnato: "+ model.calcolaBudget(budgetFinanziamento, model.cercaMiglioreSOL(numeroComuni))*r.getComuniMeno5000()+ "\n");
        	}
    		
    	}
    	if(produzioneDi.compareTo("Eolico e Fotovoltaico")==0) {
    		Map<Regione, String> mista = model.EolFot(numeroComuni);
    		txtResult.appendText("Regioni a cui assegnare i finaniamenti:\n");
    		//per trovare la soluzione migliore per entrambi tra solare ed eolico
    		for(Regione r: mista.keySet()) {
        		txtResult.appendText(r + " " + r.getComuniMeno5000() + " " + mista.get(r)+"\n");
        	}
    	}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxParamRicorsione != null : "fx:id=\"boxParamRicorsione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAvvia != null : "fx:id=\"btnAvvia\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProduzioneTot != null : "fx:id=\"btnProduzioneTot\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clProdEolico != null : "fx:id=\"clProdEolico\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clProdSolareFotovoltaico != null : "fx:id=\"clProdSolareFotovoltaico\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clRegione != null : "fx:id=\"clRegione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbAreaDiRiferimento != null : "fx:id=\"cmbAreaDiRiferimento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tblOutput != null : "fx:id=\"tblOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtBudget != null : "fx:id=\"txtBudget\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumeroComuni != null : "fx:id=\"txtNumeroComuni\" was not injected: check your FXML file 'Scene.fxml'.";

    
        clRegione.setCellValueFactory(new PropertyValueFactory<Regione, String>("regione")); //NON FUNZIONA QUESTA RIGA
       
		clProdEolico.setCellValueFactory(new PropertyValueFactory<Regione, Double>("prodEolicoPerComune"));
		
		clProdSolareFotovoltaico.setCellValueFactory(new PropertyValueFactory<Regione, Double>("prodFotovoltaicoPerComune"));
        
    }
    
    public void setModel(Model model) {
    	this.model = model;
    	this.cmbAreaDiRiferimento.getItems().add("Italia");
    	this.cmbAreaDiRiferimento.getItems().add("Italia: PS");
    	this.cmbAreaDiRiferimento.getItems().add("Italia: MS");
    	this.cmbAreaDiRiferimento.getItems().add("Italia: IT");
    	
    	this.boxParamRicorsione.getItems().add("Eolico");
    	this.boxParamRicorsione.getItems().add("Fotovoltaico");
    	this.boxParamRicorsione.getItems().add("Eolico e Fotovoltaico");
    	
    	this.btnAvvia.setDisable(true);
    	this.btnReset.setDisable(true);
    }
}

   



