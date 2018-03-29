package calculations;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;

import data.Section;
import data.Slup;
import data.Stal;

public class Calculator_WYY {

	private double A;
	private double I;
	private double i;
	private double n_cr;
	private double lambda;
	private double alfa;
	private double teta;
	private double ksi;
	private double nbrd;
	private double warunek1;
	
	public double getN_cr() {
		return n_cr;
	}

	public double getLambda() {
		return lambda;
	}

	public double getKsi() {
		return ksi;
	}

	public double getNbrd() {
		return nbrd;
	}

	public double getWarunek1() {
		return warunek1;
	}

	
	public double zaokragl(double liczba, int miejsca_po_przecinku) {
		double zmienna = pow(10, miejsca_po_przecinku);
		liczba = round(liczba * zmienna);
		liczba = liczba / zmienna;
		return liczba;

	}
	
	public void wyboczenie_y_y(Section Przekroj, Stal Stal, Slup Slup) {
		
		A = 2 * Przekroj.getPole_powierzchni(); // cm2
		I = 2 * Przekroj.getMoment_bezwladnosci_y(); // cm4
		i = Przekroj.getPromien_bezwladnosci_y(); // cm
		n_cr = Math.PI * Math.PI * Stal.getModul_younga() * 1000000 * I / 100000000
				/ (Slup.getDlugosc_wyboczeniowa() * Slup.getDlugosc_wyboczeniowa()); // kPa
		n_cr = zaokragl(n_cr, 0);
		System.out.println(n_cr);

		lambda = sqrt(A * Stal.getGranica_plastycznosci() / n_cr / 10); //
		lambda = zaokragl(lambda, 3);
		System.out.println(lambda);

		//ALFA
		if(Przekroj.getName().substring(0, 1).equals("I")){
			
			if (Przekroj.getWysokosc_przekroju() / Przekroj.getGrubosc_stopki() > 1.2) {
				if (Przekroj.getGrubosc_stopki() < 40)
					alfa = 0.21;
				else
					alfa = 0.34;
			} else {
				if (Przekroj.getGrubosc_stopki() <= 100)
					alfa = 0.34;
				else
					alfa = 0.76;
			}
		}
		else
			alfa = 0.49;
		
		System.out.println(alfa);

		teta = 0.5 * (1 + alfa * (lambda - 0.2) + lambda * lambda);
		teta = zaokragl(teta, 3);
		System.out.println(teta);

		ksi = 1 / (teta + sqrt(teta * teta - lambda * lambda));
		ksi = zaokragl(ksi, 3);
		System.out.println(ksi);

		nbrd = ksi * A * Stal.getGranica_plastycznosci() / 10.0;
		nbrd = zaokragl(nbrd, 0);
		System.out.println(nbrd);

		warunek1 = abs(Slup.getSila()) / nbrd;
		warunek1 = zaokragl(warunek1, 2);
		System.out.println(warunek1);

	}
}
