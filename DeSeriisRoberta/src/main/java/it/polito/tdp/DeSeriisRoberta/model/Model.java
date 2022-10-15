package it.polito.tdp.DeSeriisRoberta.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.DeSeriisRoberta.db.EnergiaDAO;

public class Model {
	
	EnergiaDAO dao; 
	List <RendimentoRegione> regioniItalia; 
	List<RendimentoRegione> reg; 
	List <RendimentoRegione> regioniSelezionate;
	double rendimentoEol; 
	double rendimentoFot; 
	List<Risultato> migliore; 
	double budget=0;
	
	
	public List<RendimentoRegione> getRegioni() {
		return dao.getRegioni();
	}

	public Model() {
		this.dao= new EnergiaDAO(); 
	}

	public List<RendimentoRegione> calcolaRendimentoSolare(List<RendimentoRegione> regioni) {
		//calcolare il rendimento di tutte le regioni italiane
		//calcolare il rendimento delle regioni +/- sviluppate e in transizione
		//calcolare il rendimento di tutte le regioni suddivise per statoRegione
		
	
		for (RendimentoRegione r: regioni) {
			if (r.getPotEolico()>0 && r.getPotFotovoltaico()>0) {
			rendimentoFot= ((r.getProdFotovoltaico()*1000)/(24*365))/r.getPotFotovoltaico();
			r.setRendimentoSol(rendimentoFot);
			}
			else if(r.getPotFotovoltaico()==0) {
				rendimentoFot=0; 
			}
		}
		
		return regioni;
	}
	public List<RendimentoRegione> calcolaRendimentoEolico(List<RendimentoRegione> regioni) {
		//calcolare il rendimento di tutte le regioni italiane
		//calcolare il rendimento delle regioni +/- sviluppate e in transizione
		//calcolare il rendimento di tutte le regioni suddivise per statoRegione
		
	
		for (RendimentoRegione r: regioni) {
			if (r.getPotEolico()>0 && r.getPotFotovoltaico()>0) {
			rendimentoEol= ((r.getProdEolico()*1000)/(24*365))/r.getPotEolico(); 
			r.setRendimentoEol(rendimentoEol);
			}
			else if(r.getPotEolico()==0) {
				rendimentoEol=0; 
			}
		}
		reg = new LinkedList<RendimentoRegione>(regioni);	
		return regioni;
	}
	
	public List<Risultato> calcolaRendimentoEolicoR(List<Risultato> regioni) {
		//calcolare il rendimento di tutte le regioni italiane
		//calcolare il rendimento delle regioni +/- sviluppate e in transizione
		//calcolare il rendimento di tutte le regioni suddivise per statoRegione
		
	
		for (Risultato r: regioni) {
			if (r.getR().getPotEolico()>0) {
			rendimentoEol= ((r.getR().getProdEolico()*1000)/(24*365))/r.getR().getPotEolico(); 
			r.getR().setRendimentoEol(rendimentoEol);
			}
			else if(r.getR().getPotEolico()==0) {
				rendimentoEol=0; 
			}
		}
			
		return regioni;
	}

	//in base alla tipologia di regioni selezionata
	public List<RendimentoRegione> statoRegioni(String tipo) { 
		regioniItalia = dao.getRegioni();
		 regioniSelezionate = new ArrayList<>(); 
		//regioni=dao.getTipoRegioni(tipo); per le regioni +/-/in transiizone 
		for (RendimentoRegione r: regioniItalia) {
			if(r.getTipoRegione().compareTo(tipo)==0) {
				regioniSelezionate.add(r);
			}
		}
		System.out.println(regioniSelezionate.size());
		this.calcolaRendimentoSolare(regioniSelezionate);
		this.calcolaRendimentoEolico(regioniSelezionate);
		
		return regioniSelezionate;
	}
	
	
	public List<Risultato> calcolaBudget(double budget)
	{
		
		List<Risultato> parziale = new LinkedList<>();
		System.out.println(reg.size());
		for(RendimentoRegione r:reg)
		{
			parziale.add(new Risultato(r, 0));
		}
		migliore = new LinkedList<Risultato>(parziale);
		cercaRicorsiva(parziale, budget);
		return migliore;
	} 
	
	private void cercaRicorsiva(List<Risultato> parziale, double budget) {
		 
		if(budget<=0)
		{
			this.aggiornaRendimenti(parziale);
			double scartoParziale = calcolaScarto(parziale);
			double scartoMigliore = calcolaScarto(migliore);
			if(scartoParziale < scartoMigliore)  
			{
				migliore = new LinkedList<>(parziale);
			}
			return;
		}
		
		for(Risultato r: parziale) //scorro sui vicini dell'ultimo nodo sulla lista
		{
				double budgetDaAssegnare = calcolaBudgetDaAssegnare(r);
				r.setBudgetAssegnato(r.getBudgetAssegnato() + budgetDaAssegnare);
				budget = budget - budgetDaAssegnare;
				cercaRicorsiva(parziale, budget);
				r.setBudgetAssegnato(r.getBudgetAssegnato() - budgetDaAssegnare);
				budget = budget + budgetDaAssegnare;
		}

}

		private double calcolaBudgetDaAssegnare(Risultato r) {
			
		return 10000000;
	}

		private void aggiornaRendimenti(List<Risultato> parziale) {
			
			for(Risultato p:parziale)
			{
				p.getR().setProdEolico(p.getR().getProdEolico()*3);  //3 Kw ogni 1000 euro
			}
			
			this.calcolaRendimentoEolicoR(parziale);
		
	}

		private double calcolaScarto(List<Risultato> parziale) {
			
			double scarto = 0;
		
			for(Risultato r:parziale)
			{
				for(Risultato r1:parziale)
				{
					scarto += Math.abs(r.getR().getRendimentoEol() - r1.getR().getRendimentoEol());
				}
			}
			
			
			return scarto;
	}



}
