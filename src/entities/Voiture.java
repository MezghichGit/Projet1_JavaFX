package entities;

public class Voiture {
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String marque;
	private String modele;
	private double prix;

	public Voiture(String marque, String modele, double prix) {
		this.marque = marque;
		this.modele = modele;
		this.prix = prix;
	}

	public Voiture(int id, String marque, String modele, double prix) {
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return "Voiture{" + "marque='" + marque + '\'' + ", modele='" + modele + '\'' + ", prix=" + prix + '}';
	}
}
