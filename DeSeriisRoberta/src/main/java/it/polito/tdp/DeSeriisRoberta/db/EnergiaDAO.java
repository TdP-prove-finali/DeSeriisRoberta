package it.polito.tdp.DeSeriisRoberta.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.DeSeriisRoberta.model.Regione;
import it.polito.tdp.DeSeriisRoberta.model.RendimentoRegione;

public class EnergiaDAO {
	
	public List<Regione> getAllRegioni(){
		String sql = "SELECT * FROM consumi_regione";
		List<Regione> result = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new Regione(res.getString("regione"), res.getDouble("produzTotNEElettrica_GWh"), res.getDouble("prodTotNEElettrica_FOTOVOLTAICO_GWh"),  res.getDouble("prodTotNEElettrica_EOLICO_GWh"),
						res.getDouble("potenzaEfficienteLorda%FER"), res.getDouble("potenzaEfficienteLordaEOLICO_MW"), res.getDouble("potenzaEfficienteLorda_SOLARE_MW"), res.getDouble("potenzaEfficienteLordaTotale_MW"),
						res.getInt("numImpianti_EOLICI"), res.getInt("numImpianti _SOLARI"), res.getInt("FamiglieAllacciate"),
						res.getInt("SuperficieCentriAbitati_km^2"), res.getInt("popolazioneResidenteMedia"),res.getInt("consumiFinaliLordiEnergia_GWh"),
						res.getDouble("consumiCopertiDaImpiantiEol"),res.getDouble("consumiCopertiDaimpiantiSol"),res.getString("statoRegione")));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return result;
	}
	
	//salva dati utili riferiti a tutte le regioni italiane
	public List<RendimentoRegione> getRegioni(){
		String sql = "SELECT DISTINCT regione, "
				+ "prodTotNEElettrica_FOTOVOLTAICO_GWh AS prodFotovoltaico, "
				+ "prodTotNEElettrica_EOLICO_GWh AS prodEolico, "
				+ "potenzaEfficienteLordaEOLICO_MW AS potenzaEolico, "
				+ "potenzaEfficienteLorda_SOLARE_MW AS potenzaFotovoltaico, "
				+ "statoRegione "
				+ "FROM dati_regione";
		List<RendimentoRegione> result = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new RendimentoRegione(res.getString("regione"), 
						res.getDouble("prodTotNEElettrica_FOTOVOLTAICO_GWh"), res.getDouble("prodTotNEElettrica_EOLICO_GWh"), 
						res.getDouble("potenzaEfficienteLordaEOLICO_MW"), res.getDouble("potenzaEfficienteLorda_SOLARE_MW"), res.getString("statoRegione")));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return result;
	}
	
	/*//salva dati utili riferiti alle regioni più/meno sviluppate e in transizione
	public List<RendimentoRegione> getTipoRegioni(String tipoRegione){
		String sql = "SELECT DISTINCT regione, "
				+ "prodTotNEElettrica_FOTOVOLTAICO_GWh AS prodFotovoltaico, "
				+ "prodTotNEElettrica_EOLICO_GWh AS prodEolico, "
				+ "potenzaEfficienteLordaEOLICO_MW AS potenzaEolico, "
				+ "potenzaEfficienteLorda_SOLARE_MW AS potenzaFotovoltaico "
				+ "FROM dati_regione "
				+ "WHERE statoRegione=? ";
		List<RendimentoRegione> result = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new RendimentoRegione(res.getString("regione"), 
						res.getDouble("prodTotNEElettrica_FOTOVOLTAICO_GWh"), res.getDouble("prodTotNEElettrica_EOLICO_GWh"), 
						res.getDouble("potenzaEfficienteLordaEOLICO_MW"), res.getDouble("potenzaEfficienteLorda_SOLARE_MW"), res.getString("statoRegione")));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return result;
	}
	*/
	
}
