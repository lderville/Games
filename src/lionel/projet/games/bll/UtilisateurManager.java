package lionel.projet.games.bll;






import lionel.projet.games.bo.Utilisateur;
import lionel.projet.games.dal.DALException;
import lionel.projet.games.dal.DAOFactory;
import lionel.projet.games.dal.UtilisateurDAO;

public class UtilisateurManager {
	
private static UtilisateurManager instance;
	
	private static UtilisateurDAO dao;
	
	private UtilisateurManager() {
		dao = DAOFactory.getUtilisateurDAO();
	};

	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	public Utilisateur ajouterUtilisateur(Utilisateur nouveauUser) throws BLLException {
		
		BLLException ex = new BLLException();
		
		validationPseudo(nouveauUser.getPseudo(), ex);
		validationNom(nouveauUser.getPrenom(), ex);
		validationPrenom(nouveauUser.getNom(), ex);
		validationTelephone(nouveauUser.getTelephone(), ex);
		validationEmail(nouveauUser.getEmail(), ex);
		validationVille(nouveauUser.getVille(), ex);
		validationCode_postal(nouveauUser.getCodePostal(), ex);
		
		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			Utilisateur utilisateur = dao.insertUser(nouveauUser);
			
			return utilisateur;
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}
		
	}

	private void validationCode_postal(String code_postal, BLLException ex) {
		if(code_postal == null || code_postal.isEmpty()|| code_postal.length() > 10) {
			ex.ajouterErreur(new ParameterException("Le nom est obligatoire et doit avoir une longueur comprise entre 1 et 10"));
		}	
		
	}

	private void validationVille(String ville, BLLException ex) {
		if(ville == null || ville.isEmpty()|| ville.length() > 50) {
			ex.ajouterErreur(new ParameterException("Le nom est obligatoire et doit avoir une longueur comprise entre 1 et 50"));
		}
		
	}

	private void validationEmail(String email, BLLException ex) {
		if(email == null || email.isEmpty()|| email.length() > 50) {
			ex.ajouterErreur(new ParameterException("L'email est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}	
		
	}

	private void validationTelephone(String telephone, BLLException ex) {
		if(telephone == null || telephone.isEmpty()|| telephone.length() > 15) {
			ex.ajouterErreur(new ParameterException("Le telephone est obligatoire et doit avoir une longueur comprise entre 1 et 15"));
		}	
		
	}

	private void validationPrenom(String nom, BLLException ex) {
		if(nom == null || nom.isEmpty()|| nom.length() > 30) {
			ex.ajouterErreur(new ParameterException("Le nom est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}
		
	}

	private void validationNom(String prenom, BLLException ex) {
		if(prenom == null || prenom.isEmpty()|| prenom.length() > 30) {
			ex.ajouterErreur(new ParameterException("Le prenom est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}
		
	}

	private void validationPseudo(String pseudo, BLLException ex) {
		if(pseudo == null || pseudo.isEmpty()|| pseudo.length() > 30) {
			ex.ajouterErreur(new ParameterException("Le pseudo est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		
	}


	
	
	
	}
}
