package ca.ntro.core.remplacement4d5.atelier3solution;


import java.util.Scanner;

public class GestionEntrepot {
	public static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args) {
		// créer un entrepôt de 100 produits
		ListeProduits listeProd = new ListeProduits(100); // 100 produit maximum
		System.out.println("Initialise l'entrepôt");
		//Appelez initialiser entrepot
		initialiserEntrepot(listeProd);
		System.out.println("\nLes produits de l'entrepôt");
		listeProd.listerProduits();
		System.out.println("\nAjout d'un produit");
		ajouterProduit(listeProd);
		System.out.println("\nLes produits de l'entrepôt");
		listeProd.listerProduits();
		System.out.println("\nSupprimer un produit");
		supprimerProduit(listeProd);
		System.out.println("Les produits de l'entrepôt");
		listeProd.listerProduits();
		System.out.println("\nRecherche de produits");
		rechercherPoduit(listeProd);
	}

	/*
	 * Ajoute les 3 produits suivants dans l'entrepôt 
	 * 100: Table: 5000 
	 * 150: Chaise:60 
	 * 200: lit: 500
	 * 
	 */
	public static void initialiserEntrepot(ListeProduits listeProd) {
		listeProd.ajouter(new Produit(100, "Table", 500));
		listeProd.ajouter(new Produit(150, "Chaise", 60));
		listeProd.ajouter(new Produit(200, "lit", 500));
	}

	public static void ajouterProduit(ListeProduits listeProd) {
		Produit prod = new Produit();
		prod.lireNumero(clavier);
		prod.lireDescription(clavier);
		prod.lirePrix(clavier);
		if (listeProd.ajouter(prod)) {
			System.out.println("Le produit a été ajouté");
		} else {
			System.out.println("Le produit n'a pas pu être ajouté");
		}

	}

	public static void supprimerProduit(ListeProduits listeProd) {
		int numero;
		System.out.print("Entrez le numéro du produit à supprimer: ");
		numero = clavier.nextInt();
		if (listeProd.supprimer(numero)) {
			System.out.println("Le produit a été supprimé");
		} else {
			System.out.println("Le produit est introuvable");
		}
	}

	public static void rechercherPoduit(ListeProduits listeProd) {
		int numero, indiceTrouve;
		Produit produit;
		System.out.print("Entrez le numéro du produit à rechercher: ");
		numero = clavier.nextInt();
		indiceTrouve = listeProd.trouverProduit(numero);
		if (indiceTrouve == -1) {
			System.out.print("Le produit est introuvale");
		} else {
			produit = listeProd.obtenirProduit(indiceTrouve);
			System.out.print("Voici le produit que vous cherchez:");
			System.out.println(produit.toString());
		}
	}
}
