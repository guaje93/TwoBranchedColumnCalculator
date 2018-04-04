package calculations;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;

import data.Przewiazka;
import data.Section;
import data.Slup;
import data.Stal;

public class Calculator_plate {

	
	private double V_BED;
	private double M_BED;
	private double V_PL_RD;
	private double M_CRD;
	private double warunek_P1;
	private double warunek_P2;
	
	
	public double getV_BED() {
		return V_BED;
	}

	public double getM_BED() {
		return M_BED;
	}

	public double getV_PL_RD() {
		return V_PL_RD;
	}

	public double getM_CRD() {
		return M_CRD;
	}

	public double getWarunek_P1() {
		return warunek_P1;
	}

	public double getWarunek_P2() {
		return warunek_P2;
	}

	public double zaokragl(double liczba, int miejsca_po_przecinku) {
		double zmienna = pow(10, miejsca_po_przecinku);
		liczba = round(liczba * zmienna);
		liczba = liczba / zmienna;
		return liczba;

	}
	
	public void przewiazka(Section przekroj, Stal stal, Slup slup, Przewiazka przewiazka, Calculator_WZZ calculator3) {

		V_BED = 0.5 * calculator3.getVEd() * przewiazka.getRozstaw_przewiazek() * 1000 / slup.getRozstaw_galezi();
		V_BED = zaokragl(V_BED, 1);
		System.out.println(V_BED);

		M_BED = 0.5 * calculator3.getVEd() * przewiazka.getRozstaw_przewiazek() / 2;
		M_BED = zaokragl(M_BED, 1);
		System.out.println(M_BED);

		V_PL_RD =przewiazka.getWysokosc() * przewiazka.getGrubosc() * stal.getGranica_plastycznosci() / 1000 / sqrt(3);
		V_PL_RD = zaokragl(V_PL_RD, 1);
		System.out.println(V_PL_RD);

		M_CRD = przewiazka.getGrubosc() * przewiazka.getWysokosc() * przewiazka.getWysokosc() / 6 * stal.getGranica_plastycznosci() / 1000000 / 1.0;
		M_CRD = zaokragl(M_CRD, 1);
		System.out.println(M_CRD);

		warunek_P1 = abs(V_BED) / V_PL_RD;
		warunek_P1 = zaokragl(warunek_P1, 2);
		System.out.println(warunek_P1);

		warunek_P2 = abs(M_BED) / M_CRD;
		warunek_P2 = zaokragl(warunek_P2, 2);
		System.out.println(warunek_P2);
	
		System.out.println(przewiazka.getGrubosc());
		System.out.println(przewiazka.getSzerokosc());
		System.out.println(przewiazka.getWysokosc());
	}

	
}
