package Main;

import Models.Utilisateur;
import Services.Impl.UtilisateurServiceImpl;
import Services.UtilisateurService;
import java.util.List;
import java.util.Scanner;

public class TestUtilisateurService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UtilisateurService utilisateurService = new UtilisateurServiceImpl();

        while (true) {
            System.out.println("\nMenu Gestion des utilisateurs:");
            System.out.println("1. Ajouter un participant");
            System.out.println("2. Modifier un utilisateur");
            System.out.println("3. Supprimer un utilisateur");
            System.out.println("4. Afficher tous les utilisateurs");
            System.out.println("0. Quitter");

            System.out.print("Choisissez une option: ");
            int choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    ajouterUtilisateur(utilisateurService, scanner);
                    break;
                case 2:
                    modifierUtilisateur(utilisateurService, scanner);
                    break;
                case 3:
                    supprimerUtilisateur(utilisateurService, scanner);
                    break;
                case 4:
                    afficherTousLesUtilisateurs(utilisateurService);
                    break;
                case 0:
                    MainTest.main(null); 
                    return;
                default:
                    System.out.println("Option non reconnue.");
            }
        }
    }

    private static void ajouterUtilisateur(UtilisateurService utilisateurService, Scanner scanner) {
        System.out.println("Ajouter un nouvel utilisateur:");
        System.out.print("Username: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
      

        Utilisateur nouvelUtilisateur = new Utilisateur(name, email, password);
        utilisateurService.ajouterUtilisateur(nouvelUtilisateur);
        System.out.println("Utilisateur ajouté avec succès.");
    }

    private static void modifierUtilisateur(UtilisateurService utilisateurService, Scanner scanner) {
        System.out.println("Modifier un utilisateur existant:");
        afficherTousLesUtilisateurs(utilisateurService);

        System.out.print("Entrez le nom de l'utilisateur à modifier: ");
        String name = scanner.nextLine();

        int index = trouverUtilisateurParName(utilisateurService, name);
        if (index == 0) {
            System.out.println("Erreur: Aucun utilisateur trouvé avec ce nom.");
            return;
        }

        System.out.print("Nouveau nom: ");
        String nouveauName = scanner.nextLine();
        System.out.print("Nouvel email: ");
        String email = scanner.nextLine();
        System.out.print("Nouveau mot de passe: ");
        String password = scanner.nextLine();
       
        Utilisateur utilisateurModifie = new Utilisateur(nouveauName, email, password);
        utilisateurService.modifierUtilisateur(index, utilisateurModifie);
        System.out.println("Utilisateur modifié avec succès");
    }

    private static void supprimerUtilisateur(UtilisateurService utilisateurService, Scanner scanner) {
        System.out.println("Supprimer un utilisateur:");
        afficherTousLesUtilisateurs(utilisateurService);

        System.out.print("Entrez le nom de l'utilisateur à supprimer: ");
        String name = scanner.nextLine();

        int index = trouverUtilisateurParName(utilisateurService, name);
        if (index == 0) {
            System.out.println("Erreur: Aucun utilisateur trouvé avec ce nom");
            return;
        }

        utilisateurService.supprimerUtilisateur(index);
        System.out.println("Utilisateur supprimé avec succès.");
    }

    private static void afficherTousLesUtilisateurs(UtilisateurService utilisateurService) {
        List<Utilisateur> utilisateurs = utilisateurService.getTousLesUtilisateurs();
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur disponible.");
        } else {
            System.out.println("Liste des utilisateurs :");
            for (Utilisateur utilisateur : utilisateurs) {
                System.out.println(utilisateur.getName() + " - " + utilisateur.getEmail());
            }
        }
    }

    private static int trouverUtilisateurParName(UtilisateurService utilisateurService, String name) {
        List<Utilisateur> utilisateurs = utilisateurService.getTousLesUtilisateurs();
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return 0;
    }
}
