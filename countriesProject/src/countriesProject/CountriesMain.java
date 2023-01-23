package countriesProject;

import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;

public class CountriesMain {

	public static void main(String[] args) {

		// Attributes

		HashMap<String, String> listCountries = new HashMap<String, String>();
		String line;
		String[] separatedLine = new String[100];
		int i;
		int n;
		int j = 0;
		int totalPoints = 0;
		String userName;

		// Main Code

		try {
			File doc = new File("C:/Users/ZGali/Downloads/Countries.txt");
			BufferedReader buf = new BufferedReader(new FileReader(doc));
			while (j <= 50) {
				line = buf.readLine();
				separatedLine = line.split(" ");
				if (separatedLine != null && separatedLine.length >= 1) {
					listCountries.put(separatedLine[0], separatedLine[1]);
				}
				j++;
			}

			i = listCountries.size();
			String paisRandom = null;

			// Inici del formulari.

			userName = JOptionPane.showInputDialog("Introdueix el nom d'usuari:");

			for (int v = 0; v <= 10; v++) {
				n = (int) (Math.random() * ((i - 0 + 1) - 0));

				List<String> indexes = new ArrayList<String>(listCountries.keySet());
				if (n < indexes.size()) {
					for (Map.Entry<String, String> pair : listCountries.entrySet()) {
						if (pair.getKey().equals(indexes.get(n))) {
							paisRandom = pair.getKey();
							break;
						}
					}
				}

				String capital = JOptionPane.showInputDialog("Introdueixi la capital de " + paisRandom);
				if (capital != null && capital.equals(listCountries.get(paisRandom))) {
					JOptionPane.showMessageDialog(null, "La capital " + capital + " és correcta");
					totalPoints++;
				} else
					JOptionPane.showMessageDialog(null,
							"Resposta incorrecta, la capital és " + listCountries.get(paisRandom));
			}
			JOptionPane.showMessageDialog(null, "La puntuació final ha sigut de " + totalPoints + "punts.");

			String ruta = "C:/Users/ZGali/Downloads/Classificacio.txt";
			File file = new File(ruta);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("La puntuació de " + userName + " es de: " + totalPoints);
			bw.close();

		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No s'ha trobat l'arxiu");
		}
	}
}