package Main;

import Models.Event;
import Services.EvenementService;
import Services.Impl.EvenementServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TestEventService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EvenementService evenementService = new EvenementServiceImpl();

        while (true) {
            System.out.println("\nMenu Gestion des Événements:");
            System.out.println("1. Ajouter un événement");
            System.out.println("2. Modifier un événement");
            System.out.println("3. Supprimer un événement");
            System.out.println("4. Afficher tous les événements");
            System.out.println("5. Rechercher un événement");
            System.out.println("0. Quitter");

            System.out.print("Choisissez une option: ");
            int choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    ajouterEvenement(evenementService, scanner);
                    break;
                case 2:
                    modifierEvenement(evenementService, scanner);
                    break;
                case 3:
                    supprimerEvenement(evenementService, scanner);
                    break;
                case 4:
                    afficherTousLesEvenements(evenementService);
                    break;
                case 5:
                    rechercherEvenements(evenementService, scanner);
                    break;
                case 0:
                	MainTest.main(null);
                    return;
                default:
                    System.out.println("Option non reconnue.");
            }
        }
    }

    private static void ajouterEvenement(EvenementService evenementService, Scanner scanner) {
        System.out.println("Ajouter un nouvel événement:");
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Date de début (YYYY-MM-DD): ");
        String dateDebut = scanner.nextLine();
        System.out.print("Date de fin (YYYY-MM-DD): ");
        String dateFin = scanner.nextLine();
        System.out.print("Lieu: ");
        String lieu = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();

        Event nouvelEvent = new Event(titre, dateDebut, dateFin, lieu, type);
        evenementService.ajouterEvenement(nouvelEvent);
        System.out.println("Événement ajouté avec succès.");
    }

    private static void modifierEvenement(EvenementService evenementService, Scanner scanner) {
        System.out.println("Modifier un événement existant:");
        afficherTousLesEvenements(evenementService);

        System.out.print("Entrez le titre de l'événement à modifier: ");
        String titre = scanner.nextLine();

        int index = trouverEvenementParTitre(evenementService, titre);
        if (index == 0) {
            System.out.println("Erreur: Aucun événement trouvé avec ce titre.");
            return;
        }

        System.out.print("Nouveau titre: ");
        String nouveauTitre = scanner.nextLine();
        System.out.print("Nouvelle date de début (YYYY-MM-DD): ");
        String dateDebut = scanner.nextLine();
        System.out.print("Nouvelle date de fin (YYYY-MM-DD): ");
        String dateFin = scanner.nextLine();
        System.out.print("Nouveau lieu: ");
        String lieu = scanner.nextLine();
        System.out.print("Nouveau type: ");
        String type = scanner.nextLine();

        Event eventModifie = new Event(nouveauTitre, dateDebut, dateFin, lieu, type);
        evenementService.modifierEvenement(index, eventModifie);
        System.out.println("Événement modifié avec succès.");
    }

    private static void supprimerEvenement(EvenementService evenementService, Scanner scanner) {
        System.out.println("Supprimer un événement:");
        afficherTousLesEvenements(evenementService);

        System.out.print("Entrez le titre de l'événement à supprimer: ");
        String titre = scanner.nextLine();

        int index = trouverEvenementParTitre(evenementService, titre);
        if (index == 0) {
            System.out.println("Erreur: Aucun événement trouvé avec ce titre.");
            return;
        }

        evenementService.supprimerEvenement(index);
        System.out.println("Événement supprimé avec succès.");
    }

    private static void afficherTousLesEvenements(EvenementService evenementService) {
        List<Event> evenements = evenementService.getTousLesEvenements();
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement disponible.");
        } else {
            System.out.println("Liste des événements :");
            for (Event event : evenements) {
                System.out.println(event.getTitre() + " à " + event.getLieu() +
                        " du " + event.getDateDebut() + " au " + event.getDateFin());
            }
        }
    }

    private static void rechercherEvenements(EvenementService evenementService, Scanner scanner) {
        System.out.println("Rechercher un événement:");
        System.out.print("Entrez un mot-clé: ");
        String search = scanner.nextLine();

        List<Event> resultats = evenementService.rechercherEvenements(search);
        if (resultats.isEmpty()) {
            System.out.println("Aucun résultat trouvé pour la recherche '" + search + "'.");
        } else {
            System.out.println("Résultats de la recherche :");
            for (Event event : resultats) {
                System.out.println(event.getTitre() + " à " + event.getLieu() +
                        " du " + event.getDateDebut() + " au " + event.getDateFin());
            }
        }
    }

    private static int trouverEvenementParTitre(EvenementService evenementService, String titre) {
        List<Event> evenements = evenementService.getTousLesEvenements();
        for (int i = 0; i < evenements.size(); i++) {
            if (evenements.get(i).getTitre().equalsIgnoreCase(titre)) {
                return i;
            }
        }
        return 0;
    }
}

