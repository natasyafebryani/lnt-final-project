package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import database.DatabaseConnector;
import gui.Insert;
import model.Menu;

public class MenuDAO {
	
	private Connection connection;

	public MenuDAO() {
		connection = DatabaseConnector.makeConnection();
	}
	
	public void insert(Menu menu) {
		
		try {
			Statement stmt = connection.createStatement();
			String query = String.format("INSERT INTO Menu VALUES ( '%s' , '%s' , %d , %d)", menu.getKode(), menu.getNama(), menu.getHarga(), menu.getStok());
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Vector<Vector<String>> getMenu() {
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		
		try {
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Menu";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Vector<String> subdata = new Vector<String>();
				subdata.add(rs.getString(1));
				subdata.add(rs.getString(2));
				subdata.add(rs.getString(3));
				subdata.add(rs.getString(4));
				
				data.add(subdata);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public void update(Menu menu) {
		
		try {
			Statement stmt = connection.createStatement();
			
			String query = String.format("UPDATE Menu SET nama = '%s', harga = %d, stok = %d WHERE kode = '%s' ", menu.getNama(), menu.getHarga(), menu.getStok(), menu.getKode());
			
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(String kode) {
		
		try {
			Statement stmt = connection.createStatement();
			String query = "DELETE FROM Menu WHERE kode = '"+kode+"'";
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


}
