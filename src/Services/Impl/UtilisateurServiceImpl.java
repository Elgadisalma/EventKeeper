package Services.Impl;

import Models.Utilisateur;
import Services.UtilisateurService;
import java.util.ArrayList;
import java.util.List;


public class UtilisateurServiceImpl implements UtilisateurService {
    
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    @Override
    public void ajouterUtilisateur(Utilisateur utilisateur) 
    {
        utilisateurs.add(utilisateur); 
    }

    @Override
    public void modifierUtilisateur(int index, Utilisateur utilisateur) 
    {
        if (index >= 0 && index < utilisateurs.size()) 
        {
            utilisateurs.set(index, utilisateur); 
        } else {
            System.out.println("Utilisateur non trouvé");
        }
    }

    @Override
    public void supprimerUtilisateur(int index) 
    {
        if (index >= 0 && index < utilisateurs.size()) 
        {
            utilisateurs.remove(index); 
        } else {
            System.out.println("Utilisateur non trouvé");
        }
    }

    @Override
    public List<Utilisateur> getTousLesUtilisateurs() 
    {
        return utilisateurs;
    }

    @Override
    public void Register(Utilisateur utilisateur){
        utilisateurs.add(utilisateur);
    }
    
}
