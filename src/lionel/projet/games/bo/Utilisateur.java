package lionel.projet.games.bo;

public class Utilisateur {
	
	private int no_utilisateur;
	private String pseudo;
	private String surname;
	private String name;
	private String mail;
	private String phone;
	private String street;
	private String postalCode;
	private String city;
	private String password;
	private int credit;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public boolean isAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	
	
	public Utilisateur(int no_utilisateur, String pseudo, String surname, String name, String mail, String phone,
			String street, String postalCode, String city, String password, int credit, boolean administrateur) {
	
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.surname = surname;
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.password = password;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	
	
	
	
	

}
