package ca.ntro.core.remplacement4d5.atelier3;

import java.util.Scanner;

public class GestionEntrepot {
	public static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args) {
		// créer un entrepôt de 10 produits
		ListeProduits listeProd = new ListeProduits(100); // 100 produit maximum
		System.out.println("Initialiser l'entrepôt");
		initialiserEntrepot(listeProd);
		
		System.out.println("\nLes produits de l'entrepôt après initialisation");		
		listeProd.listerProduits();
		
		System.out.println("\nAjout de produits");
		//Appeler ajouterProduit() ici-bas
		//TO DO
		
		System.out.println("\nLes produits de l'entrepôt après ajout d'un produit");
		listeProd.listerProduits();
		
		//Appeler supprimerProduit() ici-bas
		//TO DO
				
		System.out.println("\nLes produits de l'entrepôt après suppression");
		listeProd.listerProduits();
		
		System.out.println("\nRecherche de produits");
		
		//Appeler rechercherPoduit() ic-bas
		//TO DO
		
	}

	/*
	 * Ajoute les 3 produits suivants dans l'entrepôt 
	 * 100: Table: 5000 
	 * 150: Chaise:60 
	 * 200: lit: 500
	 * 
	 */
	public static void initialiserEntrepot(ListeProduits listeProd) {
		//TO DO
		
	}

	public static void ajouterProduit(ListeProduits listeProd) {
	
		//TO DO
	}

	public static void supprimerProduit(ListeProduits listeProd) {
		//TO DO
	}

	public static void rechercherPoduit(ListeProduits listeProd) {
		//TO DO
	}
}
