package application;

public class Voiture {
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
