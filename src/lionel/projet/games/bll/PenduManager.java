package lionel.projet.games.bll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;



public class PenduManager {
	
	
	private static PenduManager instance;


	public static PenduManager getInstance() {
		if (instance == null) {
			instance = new PenduManager();
		}
		return instance;
	}
	
	public String tirageAuHasard() {
		String random_word = null ;
 //FileInputStream dictionnaire = new FileInputStream("/games/dico/dictionnaire.txt");

FileInputStream inputdico = null ;
URL resource = this.getClass().getClassLoader().getResource("dictionnaire.txt");
File file = null;
try {
	file = new File(resource.toURI());
} catch (URISyntaxException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	 inputdico = new FileInputStream(file);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


Scanner scanner = new Scanner(inputdico);

ArrayList<String> ar = new ArrayList<>();

while(scanner.hasNextLine()) {
    ar.add(scanner.nextLine());
}

Random r = new Random();
random_word = ar.get(r.nextInt(ar.size()));
		
		
		return random_word ;
	}
	



	
	

	

}
