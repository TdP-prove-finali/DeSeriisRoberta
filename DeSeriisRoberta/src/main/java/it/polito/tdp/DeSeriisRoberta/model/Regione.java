package it.polito.tdp.DeSeriisRoberta.model;

import java.util.Objects;

public class Regione {
	
	private String regione;
	private double prodTotNettaEnergiaElett;
	private double prodNettaEnergiaElettFotovoltaico;
	private double prodNettaEnergiaElettEolico;
	private double potEffLordaPerc;
	private double potEffLordaEolico;
	private double potEffLordaFotovoltaico;
	private double potenzaEfficienteLordaTot;
	private int famiglie; 
	private int  superficieCentriAbitati; 
	private int popolazioneResidenteMedia; 
	private int consumiFinaliLordiEnergia;
	private double consumeCopertiDaImpiantiEolici;
	private double consumiCopertiDaImpiantiFotovoltaici;
	private String statoRegione;
	private int ComuniCon5000;
	private int ComuniTot;
	private double prodFotovoltaicaPerComune;
	private double prodEolicaPerComune;
	
	
	public Regione(String regione, double prodTotNElett_GWh, double prodNEElett_Fot_GWh,
			 double prodNEElett_Eol_GWh, double potEffLordaPerc, double potEffLordaEol_MW, double potEffLordaFot_MW,
			 double potenzaEfficienteLordaTotale_MW, int famiglie, 
			 int superficieCA, int popolazioneRM, int consumiFLE, double consumeCopE, 
			 double consumiCopS, String statoRegione, int ComuniMeno5000, int ComuniTot) {
		
		this.regione = regione;
		this.prodTotNettaEnergiaElett = prodTotNElett_GWh;
		this.prodNettaEnergiaElettFotovoltaico = prodNEElett_Fot_GWh;
		this.prodNettaEnergiaElettEolico = prodNEElett_Eol_GWh;
		this.potEffLordaPerc = potEffLordaPerc;
		this.potEffLordaEolico = potEffLordaEol_MW;
		this.potEffLordaFotovoltaico = potEffLordaFot_MW;
		this.potenzaEfficienteLordaTot= potenzaEfficienteLordaTotale_MW;
		this.famiglie = famiglie;
		this.superficieCentriAbitati = superficieCA;
		this.popolazioneResidenteMedia = popolazioneRM;
		this.consumiFinaliLordiEnergia = consumiFLE;
		this.consumeCopertiDaImpiantiEolici = consumeCopE;
		this.consumiCopertiDaImpiantiFotovoltaici = consumiCopS;
		this.statoRegione = statoRegione;
		this.ComuniCon5000 = ComuniMeno5000;
		this.ComuniTot= ComuniTot;
		
	}
	
	public String getRegione() {
		return regione;
	}
	
	public void setRegione(String regione) {
		this.regione = regione;
	}
	
	public double getProdTotNElett_GWh() {
		return prodTotNettaEnergiaElett;
	}
	
	public void setProdTotNElett_GWh(double prodTotNElett_GWh) {
		this.prodTotNettaEnergiaElett = prodTotNElett_GWh;
	}
	
	public double getProdNEElett_Fot_GWh() {
		return prodNettaEnergiaElettFotovoltaico;
	}
	
	public void setProdNEElett_Fot_GWh(double prodNEElett_Fot_GWh) {
		this.prodNettaEnergiaElettFotovoltaico = prodNEElett_Fot_GWh;
	}
	
	public double getProdNEElett_Eol_GWh() {
		return prodNettaEnergiaElettEolico;
	}
	
	public void setProdNEElett_Eol_GWh(double prodNEElett_Eol_GWh) {
		this.prodNettaEnergiaElettEolico = prodNEElett_Eol_GWh;
	}
	
	public double getPotEffLordaPerc() {
		return potEffLordaPerc;
	}
	
	public void setPotEffLordaPerc(double potEffLordaPerc) {
		this.potEffLordaPerc = potEffLordaPerc;
	}
	
	public double getPotEffLordaEol_MW() {
		return potEffLordaEolico;
	}
	
	public void setPotEffLordaEol_MW(double potEffLordaEol_MW) {
		this.potEffLordaEolico = potEffLordaEol_MW;
	}
	
	public double getPotEffLordaFot_MW() {
		return potEffLordaFotovoltaico;
	}
	
	public void setPotEffLordaFot_MW(double potEffLordaFot_MW) {
		this.potEffLordaFotovoltaico = potEffLordaFot_MW;
	}
	
	public double getPotenzaEfficienteLordaTotale_MW() {
		return potenzaEfficienteLordaTot;
	}
	
	public void setPotenzaEfficienteLordaTotale_MW(double potenzaEfficienteLordaTotale_MW) {
		this.potenzaEfficienteLordaTot = potenzaEfficienteLordaTotale_MW;
	}
	
	public int getFamiglie() {
		return famiglie;
	}
	
	public void setFamiglie(int famiglie) {
		this.famiglie = famiglie;
	}
	
	public int getSuperficieCA() {
		return superficieCentriAbitati;
	}
	
	public void setSuperficieCA(int superficieCA) {
		this.superficieCentriAbitati = superficieCA;
	}
	
	public int getPopolazioneRM() {
		return popolazioneResidenteMedia;
	}
	
	public void setPopolazioneRM(int popolazioneRM) {
		this.popolazioneResidenteMedia = popolazioneRM;
	}
	
	public int getConsumiFLE() {
		return consumiFinaliLordiEnergia;
	}
	
	public void setConsumiFLE(int consumiFLE) {
		this.consumiFinaliLordiEnergia = consumiFLE;
	}
	
	public double getConsumeCopE() {
		return consumeCopertiDaImpiantiEolici;
	}
	
	public void setConsumeCopE(double consumeCopE) {
		this.consumeCopertiDaImpiantiEolici = consumeCopE;
	}
	
	public double getConsumiCopS() {
		return consumiCopertiDaImpiantiFotovoltaici;
	}
	
	public void setConsumiCopS(double consumiCopS) {
		this.consumiCopertiDaImpiantiFotovoltaici = consumiCopS;
	}
	
	public String getStatoRegione() {
		return statoRegione;
	}
	
	public void setStatoRegione(String statoRegione) {
		this.statoRegione = statoRegione;
	}
	
	public int getComuniMeno5000() {
		return ComuniCon5000;
	}
	
	public void setComuniMeno5000(int comuniMeno5000) {
		ComuniCon5000 = comuniMeno5000;
	}
	
	public int getComuniTot() {
		return ComuniTot;
	}
	
	public void setComuniTot(int comuniTot) {
		ComuniTot = comuniTot;
	}
	
	public double getProdFotovoltaicoPerComune() {
		return prodFotovoltaicaPerComune;
	}
	
	public void setProdFotovoltaicoPerComune(double prodFotovoltaicoPerComune) {
		this.prodFotovoltaicaPerComune = prodFotovoltaicoPerComune;
	}
	
	public double getProdEolicoPerComune() {
		return prodEolicaPerComune;
	}
	
	public void setProdEolicoPerComune(double prodEolicoPerComune) {
		this.prodEolicaPerComune = prodEolicoPerComune;
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


