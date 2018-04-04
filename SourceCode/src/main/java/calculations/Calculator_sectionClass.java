package calculations;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;

import data.Section;
import data.Stal;

public class Calculator_sectionClass {

	public double epsilon;
	public int klasa_srodnika;
	public int klasa_stopek;
	public int klasa_przekroju;

	public void section_class(Stal stal, Section przekroj) {

		double ct1, ct2;

		if (przekroj.getName().equals("dwuteownik")) {
			ct1 = (przekroj.getWysokosc_przekroju() - 2 * przekroj.getGrubosc_stopki()
					- 2 * przekroj.getPromien_zaokraglenia()) / przekroj.getGrubosc_srodnika();
			ct2 = (przekroj.getSzerokosc_stopki() - przekroj.getGrubosc_srodnika() - przekroj.getPromien_zaokraglenia())
					/ przekroj.getGrubosc_stopki();
		} else {
			ct1 = (przekroj.getWysokosc_przekroju() - 2 * przekroj.getGrubosc_stopki()
					- 2 * przekroj.getPromien_zaokraglenia()) / przekroj.getGrubosc_srodnika();
			ct2 = (przekroj.getSzerokosc_stopki() - przekroj.getGrubosc_srodnika()
					- 2 * przekroj.getPromien_zaokraglenia()) / (2 * przekroj.getGrubosc_stopki());
		}

		epsilon = zaokragl(sqrt(235 / stal.getGranica_plastycznosci()),2);

		System.out.println(ct2);
		// KLASA SRODNIKA
		if (ct1 < 33 * epsilon)
			klasa_srodnika = 1;
		else if (ct1 < 38 * epsilon)
			klasa_srodnika = 2;
		else if (ct1 < 42 * epsilon)
			klasa_srodnika = 3;
		else
			klasa_srodnika = 4;

		// KLASA STOPEK
		if (ct2 < 9 * epsilon)
			klasa_stopek = 1;
		else if (ct2 < 10 * epsilon)
			klasa_stopek = 2;
		else if (ct2 < 14 * epsilon)
			klasa_stopek = 3;
		else
			klasa_stopek = 4;

		// KLASA PRZEKROJU
		if (klasa_srodnika > klasa_stopek)
			klasa_przekroju = klasa_srodnika;
		else
			klasa_przekroju = klasa_stopek;

	}

	public double zaokragl(double liczba, int miejsca_po_przecinku) {
		double zmienna = pow(10, miejsca_po_przecinku);
		liczba = round(liczba * zmienna);
		liczba = liczba / zmienna;
		return liczba;

	}
}
