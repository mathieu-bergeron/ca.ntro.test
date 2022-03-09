package ca.ntro.core.remplacement4d5.atelier3solution;


/**
 * Cette classe contient les attributs et les méthodes d'une liste de produits
 * 
 * @author Farida Ait-Ammar
 *
 */
public class ListeProduits {

	private Produit tabProduits[];
	private int nbProduits;

	public Produit[] getTabProduits() {
		return tabProduits;
	}

	public void setTabProduits(Produit[] tabProduits) {
		this.tabProduits = tabProduits;
	}

	public int getNbProduits() {
		return nbProduits;
	}

	public void setNbProduits(int nbProduits) {
		this.nbProduits = nbProduits;
	}

	
	public ListeProduits() {

	}
	
	public ListeProduits(int maxProduits) {
		tabProduits = new Produit[maxProduits];
		nbProduits = 0;
	}


	// Retourne le nombre de produits dans le tableau
	public int taille() {
		return nbProduits;
	}

	// Retourne true si le tableau de produits est vide, false sinon
	public boolean estVide() {
		return nbProduits == 0;
	}

	// Retourne true si le tableau de produits est plein, false sinon
	public boolean estPlein() {
		return nbProduits == tabProduits.length;
	}

	// retourne le produit dont l'indice est donné en paramètre.
	public Produit obtenirProduit(int indice) {
		Produit produit = null;
		if (indice >= 0 && indice < nbProduits) {
			produit = tabProduits[indice];
		}
		return produit;

	}

	/*
	 * Ajoute le produit reçu en paramêtre dans le tableau de produits. Elle
	 * retourne true si le produit est ajouté dans le tablaus, false sinon.
	 */
	public boolean ajouter(Produit produitAjouter) {
		boolean insertionOk = false;
		if (!estPlein()) {
			tabProduits[nbProduits] = produitAjouter;
			nbProduits++; // un produit de plus
			insertionOk = true;
		}
		return insertionOk;
	}

	/*
	 * Affiche le contenu du tableau des produits. .
	 */
	public void listerProduits() {
		if (!estVide()) {
			for (int i = 0; i < nbProduits; i++) {
				System.out.println(tabProduits[i].toString());
			}
		}

	}

	/*
	 * Retourne l'indice du produit dont le numéro est donné en paramètre dans le
	 * tableau des produits. Elle retourne -1 si le produit n'existe pas
	 */
	public int trouverProduit(int numeroAchercher) {
		int indice = -1;
		int pos = 0;
		boolean trouve = false;

		while (!trouve && pos < nbProduits) {
			if (tabProduits[pos].getNumero() == numeroAchercher) {
				trouve = true;
			} else {
				pos++;
			}
		}
		if (trouve) {
			indice = pos;
		}

		return indice;
	}

	/*
	 * elle supprime le produit dont le numéro est donné en paramêtre. Elle retourne
	 * true si le produit a été supprimé, false sinon.
	 */
	public boolean supprimer(int numeroAsupprimer) {
		boolean suppressionOk = false;
		int indice;
		if (!estVide()) {
			indice = trouverProduit(numeroAsupprimer);
			if (indice != -1) {
				// décaler le contenu des cases vers la gauche
				for (int i = indice + 1; i < nbProduits; i++) {
					tabProduits[i - 1] = tabProduits[i];
				}
				// un produit de moins
				nbProduits--;
				tabProduits[nbProduits] = null;
				suppressionOk = true;
			}

		}
		return suppressionOk;

	}

	// pour tester les méthode de cette classe
	public static void main(String[] args) {
		
		Produit prod1 = new Produit(100, "Chaise", 200);
		Produit prod2 = new Produit(200, "table", 500);
		Produit prod3 = new Produit(300, "Armoire", 1000);
		
		// Créer une liste de 10 éléments nommée liste.
		ListeProduits liste = new ListeProduits(10);
		
		//Ajouter prod1, prod2 et prod3 à cette liste. 
		liste.ajouter(prod1);
		liste.ajouter(prod2);
		liste.ajouter(prod3);
		
		//Afficher les produits de cette liste. 
		liste.listerProduits();
		
		System.out.print("L'indice du produit de numéro 200: ");
		//Rechercher l'indice du produit de numéro 200 et l'afficher.
		System.out.println(liste.trouverProduit(200));
		
		System.out.print("L'indice du produit de numéro 400 inexistant: ");
		//Rechercher l'indice du produit de numéro 400 et l'afficher(doit donner -1).
		System.out.println(liste.trouverProduit(400));
		
		System.out.println("Supprimer le produit de numéro 100:");
		//Supprimer le produit de numéro 100, puis afficher la liste après suppression.
		liste.supprimer(100);
		System.out.println("La liste après suppression de 100:");
		liste.listerProduits();
		

	}

}
