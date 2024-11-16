package dao;
import java.sql.*;
import java.util.List;

import entities.Voiture;

public class VoitureDAO {
	public static Connection con = null;
	public static Statement stmt = null;
	
	public static void initConnexion() 
	{
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet1cursusjava", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connexion réussi : " +con);
	}
	
	public static int addVoiture(Voiture v) throws SQLException // insert into
	{
		initConnexion();
		stmt = con.createStatement();
		int result = stmt.executeUpdate("insert into voiture(marque,modele,prix) values('"+v.getMarque()+"', '"+v.getModele()+"','"+v.getPrix()+"')");
		return result;
	}
	
	public List<Voiture> listVoiture() throws SQLException // select *
	{
		initConnexion();
		return null;
	}
	



}
