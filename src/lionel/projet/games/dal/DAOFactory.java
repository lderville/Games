package lionel.projet.games.dal;

import lionel.projet.games.dal.jdbc.Utilisateurjdbcimpl;

public class DAOFactory {
	
	/**
	 * Fournit une instance d'une classe
	 * se comportant comme un RepasDAO
	 * 
	 * @return Une instance
	 */
	public static UtilisateurDAO getUtilisateurDAO() {
		
		return new Utilisateurjdbcimpl();
	}
	

	


}
