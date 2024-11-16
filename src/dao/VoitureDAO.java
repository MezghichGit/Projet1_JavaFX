package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entities.Voiture;

public class VoitureDAO {
	public static Connection con = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;

	public static void initConnexion() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet1cursusjava", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Connexion réussi : " + con);
	}

	public static int addVoiture(Voiture v) throws SQLException // insert into
	{
		initConnexion();
		stmt = con.createStatement();
		int result = stmt.executeUpdate("insert into voiture(marque,modele,prix) values('" + v.getMarque() + "', '"
				+ v.getModele() + "','" + v.getPrix() + "')");
		return result;
	}

	public static List<Voiture> listVoitures() throws SQLException // select *
	{
		List<Voiture> lv = new ArrayList<>();
		initConnexion();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select id, marque,modele,prix from voiture");

		// Parcourir les résultats et les ajouter à la liste
		while (rs.next()) {
			int id = rs.getInt("id");
			String marque = rs.getString("marque");
			String modele = rs.getString("modele");
			double prix = rs.getDouble("prix");

			Voiture voiture = new Voiture(id,marque, modele, prix);
			lv.add(voiture);
			
		}
		return lv;
	}

}
