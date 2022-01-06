package vaczi.balazs;

public class Hajok {
	// Osztályszintû változók
	private int sor;
	private int oszlop;
	private int hossz;
	private int irany;
	public static int beallitva = -1;
	public static int vizszintes = 0;
	public static int fuggoleges = 1;

	public Hajok(int hossz) {
		this.hossz = hossz;
		this.sor = -1;
		this.oszlop = -1;
		this.irany = beallitva;
	}

	public boolean pozicioBeallitva() {
		if (sor == -1 || oszlop == -1)
			return false;
		else
			return true;
	}

	public boolean iranyBeallitva() {
		if (irany == beallitva)
			return false;
		else
			return true;
	}

	public void helyBeallit(int sor2, int oszlop2) {
		this.sor = sor2;
		this.oszlop = oszlop2;
	}

	public void iranyBeallit(int iranySajat) {
		if (iranySajat != beallitva && iranySajat != vizszintes && iranySajat != fuggoleges)
			throw new IllegalArgumentException("Hibás irány!");
		this.irany = iranySajat;
	}

	public int sorLekerdez() {
		return sor;
	}

	public int oszlopLekerdez() {
		return oszlop;
	}

	public int hosszLekerdez() {
		return hossz;
	}

	public int iranyLekerdez() {
		return irany;
	}

	private String directionToString() {
		if (irany == beallitva)
			return "Nincs megadva.";
		else if (irany == vizszintes)
			return "Vízszintes";
		else
			return "Függõleges";
	}

	public String toString() {
		return "Hajó: " + sorLekerdez() + ", " + oszlopLekerdez() + ", hossz: " + hosszLekerdez() + ", irány: "
				+ directionToString();
	}
}