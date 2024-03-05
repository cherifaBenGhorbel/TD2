package magasin;

import java.util.ArrayList;

public class Facture {
	private ArrayList<LigneFacture> lignes;
	private Stock stock;

	public Facture(Stock stock) {
		this.stock = stock;

		lignes = new ArrayList<LigneFacture>();
	}

	public boolean addLigne(int qt, String a) {
		if (!stock.verifArticle(a))
			return false;
		int Q = stock.getQt(a);
		if (Q <= 0 || Q < qt)
			return false;
		int id = lignes.size() + 1;
		lignes.add(new LigneFacture(id, qt, stock.getArticle(a)));
		stock.changeQt(a, -qt);
		return true;
	}

	public boolean removeLigne(int id) {
	    if (id < 1 || id > lignes.size())
	        return false;

	    LigneFacture ligneToRemove = lignes.get(id - 1);
	    stock.changeQt(ligneToRemove.getArticle().getNom(), ligneToRemove.getQt());
	    lignes.remove(id - 1);

	    // After removing a line, adjust the IDs of the subsequent lines.
	    for (int i = id - 1; i < lignes.size(); i++) {
	        lignes.get(i).setId(i + 1);
	    }
	    return true;
	}
	
    public double getMontantTotal() {
        double total = 0;
        for (LigneFacture ligne : lignes) {
            total += ligne.getMontantTotal();
        }
        return total;
    }
}
