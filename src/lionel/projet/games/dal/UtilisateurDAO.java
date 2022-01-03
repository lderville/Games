package lionel.projet.games.dal;


import lionel.projet.games.bo.Utilisateur;

public interface UtilisateurDAO {
	
	Utilisateur insertUser(Utilisateur nouveauUser) throws DALException;;
	
	
}
