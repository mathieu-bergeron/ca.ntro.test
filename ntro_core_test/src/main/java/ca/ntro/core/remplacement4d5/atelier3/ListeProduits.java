package ca.ntro.core.remplacement4d5.atelier3;

import java.util.Scanner;


/**
 * Cette classe contient les attributs et les méthodes d'une liste de produits
 * 
 * @author Farida Ait-Ammar
 *
 */
public class ListeProduits {
	private Produit[] tabProduits;
	private int nbProduits;

   //Conxtructeur
	public ListeProduits(int maxProduits) {	
		//initialiser le tableau tabProduits  avec un nombre de cases égal à  maxProduits.
		// TO DO
	
		
		//Initialiser nbProduits à zéro (aucun produit lors de l'instanciation)
		// TO DO
		
	}

	// Retourne le nombre de produits dans le tableau
	public int taille() {
		// TO DO
		return 0;
	}

	// Retourne true si le tableau de produits est vide(nbProduits = 0), false sinon
	public boolean estVide() {
		// TO DO
		return false;
	}

	// Retourne true si le tableau de produits est plein (nbProduits égale la taille du tableau),
	// false sinon
	public boolean estPlein() {
		// TO DO
		return false;
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
	 * Ajoute le produit reçu en paramètre dans le tableau de produits. Elle
	 * retourne true si le produit est ajouté dans le tableau, false sinon.
	 */
	public boolean ajouter(Produit produitAjouter) {
		boolean insertionOk = false;
		if (!estPlein()) {
			// déposer produitAjouter dans la case d'indice nbProduits du tableau tabProduits
			// TO DO
			
			insertionOk = true;
			// Incrémenter le nombre de produits(nbProduits)
			// TO DO
			
		}
		return insertionOk;
	}

	/*
	 * Affiche le contenu du tableau des produits. .
	 */
	public void listerProduits() {
		if (!estVide()) {
			// parcourir le tableau tabProduits pour afficher ses éléments. Appeler toString() de la classe Produit
			//TO DO
		}
	}

	/*
	 * Retourne l'indice du produit dont le numéro est donné en paramètre dans le
	 * tableau des produits. Elle retourne -1 si le produit n'existe pas
	 */
	public int trouverProduit(int numeroAchercher) {

		return 0;
	}

	/*
	 * elle supprime le produit dont le numéro est donné en paramètre. Elle retourne
	 * true si le produit a été supprimé, false sinon.
	 */
	public boolean supprimer(int numeroAsupprimer) {

		return false;

	}

	// pour tester les méthode de cette classe
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		Produit prod1 = new Produit(100, "Chaise", 200);
		Produit prod2 = new Produit(200, "table", 500);
		Produit prod3 = new Produit(300, "Armoire", 1000);
		// Créer une liste de 10 éléments nommée liste. 
		// Appelez le constructeur de ListeProduits() avec le bon paramètre. 
		//TO DO
		
		//Ajouter prod1, prod2 et prod3 à cette liste. Appeler liste.ajouter() pour ajouter chaque produit
		//TO DO
		
		//Afficher les produits de cette liste. Appeler liste.listerProduits()
		//TO DO
		
			
		System.out.print("L'indice du produit de numéro 200: ");
		//Rechercher l'indice du produit de numéro 200 et l'afficher. 
		// Appeler liste.trouverProduit()
		//TO DO
		
		System.out.print("L'indice du produit de numéro 400 inéxistant: ");
		//Rechercher l'indice du produit de numéro 400 et l'afficher(doit donner -1). 
		// Appeler liste.trouverProduit()
		//TO DO
		
		System.out.println("Supprimer le produit de numéro 100: ");
		//Supprimer le produit de numéro 100, puis afficher la liste après suppression.
		// Appeler liste.supprimer() puis liste.listerProduits()
		//TO DO

	}

}
