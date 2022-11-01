package it.polito.tdp.DeSeriisRoberta.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.DeSeriisRoberta.model.Regione;

public class EnergiaDAO {
	
	public List<Regione> getAllRegioni(){
		String sql = "SELECT * FROM dati_regione ";
		List<Regione> result = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new Regione(res.getString("regione"), res.getDouble("produzTotNEElettrica"), 
						res.getDouble("prodTotNEElettrica_FOTOVOLTAICO"),  res.getDouble("prodTotNEElettrica_EOLICO"),
						res.getDouble("potenzaEfficienteLorda%FER"), res.getDouble("potenzaEfficienteLordaEOLICO"), 
						res.getDouble("potenzaEfficienteLorda_FOTOVOLTAICO"), res.getDouble("potenzaEfficienteLordaTotale"), 
						res.getInt("FamiglieAllacciate"),res.getInt("SuperficieCentriAbitati"), 
						res.getInt("popolazioneResidenteMedia"),res.getInt("consumiFinaliLordiEnergia"),
						res.getDouble("consumiCopertiDaImpiantiEol"),res.getDouble("consumiCopertiDaimpiantiSol"),
						res.getString("statoRegione"),res.getInt("numeroComuniCon5000"), res.getInt("numeroComuniTot")));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return result;
	}
}
	
