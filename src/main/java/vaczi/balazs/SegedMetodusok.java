package vaczi.balazs;

public class SegedMetodusok {

	public int betubolSzam(String betu) {
		int eredmenySzam = -1;
		switch (betu) {
		case "A":
			eredmenySzam = 0;
			break;
		case "B":
			eredmenySzam = 1;
			break;
		case "C":
			eredmenySzam = 2;
			break;
		case "D":
			eredmenySzam = 3;
			break;
		case "E":
			eredmenySzam = 4;
			break;
		case "F":
			eredmenySzam = 5;
			break;
		case "G":
			eredmenySzam = 6;
			break;
		case "H":
			eredmenySzam = 7;
			break;
		case "I":
			eredmenySzam = 8;
			break;
		case "J":
			eredmenySzam = 9;
			break;
		default:
			eredmenySzam = -1;
			break;
		}
		return eredmenySzam;
	}

	public String egeszbolBetu(int egesz) {
		String eredmenyBetu = "Z";
		String[] betuk = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "Z" };
		return egesz >= 0 && egesz <= 9 ? betuk[egesz] : betuk[betuk.length];
	}

	public static int oszlopKonvertal(int oszlop) {
		return oszlop >= 1 && oszlop <= 10 ? oszlop - 1 : -1;
	}

	public static int oszlopbolBetu(int oszlop) {
		return oszlop >= 0 && oszlop <= 9 ? oszlop + 1 : -1;
	}

	public int szamlaloTombKonvertal(int ertek) {
		ertek = ertek >= 65 && ertek <= 90 ? ertek - 65 : -1;

		if (ertek == -1) {
			throw new IllegalArgumentException("Hiba a konvertálás során.");
		} else {
			return ertek;
		}
	}
}
