package data;

public class Stal {

	private double granica_plastycznosci;
	private final double modul_younga = 210; // GPa

	public Stal(double granica_plastycznosci) {
		this.setGranica_plastycznosci(granica_plastycznosci);
	}

	public Stal() {
		// TODO Auto-generated constructor stub
	}

	public double getGranica_plastycznosci() {
		return granica_plastycznosci;
	}

	public double getModul_younga() {
		return modul_younga;
	}

	public void setGranica_plastycznosci(double granica_plastycznosci) {
		this.granica_plastycznosci = granica_plastycznosci;
	}

}
