package Main;

import java.util.Scanner;
import Models.Utilisateur;
import Services.UtilisateurService;
import Services.Impl.UtilisateurServiceImpl;
import Main.TestEventService;
import Main.TestInscriptionService;
import Main.TestAdminService;

public class MainTest {
    private static UtilisateurService utilisateurService = new UtilisateurServiceImpl(); // Déclaration globale

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Êtes-vous un admin ou un participant?");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("admin")) {
            handleAdmin(scanner);
        } else if (role.equalsIgnoreCase("participant")) {
        	registerParticipant(scanner);
        } else {
            System.out.println("Erreur: rôle non reconnu.");
        }

        scanner.close();
    }

    private static void handleAdmin(Scanner scanner) {
        while (true) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Gestion des événements");
            System.out.println("2. Gestion des utilisateurs");
            System.out.println("3. Afficher les détails des participations d'un événement");
            System.out.println("0. Quitter");

            System.out.print("Choisissez une option: ");
            int choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    TestEventService.main(null); 
                    break;
                case 2:
                    TestUtilisateurService.main(null); 
                    break;
                case 3:
                    TestAdminService.main(null); 
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Erreur: option non reconnue.");
            }
        }
    }



    private static void registerParticipant(Scanner scanner) {
        System.out.println("Enregistrement d'un nouvel utilisateur:");
        System.out.print("Nom: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        Utilisateur nouvelUtilisateur = new Utilisateur(name, email, password);
        utilisateurService.ajouterUtilisateur(nouvelUtilisateur);
        System.out.println("Enregistrement réussi. Vous pouvez maintenant accéder au menu participant.");
        showParticipantMenu(scanner); 
    }

    private static void showParticipantMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nMenu Participant:");
            System.out.println("1. Gestion des inscriptions");
            System.out.println("0. Quitter");

            System.out.print("Choisissez une option: ");
            int choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    TestInscriptionService.main(null); 
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Erreur: option non reconnue.");
            }
        }
    }
}
