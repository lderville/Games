package lionel.projet.games.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lionel.projet.games.bo.Utilisateur;
import lionel.projet.games.dal.DALException;
import lionel.projet.games.dal.UtilisateurDAO;


public class Utilisateurjdbcimpl implements UtilisateurDAO {
	
	private static final String SQL_INSERT_USER = "INSERT INTO UTILISATEURS VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";	
	private final static String SQL_SELECT_USER_BY_PSEUDO_AND_EMAIL = "SELECT * from UTILISATEURS where pseudo = ? OR email = ? ";
	private final static String SQL_SELECT_USER_BY_PSEUDO = "SELECT * from UTILISATEURS where pseudo = ?";
	private final static String SQL_SELECT_USER_BY_EMAIL = "SELECT * from UTILISATEURS where pseudo = ?";
	
	public Utilisateur insertUser(Utilisateur nouveauUser) throws DALException {

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (PreparedStatement) = ordre SQL
		int no_user = -1;
		PreparedStatement ordre = null;
		try {
			ordre = cnx.prepareStatement(SQL_INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			
			// Paramétrer l'objet de commande
			String pseudo = nouveauUser.getPseudo();
			String nom = nouveauUser.getNom();
			String prenom = nouveauUser.getPrenom();
			String email = nouveauUser.getEmail();
			String telephone = nouveauUser.getTelephone();
			String rue = nouveauUser.getRue();
			String code_postal = nouveauUser.getCodePostal();
			String ville = nouveauUser.getVille();
			String mot_de_passe = nouveauUser.getPassword();
			int jeton = 0;
			
			
			boolean administrateur = false;
			administrateur = nouveauUser.isAdministrateur();
			int value;

			if (administrateur == true) {

				value = 1;

			} else {

				value = 0;

			}

			ordre.setString(1, pseudo);
			ordre.setString(2, nom);
			ordre.setString(3, prenom);
			ordre.setString(4, email);
			ordre.setString(5, telephone);
			ordre.setString(6, rue);
			ordre.setString(7, code_postal);
			ordre.setString(8, ville);
			ordre.setString(9, mot_de_passe);
			ordre.setInt(10, jeton);
			ordre.setInt(11, value);
			

			// Execute l'ordre SQL
			ordre.executeUpdate();

			// Récupérer l'identifiant du client généré par la base de données
			ResultSet rs = ordre.getGeneratedKeys();
			if (rs.next()) {
				no_user = rs.getInt(1); // 1 : première colonne du résultat (qui n'en contient qu'une)
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return nouveauUser;

	}
	
	public List<Utilisateur> selectBypseudoAndMail(String login) throws DALException  {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_USER_BY_PSEUDO_AND_EMAIL);
			ordre.setString(1, login);
			ordre.setString(2, login);
			
			
			ResultSet rs = ordre.executeQuery();
			while(rs.next()) {
				
				int no_utilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mot_de_passe = rs.getString("mot_de_passe");
				int  jeton =  rs.getInt("jeton");
				Utilisateur u = new Utilisateur(no_utilisateur, pseudo, prenom, nom, email, telephone, rue, code_postal, ville, mot_de_passe, jeton, false);

						utilisateurs.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return utilisateurs;
	}
	
	
	
	
	

}
