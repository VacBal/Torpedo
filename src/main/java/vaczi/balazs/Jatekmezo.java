package vaczi.balazs;

public class Jatekmezo {
	// Osztályszintû változók
	private Hely[][] mezo;
	private int pontok;
	public static int sorokSzama = 10;
	public static int oszlopokSzama = 10;
	SegedMetodusok seged = new SegedMetodusok();

	public Jatekmezo() {
		int sor, oszlop;
		Hely ideiglenesHely;

		if (sorokSzama > 26) {
			System.out.println("Túl sok sor lett megadva!");
			sorokSzama = 26;
		}
		mezo = new Hely[sorokSzama][oszlopokSzama];

		for (sor = 0; sor < mezo.length; sor++) {
			for (oszlop = 0; oszlop < mezo[sor].length; oszlop++) {
				ideiglenesHely = new Hely();
				mezo[sor][oszlop] = ideiglenesHely;
			}
		}
	}

	public void talalatJelol(int sor, int oszlop) {
		mezo[sor][oszlop].talalatJelol();
		pontok++;
	}

	public void talalatMelle(int sor, int oszlop) {
		mezo[sor][oszlop].talalatMelle();
	}

	public void allapotBeallit(int sor, int oszlop, int allapot) {
		mezo[sor][oszlop].allapotBeallit(allapot);
	}

	public int allapotLekerdez(int sor, int oszlop) {
		return mezo[sor][oszlop].allapotLekerdez();
	}

	public boolean korabbiLovesVizsgal(int sor, int oszlop) {
		return !mezo[sor][oszlop].korabbiLovesVizsgal();
	}

	public void hajoBeallit(int sor, int oszlop, boolean ertek) {
		mezo[sor][oszlop].hajoBeallit(ertek);
	}

	public boolean vanHajo(int sor, int oszlop) {
		return mezo[sor][oszlop].vanHajo();
	}

	public Hely helyLekerdez(int sor, int oszlop) {
		return mezo[sor][oszlop];
	}

	public int sorokSzamaLekerdez() {
		return sorokSzama;
	}

	public int oszlopokSzamaLekerdez() {
		return oszlopokSzama;
	}

	public void kiiratAllapot() {
		kiiaratasMezo(0);
	}

	public void hajokKiir() {
		kiiaratasMezo(1);
	}

	public void kiirat() {
		kiiaratasMezo(2);
	}

	public boolean vesztettVizsgal() {
		if (pontok >= 17)
			return true;
		else
			return false;
	}

	public void hajoHozzaad(Hajok hajok) {
		int sor = hajok.sorLekerdez();
		int oszlop = hajok.oszlopLekerdez();
		int hossz = hajok.hosszLekerdez();
		int irany = hajok.iranyLekerdez();

		if (!(hajok.iranyBeallitva()) || !(hajok.pozicioBeallitva()))
			throw new IllegalArgumentException("A hajó iránya vagy pozíciója nincs beállítva.");

		if (irany == 0) {
			for (int i = oszlop; i < oszlop + hossz; i++) {
				mezo[sor][i].hajoBeallit(true);
				mezo[sor][i].hajoHosszBeallit(hossz);
				mezo[sor][i].hajoIranyBeallit(irany);
			}
		} else if (irany == 1) {
			for (int i = sor; i < sor + hossz; i++) {
				mezo[i][oszlop].hajoBeallit(true);
				mezo[i][oszlop].hajoHosszBeallit(hossz);
				mezo[i][oszlop].hajoIranyBeallit(irany);
			}
		}
	}

	void kiiaratasMezo(int kiiratasModja) {
		int utolsoBetu;
		char karakter;

		System.out.println();

		System.out.print("\t");
		for (int i = 1; i <= oszlopokSzama; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println();

		utolsoBetu = (sorokSzama - 1) + 65;
		for (int i = 65; i <= utolsoBetu; i++) {
			karakter = (char) i;
			System.out.print(karakter + "\t");

			for (int j = 0; j < oszlopokSzama; j++) {
				if (kiiratasModja == 0) {
					if (mezo[seged.szamlaloTombKonvertal(i)][j].korabbiLovesVizsgal())
						System.out.print(". ");
					else if (mezo[seged.szamlaloTombKonvertal(i)][j].melleVizsgal())
						System.out.print("O ");
					else if (mezo[seged.szamlaloTombKonvertal(i)][j].talalatVizsgal())
						System.out.print("X ");
				} else if (kiiratasModja == 1) {
					if (mezo[seged.szamlaloTombKonvertal(i)][j].vanHajo()) {
						if (mezo[seged.szamlaloTombKonvertal(i)][j].hajoHosszLekerdez() == 2) {
							System.out.print("2 ");
						} else if (mezo[seged.szamlaloTombKonvertal(i)][j].hajoHosszLekerdez() == 3) {
							System.out.print("3 ");
						} else if (mezo[seged.szamlaloTombKonvertal(i)][j].hajoHosszLekerdez() == 4) {
							System.out.print("4 ");
						} else if (mezo[seged.szamlaloTombKonvertal(i)][j].hajoHosszLekerdez() == 5) {
							System.out.print("5 ");
						}
					}

					else if (!(mezo[seged.szamlaloTombKonvertal(i)][j].vanHajo())) {
						System.out.print(". ");
					}

				} else {
					if (mezo[seged.szamlaloTombKonvertal(i)][j].talalatVizsgal())
						System.out.print("X ");
					else if (mezo[seged.szamlaloTombKonvertal(i)][j].vanHajo()) {
						if (mezo[seged.szamlaloTombKonvertal(i)][j].hajoHosszLekerdez() == 2) {
							System.out.print("2 ");
						} else if (mezo[seged.szamlaloTombKonvertal(i)][j].hajoHosszLekerdez() == 3) {
							System.out.print("3 ");
						} else if (mezo[seged.szamlaloTombKonvertal(i)][j].hajoHosszLekerdez() == 4) {
							System.out.print("4 ");
						} else if (mezo[seged.szamlaloTombKonvertal(i)][j].hajoHosszLekerdez() == 5) {
							System.out.print("5 ");
						}
					} else if (!(mezo[seged.szamlaloTombKonvertal(i)][j].vanHajo())) {
						System.out.print(". ");
					}
				}
			}
			System.out.println();
		}
	}

	
}