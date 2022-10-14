package it.polito.tdp.DeSeriisRoberta.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.DeSeriisRoberta.db.EnergiaDAO;

public class Model {
	
	EnergiaDAO dao; 
	List <RendimentoRegione> regioniItalia; 
	List<RendimentoRegione> regioni; 
	List <RendimentoRegione> regioniSelezionate;
	double rendimentoEol; 
	double rendimentoFot; 
	List<String> migliore; 
	double budget=0;
	
	
	public List<RendimentoRegione> getRegioni() {
		return dao.getRegioni();
	}

	public Model() {
		this.dao= new EnergiaDAO(); 
	}

	public List<RendimentoRegione> calcolaRendimento(List<RendimentoRegione> regioni) {
		//calcolare il rendimento di tutte le regioni italiane
		//calcolare il rendimento delle regioni +/- sviluppate e in transizione
		//calcolare il rendimento di tutte le regioni suddivise per statoRegione
		
	
		for (RendimentoRegione r: regioni) {
			if (r.getPotEolico()>0 && r.getPotFotovoltaico()>0) {
			rendimentoEol= ((r.getProdEolico()*1000)/(24*365))/r.getPotEolico(); 
			rendimentoFot= ((r.getProdFotovoltaico()*1000)/(24*365))/r.getPotFotovoltaico();
			r.setRendimentoEol(rendimentoEol);
			r.setRendimentoSol(rendimentoFot);
			}
			else if(r.getPotEolico()==0) {
				rendimentoEol=0; 
			}
			else if(r.getPotEolico()==0) {
				rendimentoFot=0; 
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
		this.calcolaRendimento(regioniSelezionate);
		
		return regioniSelezionate;
	}
	
	/*
	public List<String> calcolaPercorso(String sorg, String dest)
	{
		migliore = new LinkedList<String>();
		List<String> parziale = new LinkedList<>();
		parziale.add(sorg);
		cercaRicorsiva(parziale, dest);
		return migliore;
	} 
	
	private void cercaRicorsiva(List<String> parziale, String dest) {
		 
		//condizione di terminazione
		if(budget==0)
		{ //ora ce lo teniamo
		//suddivisione per regione, per rendimento attuale e poi per numero comuni 
			int pesoParziale = pesoTot(parziale);
			if(pesoParziale > pesoTot(migliore))  //la strada piú lunga é la migliore
			{
				migliore = new LinkedList<>(parziale);
			}
			return;
		}
		
		for(String v:Graphs.neighborListOf(this.grafo, parziale.get(parziale.size()-1))) //scorro sui vicini dell'ultimo nodo sulla lista
		{
			if(!parziale.contains(v))
			{
				parziale.add(v);
				cercaRicorsiva(parziale, dest);
				parziale.remove(parziale.size()-1);
			}
			
		}

}

private int pesoTot(List<String> parziale) {

int peso = 0;
int i = 0;
for(DefaultWeightedEdge e: grafo.edgeSet())
{
	while(i<parziale.size()-2)
	{
		if(grafo.getEdgeSource(e).compareTo(parziale.get(i))==0 && grafo.getEdgeSource(e).compareTo(parziale.get(i+1))==0)
		{
			peso += grafo.getEdgeWeight(e);
		}
		i++;
	}
}
return peso;
}
*/
}
