package lionel.projet.games.bll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dictionnaire {

	private static Dictionnaire instance;

	public static Dictionnaire getInstance() {
		if (instance == null) {
			instance = new Dictionnaire();
		}
		return instance;
	}

	public String tirageAuHasard() {
		String random_word = null;
		// FileInputStream dictionnaire = new
		// FileInputStream("/games/dico/dictionnaire.txt");

		FileInputStream inputdico = null;
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

		while (scanner.hasNextLine()) {
			ar.add(scanner.nextLine());
		}

		Random r = new Random();
		random_word = ar.get(r.nextInt(ar.size()));

		return random_word;
	}
	
	public List<String> melangeMot() {
		List<String> motList = new ArrayList<String>(); 
		String mot_alea =tirageAuHasard().toLowerCase();
		char [] mychar = mot_alea.toCharArray();
		Random rand = new Random();
		String mot_melange;
		char [] mychar_melange = new char [mychar.length]; 
		
		
		System.out.println(mot_alea);
		
		for (int i = 0; i < mychar.length; i++) {
			int index = 0;
		  do {
              index = rand.nextInt(mychar.length);
              System.out.println(index);
          } while (mychar_melange[index] != '\u0000');

          mychar_melange[index] = mychar[i];
      }

		mot_melange = String.valueOf(mychar_melange);
		motList.add(mot_alea);
		motList.add(mot_melange);

		return motList;
	}

}
