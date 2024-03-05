package magasin;

public class TestFacturationSystem {

	public static void main(String[] args) {
        Article article1 = new Article("Laptop", 1200.85);
        Article article2 = new Article("Smartphone", 800.987);
        Article article3 = new Article("Tablet", 600.3361);
        
        // Initialize stock and add articles to it
        Stock stock = new Stock();
        stock.addNouvArticle(article2, 32); 
        stock.addNouvArticle(article1, 50); 
        stock.addNouvArticle(article3, 15); 
        
        stock.sortStock();
        
        // Create a new facture with the existing stock
        Facture facture = new Facture(stock);
        
        facture.addLigne(20, "Laptop"); // Selling 2 laptops
        facture.addLigne(31, "Smartphone"); // Selling 3 smartphones
        facture.addLigne(10, "Tablet"); // Selling 1 tablet
        
        // Print the total amount of the facture
        double totalMontant = facture.getMontantTotal();
        System.out.println("Total Facture Montant: " + totalMontant);
        
        facture.removeLigne(2); // Remove the second line added
        double updatedTotalMontant = facture.getMontantTotal();
        System.out.println("Updated Total Facture Montant: " + updatedTotalMontant);

	}

}
