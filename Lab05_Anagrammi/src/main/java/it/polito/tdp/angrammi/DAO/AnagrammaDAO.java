package it.polito.tdp.angrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AnagrammaDAO {
	
	public boolean isCorrect (String anagramma) {
		
		final String sql = "SELECT nome FROM parola WHERE nome=?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();

			//ATTENZIONE CON DUE RETURN, 2 CONNECTION.CLOSE
			if (rs.next()) { //c'è un valore nel result set ritorna true
				conn.close();
				return true;
			}
			else {
				conn.close();
				return false;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
