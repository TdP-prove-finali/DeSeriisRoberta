package it.polito.tdp.DeSeriisRoberta.model;

public class Risultato {
	
	RendimentoRegione r;
	double budgetAssegnato;
	
	
	public Risultato(RendimentoRegione r, double budgetAssegnato) {
		this.r = r;
		this.budgetAssegnato = budgetAssegnato;
	}


	public RendimentoRegione getR() {
		return r;
	}


	public void setR(RendimentoRegione r) {
		this.r = r;
	}


	public double getBudgetAssegnato() {
		return budgetAssegnato;
	}


	public void setBudgetAssegnato(double budgetAssegnato) {
		this.budgetAssegnato = budgetAssegnato;
	}


	@Override
	public String toString() {
		return  r.getRegione() + ", budgetAssegnato=" + budgetAssegnato;
	}
	
	
	
	
	

}
