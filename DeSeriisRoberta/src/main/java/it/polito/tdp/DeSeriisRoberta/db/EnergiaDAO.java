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
				result.add(new Regione(res.getString("regione"), res.getDouble("produzTotNEElettrica_GWh"), 
						res.getDouble("prodTotNEElettrica_FOTOVOLTAICO_GWh"),  res.getDouble("prodTotNEElettrica_EOLICO_GWh"),
						res.getDouble("potenzaEfficienteLorda%FER"), res.getDouble("potenzaEfficienteLordaEOLICO_MW"), 
						res.getDouble("potenzaEfficienteLorda_SOLARE_MW"), res.getDouble("potenzaEfficienteLordaTotale_MW"),
						res.getInt("numImpianti_EOLICI"), res.getInt("numImpianti _SOLARI"), 
						res.getInt("FamiglieAllacciate"),res.getInt("SuperficieCentriAbitati_km^2"), 
						res.getInt("popolazioneResidenteMedia"),res.getInt("consumiFinaliLordiEnergia_GWh"),
						res.getDouble("consumiCopertiDaImpiantiEol"),res.getDouble("consumiCopertiDaimpiantiSol"),
						res.getString("statoRegione"),res.getInt("numeroComuniConMenoDi5000Ab"), res.getInt("numeroComuniTot")));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return result;
	}
}
	
