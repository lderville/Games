package lionel.projet.games.bo;

public class Utilisateur {
	
	private int no_utilisateur;
	private String pseudo;
	private String prenom;
	private String nom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String password;
	private int jeton;
	private boolean administrateur;
	
	
	public int getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getJeton() {
		return jeton;
	}
	public void setJeton(int jeton) {
		this.jeton = jeton;
	}
	public boolean isAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	public Utilisateur(int no_utilisateur, String pseudo, String prenom, String nom, String email, String telephone,
			String rue, String codePostal, String ville, String password, int jeton, boolean administrateur) {
		this(pseudo, prenom, nom, email, telephone, rue, codePostal, ville, password, jeton, administrateur);
		this.no_utilisateur = no_utilisateur;
		
		
	}
	public Utilisateur(String pseudo, String prenom, String nom, String email, String telephone, String rue,
			String codePostal, String ville, String password, int jeton, boolean administrateur) {
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.password = password;
		this.jeton = jeton;
		this.administrateur = administrateur;
	}
	
	
	
	
	
	
	

}
