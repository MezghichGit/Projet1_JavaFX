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

	private String marque;
	private String modele;
	private double prix;

	public Voiture(String marque, String modele, double prix) {
		this.marque = marque;
		this.modele = modele;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Voiture{" + "marque='" + marque + '\'' + ", modele='" + modele + '\'' + ", prix=" + prix + '}';
	}
}
