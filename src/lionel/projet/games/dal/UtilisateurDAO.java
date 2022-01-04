package lionel.projet.games.dal;


import java.util.List;

import lionel.projet.games.bo.Utilisateur;

public interface UtilisateurDAO {
	
	Utilisateur insertUser(Utilisateur nouveauUser) throws DALException;;
	public List<Utilisateur> selectBypseudoAndMail(String login) throws DALException ;
	
}
