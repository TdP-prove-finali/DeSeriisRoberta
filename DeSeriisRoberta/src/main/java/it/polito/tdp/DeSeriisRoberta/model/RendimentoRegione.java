package it.polito.tdp.DeSeriisRoberta.model;

public class RendimentoRegione {

	private String regione; 
	private double prodFotovoltaico; 
	private double prodEolico; 
	private double potEolico; 
	private double potFotovoltaico;
	private double rendimentoEol;
	private double rendimentoSol; 
	private String tipoRegione; 
	
	public RendimentoRegione(String regione, double prodFotovoltaico, double prodEolico, double potEolico,
			double potFotovoltaico, String tipoRegione) {
		super();
		this.regione = regione;
		this.prodFotovoltaico = prodFotovoltaico;
		this.prodEolico = prodEolico;
		this.potEolico = potEolico;
		this.potFotovoltaico = potFotovoltaico;
		this.tipoRegione= tipoRegione; 
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public double getProdFotovoltaico() {
		return prodFotovoltaico;
	}

	public void setProdFotovoltaico(double prodFotovoltaico) {
		this.prodFotovoltaico = prodFotovoltaico;
	}

	public double getProdEolico() {
		return prodEolico;
	}

	public void setProdEolico(double prodEolico) {
		this.prodEolico = prodEolico;
	}

	public double getPotEolico() {
		return potEolico;
	}

	public void setPotEolico(double potEolico) {
		this.potEolico = potEolico;
	}

	public double getPotFotovoltaico() {
		return potFotovoltaico;
	}

	public void setPotFotovoltaico(double potFotovoltaico) {
		this.potFotovoltaico = potFotovoltaico;
	}

	

	public double getRendimentoEol() {
		return rendimentoEol;
	}

	public void setRendimentoEol(double rendimentoEol) {
		this.rendimentoEol = rendimentoEol;
	}

	public double getRendimentoSol() {
		return rendimentoSol;
	}

	public void setRendimentoSol(double rendimentoSol) {
		this.rendimentoSol = rendimentoSol;
	}

	public String getTipoRegione() {
		return tipoRegione;
	}

	public void setTipoRegione(String tipoRegione) {
		this.tipoRegione = tipoRegione;
	}
	
	
	
	
}
