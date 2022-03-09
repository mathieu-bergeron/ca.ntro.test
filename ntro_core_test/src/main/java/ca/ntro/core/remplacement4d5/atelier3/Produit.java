package ca.ntro.core.remplacement4d5.atelier3;

import java.util.Scanner;

/**
 * Cette classe contient les attributs et les méthodes d'un produit
 * 
 * @author Farida Ait-Ammar
 *
 */
public class Produit {
	// constantes de classe
	private static final int MIN_CAR_DESCRIPTION = 2;
	private static final int MAX_CAR_DESCRIPTION = 250;
	private static final int MAX_PRIX = 20000;
	private static final int MAX_NUMERO = 100000;
	private static final int MIN_NUMERO = 0;
	// attributs d'instance
	private int numero;
	private String description;
	private double prix;

	public Produit(int numero, String description, double prix) {
		setNumero(numero);
		setDescription(description);
		setPrix(prix);
	}

	public Produit() {
		this(0, "", 0);
	}

	private void setNumero(int numero) {
		if (numero > MIN_NUMERO && numero <= MAX_NUMERO) {
			this.numero = numero;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description.length() <= MAX_CAR_DESCRIPTION && description.length() >= MIN_CAR_DESCRIPTION) {
			this.description = description;
		}

	}

	public double getPrix() {
		return prix;
	}

	public int getNumero() {
		return numero;
	}

	public void setPrix(double prix) {
		if (prix > 0 && prix < MAX_PRIX) {
			this.prix = prix;
		}
	}

	public String toString() {
		return String.format("%3d %-15s %.2f$", numero, description, prix);
	}

	/*
	 * Demande à lire un numéro de produit à partir du clavier tant qu'il n'est pas
	 * valide. Elle affecte le numéro valide à l'attribut numero.
	 */
	public void lireNumero(Scanner clavier) {
		boolean valide = false;
		int numeroLu;

		do {
			System.out.print("Entrez le numéro du produit: ");
			numeroLu = clavier.nextInt();
			clavier.nextLine(); // on doit rajouter nextLin() pour lire le dernier saut de ligne caractère de votre entrée.

			if (numeroLu >= MIN_NUMERO && numeroLu <= MAX_NUMERO) {
				setNumero(numeroLu);
				valide = true;
			} else {
				System.out
						.println("Le numéro du produit doit être entre  " + MIN_NUMERO + " et " + MAX_NUMERO);
			}
		} while (!valide);
	}

	/*
	 * Demande à lire un prix de produit à partir du clavier tant qu'il n'est pas
	 * valide. Elle affecte le numéro valide à l'attribut prix.
	 */
	public void lirePrix(Scanner clavier) {
		// TO DO
	}

	/*
	 * Demande à lire une description de produit à partir du clavier tant qu'il
	 * n'est pas valide. Elle affecte la description valide à l'attribut
	 * description.
	 */
	public void lireDescription(Scanner clavier) {
		// TO DO
	}

	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		// créer un produit vide
		Produit prod2 = new Produit();
		// lire le numéro du produit
		prod2.lireNumero(clavier);
		// lire la description du produit.Appeler la méthode lirePrix(()
		// TO DO
		
		// lire le prix du produit. Appeler la méthode lireDescription()
		// TO DO
		
		// Afficher les informations du produit. Appeler la méthode toString()
		// TO DO

	}
}
