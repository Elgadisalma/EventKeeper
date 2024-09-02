package Main;


import Models.Event;
import Services.EvenementService;
import Services.Impl.EvenementServiceImpl;

import java.util.List;


public class TestEventService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 EvenementService evenementService = new EvenementServiceImpl();

	       
	        Event event1 = new Event("Conférence","2024-09-01","2024-09-01" ,"Paris", "Conférence");
	        Event event2 = new Event("Atelier","2024-09-01","2024-09-01", "Lyon", "Atelier");
	        Event event3 = new Event("Réunion","2024-09-01","2024-09-01", "Marseille", "Réunion");

	        
	        evenementService.ajouterEvenement(event1);
	        evenementService.ajouterEvenement(event2);
	        evenementService.ajouterEvenement(event3);

	        
	        System.out.println("Liste des événements :");
	        for (Event event : evenementService.getTousLesEvenements()) {
	            System.out.println(event.getTitre() + " à " + event.getLieu() + " le " + event.getDateDebut() + event.getDateFin());
	        }

	        
	        Event eventModifie = new Event("Conférence","2024-09-01","2024-09-04" ,"Paris", "Conférence");
	        evenementService.modifierEvenement(0, eventModifie);

	        
	        System.out.println("\nÉvénement modifié :");
	        System.out.println(evenementService.getTousLesEvenements().get(0).getTitre());
	        
	        
	        System.out.println("\n Evenement contenant 'Atelier' :");
	        List<Event> rechercheResultats = evenementService.rechercherEvenements("Spring");
	        for (Event event : rechercheResultats) {
	            System.out.println(event.getTitre() + "à" + event.getLieu() + "le" + event.getDateDebut());
	        }

	        /*

	        evenementService.supprimerEvenement(2);

	        
	        System.out.println("\nListe des événements après suppression :");
	        for (Event event : evenementService.getTousLesEvenements()) {
	            System.out.println(event.getTitre() + " à " + event.getLieu() + " le " + event.getDate());
	        }
	        */
	        
	}

}
