package it.dennis.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import it.dennis.web.model.Utente;

public class UtenteDAO {
	private Connection connection;
	
	public UtenteDAO() {
		try {
			connection = ConnessioneDB.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Utente> getUtenti() {
		String query = "select * from utenti";
		ArrayList<Utente> utenti = new ArrayList();
		try(PreparedStatement statement = connection.prepareStatement(query)){
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Utente u = new Utente(rs.getInt("id"),rs.getString("nome"), rs.getString("password"));
				utenti.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utenti;
		
	}
	
	public Utente getUtente(int id) {
		Utente u = new Utente();
		String query = "select * from utenti where id=?";
		try(PreparedStatement st = connection.prepareStatement(query)){
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				u.setId(id);
				u.setName(rs.getString("nome"));
				u.setPassword(rs.getString("password"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
