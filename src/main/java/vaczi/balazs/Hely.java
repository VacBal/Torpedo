package vaczi.balazs;

public class Hely {
	// Osztályszintû változók
	public static int nemTippelt = 0;
	public static int talalat = 1;
	public static int melle = 2;
	private boolean vanHajo;
	private int allapot;
	private int hajoHossz;
	private int hajoIrany;

	public Hely() {
		allapot = 0;
		vanHajo = false;
		hajoHossz = -1;
		hajoIrany = -1;
	}

	public boolean talalatVizsgal() {
		if (allapot == talalat)
			return true;
		else
			return false;
	}

	public boolean melleVizsgal() {
		if (allapot == melle)
			return true;
		else
			return false;
	}

	public boolean korabbiLovesVizsgal() {
		if (allapot == nemTippelt)
			return true;
		else
			return false;
	}

	public void talalatJelol() {
		allapotBeallit(talalat);
	}

	public void talalatMelle() {
		allapotBeallit(melle);
	}

	public boolean vanHajo() {
		return vanHajo;
	}

	public void hajoBeallit(boolean ertek) {
		this.vanHajo = ertek;
	}

	public void allapotBeallit(int ertek) {
		this.allapot = ertek;
	}

	public int allapotLekerdez() {
		return allapot;
	}

	public int hajoHosszLekerdez() {
		return hajoHossz;
	}

	public void hajoHosszBeallit(int ertek) {
		hajoHossz = ertek;
	}

	public int getDirectionOfShip() {
		return hajoIrany;
	}

	public void hajoIranyBeallit(int ertek) {
		hajoIrany = ertek;
	}
}