package Services;

import Models.Event;
import Models.Utilisateur;
import java.util.List;

public interface EvenementService {
    void ajouterEvenement(Event evenement);
    void modifierEvenement(int index, Event evenement);
    void supprimerEvenement(int index);
    List<Event> rechercherEvenements(String search);
    void afficherEvenementsInscrits(Utilisateur participant, Event event);

    List<Event> getTousLesEvenements();
}