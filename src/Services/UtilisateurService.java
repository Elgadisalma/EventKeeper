package Services;

import Models.Utilisateur;
import java.util.List;

	public interface UtilisateurService 
	{

			void ajouterUtilisateur(Utilisateur utilisateur);
			
			void modifierUtilisateur(int index, Utilisateur utilisateur);

			void supprimerUtilisateur(int index);

			List<Utilisateur> getTousLesUtilisateurs();

	}
