package vaczi.balazs;

public class Jatekos {
	// Osztályszintû változók
	private static int[] hajokHossza = { 2, 3, 3, 4, 5 };
	private static int hajokSzama = 5;
	public Hajok[] hajok;
	public Jatekmezo jatekMezoSajat;
	public Jatekmezo jatekMezoEllenfel;

	public Jatekos() {
		if (hajokSzama != 5) {
			System.out.println("Hiba! A hajók száma mindenképp 5 kell, hogy legyen.");
			hajokSzama = 5;
		}

		hajok = new Hajok[hajokSzama];
		for (int i = 0; i < hajokSzama; i++) {
			Hajok ideiglenesHajo = new Hajok(hajokHossza[i]);
			hajok[i] = ideiglenesHajo;
		}

		jatekMezoSajat = new Jatekmezo();
		jatekMezoEllenfel = new Jatekmezo();
	}

	public void hajoHozzaad() {
		for (Hajok hajok : hajok) {
			jatekMezoSajat.hajoHozzaad(hajok);
		}
	}

	public int hajokSzama() {
		int db = 5;
		for (Hajok hajok : hajok) {
			if (hajok.pozicioBeallitva() && hajok.iranyBeallitva())
				db--;
		}

		return db;

	}

	public void hajoHelyValaszt(Hajok hajok, int sor, int oszlop, int irany) {
		hajok.helyBeallit(sor, oszlop);
		hajok.iranyBeallit(irany);
		jatekMezoSajat.hajoHozzaad(hajok);
	}
}