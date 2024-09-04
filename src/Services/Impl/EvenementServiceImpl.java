package Services.Impl;

import Models.Event;
import Services.EvenementService;

import java.util.ArrayList;
import java.util.List;

public class EvenementServiceImpl implements EvenementService {
    private List<Event> evenements = new ArrayList<>();

    @Override
    public void ajouterEvenement(Event evenement) {
        evenements.add(evenement);
    }

    @Override
    public void modifierEvenement(int index, Event evenement) {
        if (index >= 0 && index < evenements.size()) {
            evenements.set(index, evenement);
        } else {
            System.out.println("not found");
        }
    }

    @Override
    public void supprimerEvenement(int index) {
        if (index >= 0 && index < evenements.size()) {
            evenements.remove(index);
        } else {
            System.out.println("not found");
        }
    }

    @Override
    public List<Event> rechercherEvenements(String search) {
        List<Event> resultats = new ArrayList<>();
        for (Event e : evenements) {
            if (e.getTitre().contains(search) || e.getLieu().contains(search) || e.getType().contains(search)) {
                resultats.add(e);
            }
        }
        return resultats;
    }

    @Override
    public List<Event> getTousLesEvenements() {
        return evenements;
    }
    
}