package Models;

public class Inscription {
    private Utilisateur participant;
    private Event evenement;


    public Inscription(Utilisateur participant, Event evenement) {
        this.participant = participant;
        this.evenement = evenement;
    }


    public Utilisateur getParticipant() {
        return participant;
    }

    public void setParticipant(Utilisateur participant) {
        this.participant = participant;
    }

    public Event getEvenement() {
        return evenement;
    }

    public void setEvenement(Event evenement) {
        this.evenement = evenement;
    }
}
