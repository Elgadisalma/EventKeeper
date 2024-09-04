package Services.Impl;

import Models.Event;
import Models.Inscription;
import Models.Utilisateur;
import Services.InscriptionService;

import java.util.ArrayList;
import java.util.List;

public class InscriptionServiceImpl implements InscriptionService {
    private List<Inscription> inscriptions = new ArrayList<>();

    @Override
    public void inscrireUtilisateur(Event event, Utilisateur participant) {
        inscriptions.add(new Inscription(event, participant));
    }

    @Override
    public void desinscrireUtilisateur(Event event, Utilisateur participant) {
                for (int i = 0; i < inscriptions.size(); i++) {
            Inscription inscription = inscriptions.get(i);
            if (inscription.getEvenement().equals(event) && inscription.getParticipant().equals(participant)) {
                inscriptions.remove(i);
                break; 
            }
        }
    }

    @Override
    public List<Utilisateur> afficherParticipants(Event event) {
        List<Utilisateur> participants = new ArrayList<>();
        for (Inscription inscription : inscriptions) {
            if (inscription.getEvenement().equals(event)) {
                participants.add(inscription.getParticipant());
            }
        }
        return participants;
    }

    @Override
    public List<Event> afficherEvenementsInscrits(Utilisateur participant) {
        List<Event> evenements = new ArrayList<>();
        for (Inscription inscription : inscriptions) {
            if (inscription.getParticipant().equals(participant)) {
                evenements.add(inscription.getEvenement());
            }
        }
        return evenements;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }
}
