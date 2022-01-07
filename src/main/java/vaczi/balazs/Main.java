package vaczi.balazs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
	static Scanner beolvaso = new Scanner(System.in);
	static SegedMetodusok seged = new SegedMetodusok();

	public static void main(String[] args) throws IOException {

		System.out.print("Add meg a nevedet: ");
		String jatekosNeve = beolvaso.next();

		Jatekos jatekos01 = new Jatekos();
		Jatekos jatekosAi = new Jatekos();
		String eredmeny = "";

		System.out.println("Játék kezdete\n- - - - - - - - - -");
		System.out.println("Hajók lerakása:");
		hajokLearakasa(jatekos01);
		System.out.println("A játékos minden hajót letett a játéktérre.");

		hajokLerakasaAi(jatekosAi);
		System.out.println("A számítógép minden hajót letett a játéktérre.");

		while (true) {
			System.out.println(eredmeny);
			System.out.println("Játékos lõ:");
			eredmeny = talalatVizsgalat(jatekos01, jatekosAi);

			if (jatekos01.jatekMezoSajat.vesztettVizsgal()) {
				System.out.println("A játékos vesztett.");
				highscoreKiirat();
				break;
			} else if (jatekosAi.jatekMezoSajat.vesztettVizsgal()) {
				System.out.println("A számítógép vesztett.");
				highscoreFrissit(jatekosNeve);
				highscoreKiirat();
				break;
			}

			System.out.println("A számítógép lõ:");
			aiLoves(jatekosAi, jatekos01);
		}
	}

	private static void aiLoves(Jatekos ai, Jatekos jatekos01) {
		int sor, oszlop;
		Random generator = new Random();

		sor = generator.nextInt(10);
		oszlop = generator.nextInt(10);

		while (ai.jatekMezoEllenfel.korabbiLovesVizsgal(sor, oszlop)) {
			sor = generator.nextInt(10);
			oszlop = generator.nextInt(10);
		}

		if (jatekos01.jatekMezoSajat.vanHajo(sor, oszlop)) {
			ai.jatekMezoEllenfel.talalatJelol(sor, oszlop);
			jatekos01.jatekMezoSajat.talalatJelol(sor, oszlop);
			System.out.println("Számítógép találat: " + seged.egeszbolBetu(sor) + seged.oszlopbolBetu(oszlop));
		} else {
			ai.jatekMezoEllenfel.talalatMelle(sor, oszlop);
			jatekos01.jatekMezoSajat.talalatMelle(sor, oszlop);
			System.out.println("Számítógép mellé: " + seged.egeszbolBetu(sor) + seged.oszlopbolBetu(oszlop));
		}

		System.out.println("A játéktér:");
		beolvaso.nextLine();
		jatekos01.jatekMezoSajat.kiirat();
		beolvaso.nextLine();
	}

	private static String talalatVizsgalat(Jatekos jatekos01, Jatekos ellenfel) {
		int sor, oszlop, regiOszlop;
		String regiSor;

		System.out.println("Tippek kiíratása:");
		jatekos01.jatekMezoEllenfel.kiiratAllapot();
		sor = -1;
		oszlop = -1;
		regiSor = "Z";
		regiOszlop = -1;

		while (true) {
			System.out.print("Add meg a sort: ");
			String jatekosBeolvasSor = beolvaso.next();
			jatekosBeolvasSor = jatekosBeolvasSor.toUpperCase();
			regiSor = jatekosBeolvasSor;
			sor = seged.betubolSzam(jatekosBeolvasSor);

			System.out.print("Add meg az oszlopot: ");
			oszlop = beolvaso.nextInt();
			regiOszlop = oszlop;
			oszlop = seged.oszlopKonvertal(oszlop);

			if (oszlop >= 0 && oszlop <= 9 && sor != -1)
				break;
			System.out.println("Hibás mezõ!");
		}

		if (ellenfel.jatekMezoSajat.vanHajo(sor, oszlop)) {
			jatekos01.jatekMezoEllenfel.talalatJelol(sor, oszlop);
			ellenfel.jatekMezoSajat.talalatJelol(sor, oszlop);
			return "Játékos találat: " + regiSor + regiOszlop;
		} else {
			jatekos01.jatekMezoEllenfel.talalatMelle(sor, oszlop);
			ellenfel.jatekMezoSajat.talalatMelle(sor, oszlop);
			return "Játékos mellé: " + regiSor + regiOszlop;
		}
	}

	private static void hajokLearakasa(Jatekos jatekos) {
		int szamlalo, szamlalo2, sor, oszlop, irany;
		String jatekosSor;

		jatekos.jatekMezoSajat.hajokKiir();
		System.out.println();
		szamlalo = 1;
		szamlalo2 = 0;

		while (jatekos.hajokSzama() > 0) {
			for (Hajok hajok : jatekos.hajok) {
				System.out.println("Hajó száma: " + szamlalo + ". Hossza: " + hajok.hosszLekerdez());
				sor = -1;
				oszlop = -1;
				irany = -1;

				while (true) {
					System.out.print("Add meg a sort: ");
					jatekosSor = beolvaso.next();
					jatekosSor = jatekosSor.toUpperCase();
					sor = seged.betubolSzam(jatekosSor);

					System.out.print("Add meg az oszlopot: ");
					oszlop = beolvaso.nextInt();
					oszlop = seged.oszlopKonvertal(oszlop);

					System.out.print("Irány: \n0 - vízszintes\n1 - függõleges");
					irany = beolvaso.nextInt();

					if (oszlop >= 0 && oszlop <= 9 && sor != -1 && irany != -1) {
						if (!hibaVizsgal(sor, oszlop, irany, jatekos, szamlalo2)) {
							break;
						}
					}
					System.out.println("Hibás mezõ!");
				}

				jatekos.hajok[szamlalo2].helyBeallit(sor, oszlop);
				jatekos.hajok[szamlalo2].iranyBeallit(irany);
				jatekos.jatekMezoSajat.hajoHozzaad(jatekos.hajok[szamlalo2]);
				jatekos.jatekMezoSajat.hajokKiir();
				System.out.println();
				System.out.println("Még letehetsz " + jatekos.hajokSzama() + " db hajót.");
				szamlalo2++;
				szamlalo++;
			}
		}
	}

	private static void hajokLerakasaAi(Jatekos jatekos) {
		int sor, oszlop, irany, szamlalo = 1, szamlalo2 = 0;
		Random generator = new Random();

		while (jatekos.hajokSzama() > 0) {
			for (Hajok hajok : jatekos.hajok) {
				sor = generator.nextInt(10);
				oszlop = generator.nextInt(10);
				irany = generator.nextInt(2);

				while (hibaVizsgalAi(sor, oszlop, irany, jatekos, szamlalo2)) {
					sor = generator.nextInt(10);
					oszlop = generator.nextInt(10);
					irany = generator.nextInt(2);
				}

				jatekos.hajok[szamlalo2].helyBeallit(sor, oszlop);
				jatekos.hajok[szamlalo2].iranyBeallit(irany);
				jatekos.jatekMezoSajat.hajoHozzaad(jatekos.hajok[szamlalo2]);
				szamlalo2++;
				szamlalo++;
			}
		}
	}

	private static boolean hibaVizsgal(int sor, int oszlop, int irany, Jatekos jatekos, int db) {
		int ell, hossz = jatekos.hajok[db].hosszLekerdez();

		if (irany == 0) {
			ell = hossz + oszlop;
			if (ell > 10) {
				System.out.println("Hiba, a hajó nem fér be a megadott mezõbe.");
				return true;
			}
		}

		if (irany == 1) {
			ell = hossz + sor;
			if (ell > 10) {
				System.out.println("Hiba, a hajó nem fér be a megadott mezõbe.");
				return true;
			}
		}

		if (irany == 0) {
			for (int i = oszlop; i < oszlop + hossz; i++) {
				if (jatekos.jatekMezoSajat.vanHajo(sor, i)) {
					System.out.println("Hiba, a megadott mezõn már van egy hajó.");
					return true;
				}
			}
		} else if (irany == 1) {
			for (int i = sor; i < sor + hossz; i++) {
				if (jatekos.jatekMezoSajat.vanHajo(i, oszlop)) {
					System.out.println("Hiba, a megadott mezõn már van egy hajó.");
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hibaVizsgalAi(int sor, int oszlop, int irany, Jatekos jatekos, int db) {
		int ell, hossz = jatekos.hajok[db].hosszLekerdez();

		if (irany == 0) {
			ell = hossz + oszlop;
			if (ell > 10) {
				return true;
			}
		}

		if (irany == 1) {
			ell = hossz + sor;
			if (ell > 10) {
				return true;
			}
		}

		if (irany == 0) {
			for (int i = oszlop; i < oszlop + hossz; i++) {
				if (jatekos.jatekMezoSajat.vanHajo(sor, i)) {
					return true;
				}
			}
		} else if (irany == 1) {
			for (int i = sor; i < sor + hossz; i++) {
				if (jatekos.jatekMezoSajat.vanHajo(i, oszlop)) {
					return true;
				}
			}
		}
		return false;
	}

	private static void highscoreFrissit(String jatekos) throws IOException {

		ArrayList<String> fileread = new ArrayList<>();

		try (Scanner s = new Scanner(new FileReader("highscore.txt"))) {
			while (s.hasNext()) {
				fileread.add(s.nextLine());
			}
		} catch (FileNotFoundException e) {

		}

		FileWriter myWriter = new FileWriter("highscore.txt");

		for (int i = 0; i < fileread.toArray().length; i++) {
			myWriter.write(String.valueOf(fileread.toArray()[i]));
			myWriter.write("\n");
		}
		myWriter.write(jatekos);
		myWriter.close();
	}

	private static void highscoreKiirat(){
		ArrayList<String> result = new ArrayList<>();

		try (Scanner s = new Scanner(new FileReader("highscore.txt"))) {
			while (s.hasNext()) {
				result.add(s.nextLine());
			}
		} catch (FileNotFoundException e) {

		}

		List asList = Arrays.asList(result.toArray());
		Set<String> mySet = new HashSet<String>(asList);

		for(String s: mySet){
			System.out.println(s + " " + Collections.frequency(asList,s));
		}
	}
}