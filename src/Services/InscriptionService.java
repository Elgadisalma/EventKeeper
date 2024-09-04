package Services;

import Models.Event;
import Models.Utilisateur;

public interface InscriptionService {
	
    void inscrireUtilisateur(Event event, Utilisateur participant);
	void desinscrireUtilisateur(Event event,Utilisateur participant);
    void afficherParticipants(Event event, Utilisateur participant);
    void afficherEvenementsInscrits(Utilisateur participant);
	

}
