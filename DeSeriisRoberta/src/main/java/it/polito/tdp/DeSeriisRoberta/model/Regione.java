package it.polito.tdp.DeSeriisRoberta.model;

import java.util.Objects;

public class Regione {
	
	private String regione;
	private double prodTotNElett_GWh;
	private double prodNEElett_Fot_GWh;
	private double prodNEElett_Eol_GWh;
	private double potEffLordaPerc;
	private double potEffLordaEol_MW;
	private double potEffLordaFot_MW;
	private double potenzaEfficienteLordaTotale_MW;
	private int numImpiantiEol;
	private int numImpiantiFot;
	private int famiglie; 
	private int  superficieCA; 
	private int popolazioneRM; 
	private int consumiFLE;
	private double consumeCopE;
	private double consumiCopS;
	private String statoRegione;
	private int ComuniMeno5000;
	private int ComuniTot;
	private double prodFotovoltaicoPerComune;
	private double prodEolicoPerComune;
	
	
	public Regione(String regione, double prodTotNElett_GWh, double prodNEElett_Fot_GWh,
			 double prodNEElett_Eol_GWh, double potEffLordaPerc, double potEffLordaEol_MW, double potEffLordaFot_MW,
			 double potenzaEfficienteLordaTotale_MW, int numImpiantiEol, int numImpiantiFot, int famiglie, 
			 int superficieCA, int popolazioneRM, int consumiFLE, double consumeCopE, 
			 double consumiCopS, String statoRegione, int ComuniMeno5000, int ComuniTot) {
		
		this.regione = regione;
		this.prodTotNElett_GWh = prodTotNElett_GWh;
		this.prodNEElett_Fot_GWh = prodNEElett_Fot_GWh;
		this.prodNEElett_Eol_GWh = prodNEElett_Eol_GWh;
		this.potEffLordaPerc = potEffLordaPerc;
		this.potEffLordaEol_MW = potEffLordaEol_MW;
		this.potEffLordaFot_MW = potEffLordaFot_MW;
		this.potenzaEfficienteLordaTotale_MW= potenzaEfficienteLordaTotale_MW;
		this.numImpiantiEol = numImpiantiEol;
		this.numImpiantiFot = numImpiantiFot;
		this.famiglie = famiglie;
		this.superficieCA = superficieCA;
		this.popolazioneRM = popolazioneRM;
		this.consumiFLE = consumiFLE;
		this.consumeCopE = consumeCopE;
		this.consumiCopS = consumiCopS;
		this.statoRegione = statoRegione;
		this.ComuniMeno5000 = ComuniMeno5000;
		this.ComuniTot= ComuniTot;
		
	}
	
	public String getRegione() {
		return regione;
	}
	
	public void setRegione(String regione) {
		this.regione = regione;
	}
	
	public double getProdTotNElett_GWh() {
		return prodTotNElett_GWh;
	}
	
	public void setProdTotNElett_GWh(double prodTotNElett_GWh) {
		this.prodTotNElett_GWh = prodTotNElett_GWh;
	}
	
	public double getProdNEElett_Fot_GWh() {
		return prodNEElett_Fot_GWh;
	}
	
	public void setProdNEElett_Fot_GWh(double prodNEElett_Fot_GWh) {
		this.prodNEElett_Fot_GWh = prodNEElett_Fot_GWh;
	}
	
	public double getProdNEElett_Eol_GWh() {
		return prodNEElett_Eol_GWh;
	}
	
	public void setProdNEElett_Eol_GWh(double prodNEElett_Eol_GWh) {
		this.prodNEElett_Eol_GWh = prodNEElett_Eol_GWh;
	}
	
	public double getPotEffLordaPerc() {
		return potEffLordaPerc;
	}
	
	public void setPotEffLordaPerc(double potEffLordaPerc) {
		this.potEffLordaPerc = potEffLordaPerc;
	}
	
	public double getPotEffLordaEol_MW() {
		return potEffLordaEol_MW;
	}
	
	public void setPotEffLordaEol_MW(double potEffLordaEol_MW) {
		this.potEffLordaEol_MW = potEffLordaEol_MW;
	}
	
	public double getPotEffLordaFot_MW() {
		return potEffLordaFot_MW;
	}
	
	public void setPotEffLordaFot_MW(double potEffLordaFot_MW) {
		this.potEffLordaFot_MW = potEffLordaFot_MW;
	}
	
	public int getNumImpiantiEol() {
		return numImpiantiEol;
	}
	
	public void setNumImpiantiEol(int numImpiantiEol) {
		this.numImpiantiEol = numImpiantiEol;
	}
	
	public double getPotenzaEfficienteLordaTotale_MW() {
		return potenzaEfficienteLordaTotale_MW;
	}
	
	public void setPotenzaEfficienteLordaTotale_MW(double potenzaEfficienteLordaTotale_MW) {
		this.potenzaEfficienteLordaTotale_MW = potenzaEfficienteLordaTotale_MW;
	}
	
	public int getNumImpiantiFot() {
		return numImpiantiFot;
	}
	
	public void setNumImpiantiFot(int numImpiantiFot) {
		this.numImpiantiFot = numImpiantiFot;
	}
	
	public int getFamiglie() {
		return famiglie;
	}
	
	public void setFamiglie(int famiglie) {
		this.famiglie = famiglie;
	}
	
	public int getSuperficieCA() {
		return superficieCA;
	}
	
	public void setSuperficieCA(int superficieCA) {
		this.superficieCA = superficieCA;
	}
	
	public int getPopolazioneRM() {
		return popolazioneRM;
	}
	
	public void setPopolazioneRM(int popolazioneRM) {
		this.popolazioneRM = popolazioneRM;
	}
	
	public int getConsumiFLE() {
		return consumiFLE;
	}
	
	public void setConsumiFLE(int consumiFLE) {
		this.consumiFLE = consumiFLE;
	}
	
	public double getConsumeCopE() {
		return consumeCopE;
	}
	
	public void setConsumeCopE(double consumeCopE) {
		this.consumeCopE = consumeCopE;
	}
	
	public double getConsumiCopS() {
		return consumiCopS;
	}
	
	public void setConsumiCopS(double consumiCopS) {
		this.consumiCopS = consumiCopS;
	}
	
	public String getStatoRegione() {
		return statoRegione;
	}
	
	public void setStatoRegione(String statoRegione) {
		this.statoRegione = statoRegione;
	}
	
	public int getComuniMeno5000() {
		return ComuniMeno5000;
	}
	
	public void setComuniMeno5000(int comuniMeno5000) {
		ComuniMeno5000 = comuniMeno5000;
	}
	
	public int getComuniTot() {
		return ComuniTot;
	}
	
	public void setComuniTot(int comuniTot) {
		ComuniTot = comuniTot;
	}
	
	public double getProdFotovoltaicoPerComune() {
		return prodFotovoltaicoPerComune;
	}
	
	public void setProdFotovoltaicoPerComune(double prodFotovoltaicoPerComune) {
		this.prodFotovoltaicoPerComune = prodFotovoltaicoPerComune;
	}
	
	public double getProdEolicoPerComune() {
		return prodEolicoPerComune;
	}
	
	public void setProdEolicoPerComune(double prodEolicoPerComune) {
		this.prodEolicoPerComune = prodEolicoPerComune;
	}
	
	@Override
	public String toString() {
		return  regione;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(regione);
	}
}


