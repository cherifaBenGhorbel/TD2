package magasin;

public class Article {
	private String nom;
	private double pu;

	public Article(String n, double p) {
		this.nom = n;
		this.pu = p;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPU() {
		return pu;
	}

	public void setPU(double pU) {
		pu = pU;
	}

	@Override
	public String toString() {
		return ("nom =" + nom + "prix unitaire = " + pu);
	}

}