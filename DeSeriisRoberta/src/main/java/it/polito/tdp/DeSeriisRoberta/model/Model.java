package it.polito.tdp.DeSeriisRoberta.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.DeSeriisRoberta.db.EnergiaDAO;
  
	public class Model {
	
		EnergiaDAO dao; 
		Map<String, Regione> idMap;
		List <Regione> regioniItalia; 
		List<Regione> reg; 
		List <Regione> regioniSelezionate;
		List<Regione> miglioreE;
		List<Regione> miglioreS;
		double aM;
		double aME;
		double aMS;
	
	
		public List<Regione> getRegioni() {
			return dao.getAllRegioni();
		}

		
		public Model() {
			this.dao= new EnergiaDAO(); 
		}

		
		public List<Regione> calcolaProduzioneFotovoltaicoComune(List<Regione> regioni) {
			double produzioneFotComunale;
			for (Regione r: regioni) {
				if(r.getProdNEElett_Fot_GWh()>0) { // (r.getProdNEElett_Eol_GWh()>0)
					produzioneFotComunale= r.getProdNEElett_Fot_GWh()/r.getComuniTot(); 
					r.setProdFotovoltaicoPerComune(produzioneFotComunale);
				}
				else
					produzioneFotComunale=0; 
			}
			reg = new LinkedList<Regione>(regioni);
			return regioni; 
		}
	
		
		public List<Regione> calcolaProduzioneEolicoComune(List<Regione> regioni) {
			double produzioneEolComunale;
			for (Regione r: regioni) {
				if(r.getProdNEElett_Eol_GWh()>0) {
					produzioneEolComunale= r.getProdNEElett_Eol_GWh()/r.getComuniTot(); 
					r.setProdEolicoPerComune(produzioneEolComunale);
				}
				else
					produzioneEolComunale=0; 
				}
				reg = new LinkedList<Regione>(regioni);
				return regioni; 
		}
	
		
		public List<Regione> statoRegioni(String tipo) { 
			regioniItalia = dao.getAllRegioni();
			regioniSelezionate = new ArrayList<>(); 
			
			for (Regione r: regioniItalia) {
				if(r.getStatoRegione().compareTo(tipo)==0) {
					regioniSelezionate.add(r);
				}
			}
			this.calcolaProduzioneFotovoltaicoComune(regioniSelezionate);
			this.calcolaProduzioneEolicoComune(regioniSelezionate);
		
			return regioniSelezionate;
		}
	
	
		public List<Regione> calcolaMiglioreEol (int n) {
			miglioreE = new LinkedList<Regione>();
			List<Regione> parziale = new LinkedList<Regione>();
			aM = Double.MAX_VALUE;
		
			cercaMiglioreEol(parziale,0,n);
			return miglioreE;
		}
	
		
		private void cercaMiglioreEol(List<Regione> parziale, int L, int n) {
			int sommaComuni = sommaComuni(parziale);
		
			if(sommaComuni>n)
				return;
		
			if(sommaComuni != 0 && sommaComuni <= n) {
				double param = calcolaParametroEol(parziale);
				
				if(param < aM && sommaComuni > sommaComuni(miglioreE)) {
					miglioreE = new LinkedList<Regione>(parziale);
					aM = param;
				}
			}
		
			if(L == reg.size()) {
				return;
			}
		
			if(reg.get(L).getProdEolicoPerComune()>0) {
				parziale.add(reg.get(L));
				this.cercaMiglioreEol(parziale, L+1, n);
			
				parziale.remove(reg.get(L));
				this.cercaMiglioreEol(parziale, L+1, n);
			}
		}

		
		private double calcolaParametroEol(List<Regione> parziale) {
			double s = 0;
			double nC = 0;
	
			for (Regione r:parziale) {
				s += r.getProdEolicoPerComune();
				nC += r.getComuniTot();
			}
			return (s/nC);
		}
		
		
		private int sommaComuni(List<Regione> parziale) {
			int nCom = 0;
			
			for(Regione r:parziale) {
				nCom += r.getComuniMeno5000();
			}
			return nCom;
		}
		
		
		public List<Regione> calcolaMiglioreFot (int n) {
			miglioreS = new LinkedList<Regione>();
			List<Regione> parziale = new LinkedList<Regione>();
			aM = Double.MAX_VALUE;
		
			cercaMiglioreFot(parziale,0,n);
			return miglioreS;
		}

		
		private void cercaMiglioreFot(List<Regione> parziale, int L, int n) {
			int sommaComuni = sommaComuni(parziale);
	
			if(sommaComuni>n)
				return;
	
			if(sommaComuni != 0 && sommaComuni <= n) {
				double param = calcolaParametroFot(parziale);
				if(param < aM && sommaComuni > sommaComuni(miglioreS)) {
					miglioreS = new LinkedList<Regione>(parziale);
					aM = param;
				}
			}
	
			if(L == reg.size()) {
				return;
			}
	
			if(reg.get(L).getProdFotovoltaicoPerComune()>0) {
				parziale.add(reg.get(L));
				this.cercaMiglioreFot(parziale, L+1, n);
				
				parziale.remove(reg.get(L));
				this.cercaMiglioreFot(parziale, L+1, n);
			}
	
		}

		
		private double calcolaParametroFot(List<Regione> parziale) {
			double s = 0;
			double nC = 0;
	
			for(Regione r:parziale) {
				s += r.getProdFotovoltaicoPerComune();
				nC += r.getComuniTot();
			}
	
			return s/nC;
		}

		
		public void calcolaMigliore (int n) {
			miglioreS = new LinkedList<Regione>();
			miglioreE = new LinkedList<Regione>();
			List<Regione> parzialeE = new LinkedList<Regione>();
			List<Regione> parzialeS = new LinkedList<Regione>();
			aME = Double.MAX_VALUE;
			aMS = Double.MAX_VALUE;
		
			cercaMiglioreFotEol(parzialeE, parzialeS ,0,n);
		}
		
		
		private void cercaMiglioreFotEol(List<Regione> parzialeE, List<Regione> parzialeS, int L, int n) {
			int sommaComuniE = sommaComuni(parzialeE);
			int sommaComuniS = sommaComuni(parzialeS);
			
			if(sommaComuniE + sommaComuniS > n)
				return;
		
			if(sommaComuniE + sommaComuniS <= n) {
				double paramE = calcolaParametroEol(parzialeE);
				double paramS = calcolaParametroFot(parzialeS);
				
				if(paramE < aME ) {
					miglioreE = new LinkedList<Regione>(parzialeE);
					aME = paramE;
				}
				
				if(paramS < aMS ) {
					miglioreS = new LinkedList<Regione>(parzialeS);
					aMS = paramS;
				}
			} 
		
			if(L == reg.size()) {
				return;
			}
		
			if(reg.get(L).getProdEolicoPerComune() < reg.get(L).getProdFotovoltaicoPerComune() 
					&& reg.get(L).getProdEolicoPerComune() != 0) {
				parzialeE.add(reg.get(L));
				this.cercaMiglioreFotEol(parzialeE, parzialeS, L+1, n);
				parzialeE.remove(reg.get(L));
				this.cercaMiglioreFotEol(parzialeE, parzialeS, L+1, n);
			}
			if (reg.get(L).getProdEolicoPerComune() > reg.get(L).getProdFotovoltaicoPerComune() 
					&& reg.get(L).getProdFotovoltaicoPerComune() != 0 ){ 
				parzialeS.add(reg.get(L));
				this.cercaMiglioreFotEol(parzialeE, parzialeS, L+1, n);
				parzialeS.remove(reg.get(L));
				this.cercaMiglioreFotEol(parzialeE, parzialeS, L+1, n);
			}
		} 

		
		public List<Regione> getMiglioreE() {
			return miglioreE;
		}


		public List<Regione> getMiglioreS() {
			return miglioreS;
		}

		
		public float calcolaBudget (float budget, List<Regione> migliore) {
			int nComuni = 0;
			float budgetAssegnato = 0;
			
			for(Regione r:migliore) {
				nComuni += r.getComuniMeno5000();
			}
			
			budgetAssegnato = (budget/nComuni);
			return budgetAssegnato;
		}
	}
