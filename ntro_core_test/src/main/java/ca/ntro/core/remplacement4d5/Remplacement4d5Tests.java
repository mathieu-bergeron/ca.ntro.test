package ca.ntro.core.remplacement4d5;


import org.junit.Test;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.object_graph.ObjectGraph;
import ca.ntro.core.remplacement4d5.atelier3solution.ListeProduits;
import ca.ntro.core.remplacement4d5.atelier3solution.Produit;
import ca.ntro.core.tests.NtroTests;

public class Remplacement4d5Tests extends NtroTests {

	private Produit prod1 = new Produit(100, "Chaise", 200);
	private Produit prod2 = new Produit(200, "table", 500);
    private Produit prod3 = new Produit(300, "Armoire", 1000);

	@Test
	public void remplacement4d5Produits() {


		ObjectGraph graph = Ntro.reflection().graphFromObject(prod1, "Produit01");
		graph.write(Ntro.graphWriter());

		graph = Ntro.reflection().graphFromObject(prod2, "Produit02");
		graph.write(Ntro.graphWriter());

		graph = Ntro.reflection().graphFromObject(prod3, "Produit03");
		graph.write(Ntro.graphWriter());

	}
		

	@Test
	public void remplacement4d5ListeProduits() {
		
		ListeProduits liste = new ListeProduits(10);

		ObjectGraph graph = Ntro.reflection().graphFromObject(liste, "ListeProduits00");
		graph.write(Ntro.graphWriter());
		
		liste.ajouter(prod1);

		graph = Ntro.reflection().graphFromObject(liste, "ListeProduits01");
		graph.write(Ntro.graphWriter());

		liste.ajouter(prod2);

		graph = Ntro.reflection().graphFromObject(liste, "ListeProduits02");
		graph.write(Ntro.graphWriter());

		liste.ajouter(prod3);

		graph = Ntro.reflection().graphFromObject(liste, "ListeProduits03");
		graph.write(Ntro.graphWriter());

		liste.supprimer(100);

		graph = Ntro.reflection().graphFromObject(liste, "ListeProduits04");
		graph.write(Ntro.graphWriter());

	}
}

