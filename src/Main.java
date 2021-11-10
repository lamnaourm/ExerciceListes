import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.LinkController;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Client> clients = new LinkedList<>();
		int choix = 0;
		
		do {
			System.out.println("---------- Menu Generale ---------");
			System.out.println("1- Ajouter Client\r\n" + 
					"2- Afficher tous les clients\r\n" + 
					"3- Supprimer Client par son nom\r\n" + 
					"4- Rechercher un client par son nom\r\n" + 
					"5- Modifier l’adresse d’un client par son nom.\r\n" + 
					"6- Quitter le programme.\r\n" + 
					"");
			System.out.print("Taper votre choix : ");
			choix = Integer.parseInt(sc.nextLine());
			
			switch (choix) {
			case 1:
				System.out.println("-- Ajout de nouveau client --");
				System.out.print("Code : ");
				int code = Integer.parseInt(sc.nextLine());
				System.out.print("Nom : ");
				String nom = sc.nextLine();
				System.out.print("Adresse : ");
				String adresse = sc.nextLine();
				
				Client c = new Client(code,nom,adresse);
				clients.add(c);
				break;
			case 2:
				System.out.println("-- Liste des clients --");
				if(clients.isEmpty())
					System.err.println("Pas de clients dans la liste");
				else 
					for(Client cl : clients)
						System.out.println(cl);
				break;
			case 3:
				System.out.println("-- Suppression d'un client par son nom --");
				boolean trouve = false;			
				if(clients.isEmpty())
					System.err.println("Pas de clients dans la liste");
				else {
					System.out.print("Le nom de client a supprimer : ");
					String supNom = sc.nextLine();
					for(int i=0;i<clients.size();i++)
						if(clients.get(i).getNom().equals(supNom)) {
							trouve = true;
							clients.remove(i);
							System.out.println("Client supprime avec succes");
						}
					
					if(!trouve) {
						System.err.println("Pas de clients avec le nom " + supNom);
					}
				}
				break;
			case 4:
				System.out.println("-- Rechercher d'un client par son nom --");
				trouve = false;			
				if(clients.isEmpty())
					System.err.println("Pas de clients dans la liste");
				else {
					System.out.print("Le nom de client a rechercher : ");
					String rechNom = sc.nextLine();
					for(int i=0;i<clients.size();i++)
						if(clients.get(i).getNom().equals(rechNom)) {
							trouve = true;
							System.out.println(clients.get(i));
						}
					
					if(!trouve) {
						System.err.println("Pas de clients avec le nom " + rechNom);
					}
				}
				break;
			case 5:
				System.out.println("-- Modification d'un client par son nom --");
				trouve = false;			
				if(clients.isEmpty())
					System.err.println("Pas de clients dans la liste");
				else {
					System.out.print("Le nom de client a modifier : ");
					String rechNom = sc.nextLine();
					for(int i=0;i<clients.size();i++)
						if(clients.get(i).getNom().equals(rechNom)) {
							trouve = true;
							System.out.println("Donner la nouvelle l'adresse : ");
							String ad = sc.nextLine();
							clients.get(i).setAdresse(ad);
						}
					
					if(!trouve) {
						System.err.println("Pas de clients avec le nom " + rechNom);
					}
				}
				break;
			case 6:break;
			default:
				break;
			}
			
			
		}while(choix!=6);

	}

}
