package it.polito.tdp.DeSeriisRoberta.model;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	
		public List<Regione> getRegioni() {
			return dao.getAllRegioni();
		}

		
		public Model() {
			this.dao= new EnergiaDAO(); 
		}

		
		public List<Regione> calcolaProduzioneFotovoltaicoComune(List<Regione> regioni) {
			double produzioneFotComunale;
			for (Regione r: regioni) {
				if(r.getProdNEElett_Eol_GWh()>0) {
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
	
		
		//in base alla tipologia di regioni selezionata
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
	
	
		public List<Regione> cercaMiglioreEOL (int n) {
			miglioreE = new LinkedList<Regione>();
			List<Regione> parziale = new LinkedList<Regione>();
			aM = 999999999;
		
			cercaMeglioEOL(parziale,0,n);
			return miglioreE;
		}
	
		
		public List<Regione> cercaMiglioreSOL (int n) {
			miglioreS = new LinkedList<Regione>();
			List<Regione> parziale = new LinkedList<Regione>();
			aM = 999999999;
		
			cercaMeglioSOL(parziale,0,n);
			return miglioreS;
		}


		private void cercaMeglioEOL(List<Regione> parziale, int L, int n) {
			int sommaComuni = sommaComuni(parziale);
		
			if(sommaComuni>n)
				return;
		
			if(sommaComuni != 0 && sommaComuni <= n) {
				double param = calcolaParamEOL(parziale);
				
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
				this.cercaMeglioEOL(parziale, L+1, n);
			
				parziale.remove(reg.get(L));
				this.cercaMeglioEOL(parziale, L+1, n);
			}
		}

		
		private double calcolaParamEOL(List<Regione> parziale) {
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

		
		private void cercaMeglioSOL(List<Regione> parziale, int L, int n) {
			int sommaComuni = sommaComuni(parziale);
	
			if(sommaComuni>n)
				return;
	
			if(sommaComuni != 0 && sommaComuni <= n) {
				double param = calcolaParamSOL(parziale);
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
				this.cercaMeglioSOL(parziale, L+1, n);
				
				parziale.remove(reg.get(L));
				this.cercaMeglioSOL(parziale, L+1, n);
			}
	
		}

		
		private double calcolaParamSOL(List<Regione> parziale) {
			double s = 0;
			double nC = 0;
	
			for(Regione r:parziale) {
				s += r.getProdFotovoltaicoPerComune();
				nC += r.getComuniTot();
			}
	
			return s/nC;
		}

		
		public Map<Regione,String> EolFot(int n) {
	
			this.cercaMiglioreEOL(n);
			this.cercaMiglioreSOL(n);
			Map<Regione, String> mista = new HashMap<Regione, String>();
	
			for(Regione r:this.miglioreE) {
				if(r.getProdEolicoPerComune()<r.getProdFotovoltaicoPerComune()) {
					mista.put(r, "EOLICO");
				}
				else
					mista.put(r, "FOTOVOLTAICO");
			}
	
			for(Regione r:this.miglioreS) {
				if(r.getProdEolicoPerComune()<r.getProdFotovoltaicoPerComune())	{
					mista.put(r, "EOLICO");
				}
				else
					mista.put(r, "FOTOVOLTAICO");
				}
			return mista;
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
