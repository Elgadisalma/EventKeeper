package Main;

import Models.Event;
import Models.Utilisateur;
import Services.InscriptionService;
import Services.EvenementService;
import Services.Impl.InscriptionServiceImpl;
import Services.Impl.EvenementServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TestInscriptionService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InscriptionService inscriptionService = new InscriptionServiceImpl();
        EvenementService evenementService = new EvenementServiceImpl();
        

        while (true) {
            System.out.println("\nMenu Gestion des Inscriptions:");
            System.out.println("1. Participer à un événement");
            System.out.println("2. Se désinscrire d'un événement");
            System.out.println("3. Afficher mes participations");
            System.out.println("0. Quitter");

            System.out.print("Choisissez une option: ");
            int choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    inscrireUtilisateur(inscriptionService, evenementService, scanner);
                    break;
                case 2:
                    desinscrireUtilisateur(inscriptionService, scanner);
                    break;
                // case 3:
                //     afficherEvenementsInscrits(inscriptionService, scanner);
                //     break;
                case 0:
                    MainTest.main(null); 
                return;
                default:
                    System.out.println("Erreur");
            }
        }
    }

    private static void inscrireUtilisateur(InscriptionService inscriptionService, EvenementService evenementService, Scanner scanner) {
        System.out.println("S'inscrire à un événement:");
        System.out.print("Nom de l'événement: ");
        String eventName = scanner.nextLine();
        System.out.print("Nom du participant: ");
        String participantName = scanner.nextLine();

        Event event = trouverEvenementParTitre(evenementService, eventName);
        if (event == null) {
            System.out.println("Erreur: Aucun evenement trouve avec ce titre");
            return;
        }

        Utilisateur participant = new Utilisateur(participantName, "email@example.com", "password"); 

        inscriptionService.inscrireUtilisateur(event, participant);
        System.out.println("Inscription ajoutée avec succès.");
    }

    private static void desinscrireUtilisateur(InscriptionService inscriptionService, Scanner scanner) {
        System.out.println("Se désinscrire d'un événement:");
        System.out.print("Nom de l'événement: ");
        String eventName = scanner.nextLine();
        System.out.print("Nom du participant: ");
        String participantName = scanner.nextLine();

        // Trouver l'événement par son titre
        Event event = trouverEvenementParTitre(evenementService, eventName);
        if (event == null) {
            System.out.println("Erreur: Aucun événement trouvé avec ce titre.");
            return;
        }

        // Créer l'objet Utilisateur
        Utilisateur participant = new Utilisateur(participantName, "email@example.com", "password"); // Email et mot de passe fictifs

        inscriptionService.desinscrireUtilisateur(event, participant);
        System.out.println("Désinscription effectuée avec succès.");
    }

    // private static void afficherEvenementsInscrits(InscriptionService inscriptionService, Scanner scanner) {
    //     System.out.println("Afficher les événements auxquels vous êtes inscrit:");
    //     System.out.print("Nom du participant: ");
    //     String participantName = scanner.nextLine();
    
    //     // Vérifiez si l'utilisateur est inscrit à des événements
    //     List<Event> evenements = inscriptionService.afficherEvenementsInscrits(new Utilisateur(participantName, "", ""));
    
    //     if (evenements.isEmpty()) {
    //         System.out.println("Erreur: Aucun événement trouvé pour le participant '" + participantName + "'.");
    //     } else {
    //         System.out.println("Événements auxquels '" + participantName + "' est inscrit:");
    //         for (Event event : evenements) {
    //             System.out.println("Événement: " + event.getTitre());
    //         }
    //     }
    // }
    

    private static Event trouverEvenementParTitre(EvenementService evenementService, String titre) {
        List<Event> evenements = evenementService.getTousLesEvenements();
        for (Event event : evenements) {
            if (event.getTitre().equalsIgnoreCase(titre)) {
                return event;
            }
        }
        return null;
    }
    
}
