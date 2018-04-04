 package calculations;


import data.Przewiazka;
import data.Section;
import data.Slup;
import data.Stal;
import database.DataBaseDirector;

public class Designer {

	private Section Przekroj;
	private Stal Stal;
	private Slup Slup;
	private Przewiazka Przewiazka;
	
	public Slup getSlup() {
		return Slup;
	}

	public Stal getStal() {
		return Stal;
	}

	public Section getPrzekroj() {
		return Przekroj;
	}
	
	public Przewiazka getPrzewiazka() {
		return Przewiazka;
	}

	public void insertColumnData(double dlugosc_wyboczeniowa, double dlugosc, double sila,
			double rozstaw_galezi) {

		Slup = new Slup(dlugosc_wyboczeniowa, dlugosc, sila, rozstaw_galezi);
	
	}

	public void insertMaterialData(double granica_plastycznosci) {

		Stal = new Stal(granica_plastycznosci);
	}

	public void insertPlateData(double ilosc_przewiazek, double rozstaw_przewiazek, double szerokosc,
			double wysokosc, double grubosc) {

		Przewiazka = new Przewiazka(ilosc_przewiazek, rozstaw_przewiazek, szerokosc, wysokosc, grubosc);
	}

	public void insertSectionData(int ID, String name, DataBaseDirector director) {
			Przekroj = director.insert(name);
		
		}

}
