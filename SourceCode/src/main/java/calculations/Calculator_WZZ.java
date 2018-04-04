package calculations;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;

import data.Przewiazka;
import data.Section;
import data.Slup;
import data.Stal;

public class Calculator_WZZ {

	private double I1;
	private double i0;
	private double lambda_z;
	private double mi;
	private double I_eff;
	private double I_b;
	private double a;
	private double Sv;
	private double warunek_Sv;
	private double e0;
	private double MED1;
	private double Ncrz;
	private double MEd;
	private double NchEd;
	private double VEd;
	private double  VchEd;
	private double MchEd;
	private double AchV;
	private double VplzRd;
	private double warunek_V;

	////////////////////////////////////////////////

	private double Ncr_z_ch;
	private double lambda_z_ch;
	private double alfa2;
	private double teta2;
	private double ksi2;

	/////////////////////////////////////////////////

	private double Wpl_z_ch;
	private double Mc_z_ch_Rd;

	////////////////////////////////////////////////
	private double _a;
	private double Npl_ch_Rd;
	private double _n;
	private double MN_z_ch_Rd;
	private double warunek_2M;
	private double Cmz;

	////////////////////////////////////////////////
	private double kzz;
	private double kzz_1;
	private double kzz_2;
	private double warunek_sz;
	
	
	
	public double getI1() {
		return I1;
	}

	public double getI0() {
		return i0;
	}

	public double getLambda_z() {
		return lambda_z;
	}

	public double getMi() {
		return mi;
	}

	public double getI_eff() {
		return I_eff;
	}

	public double getI_b() {
		return I_b;
	}

	public double getA() {
		return a;
	}

	public double getSv() {
		return Sv;
	}

	public double getWarunek_Sv() {
		return warunek_Sv;
	}

	public double getE0() {
		return e0;
	}

	public double getMED1() {
		return MED1;
	}

	public double getNcrz() {
		return Ncrz;
	}

	public double getMEd() {
		return MEd;
	}

	public double getNchEd() {
		return NchEd;
	}

	public double getVEd() {
		return VEd;
	}

	public double getVchEd() {
		return VchEd;
	}

	public double getMchEd() {
		return MchEd;
	}

	public double getAchV() {
		return AchV;
	}

	public double getVplzRd() {
		return VplzRd;
	}

	public double getWarunek_V() {
		return warunek_V;
	}

	public double getNcr_z_ch() {
		return Ncr_z_ch;
	}

	public double getLambda_z_ch() {
		return lambda_z_ch;
	}

	public double getAlfa2() {
		return alfa2;
	}

	public double getTeta2() {
		return teta2;
	}

	public double getKsi2() {
		return ksi2;
	}

	public double getWpl_z_ch() {
		return Wpl_z_ch;
	}

	public double getMc_z_ch_Rd() {
		return Mc_z_ch_Rd;
	}

	public double get_a() {
		return _a;
	}

	public double getNpl_ch_Rd() {
		return Npl_ch_Rd;
	}

	public double get_n() {
		return _n;
	}

	public double getMN_z_ch_Rd() {
		return MN_z_ch_Rd;
	}

	public double getWarunek_2M() {
		return warunek_2M;
	}

	public double getCmz() {
		return Cmz;
	}

	public double getKzz() {
		return kzz;
	}

	public double getKzz_1() {
		return kzz_1;
	}

	public double getKzz_2() {
		return kzz_2;
	}

	public double getWarunek_sz() {
		return warunek_sz;
	}

	public double zaokragl(double liczba, int miejsca_po_przecinku) {
		double zmienna = pow(10, miejsca_po_przecinku);
		liczba = round(liczba * zmienna);
		liczba = liczba / zmienna;
		return liczba;

	}
	
	public void warunek_nosonosci_pojedynczej_galezi(Section przekroj, Stal stal, Slup slup, Przewiazka przewiazka) {
		Ncr_z_ch = Math.PI * Math.PI * stal.getModul_younga() * 1000000 * przekroj.getMoment_bezwladnosci_z() / 100000000
				/ (przewiazka.getRozstaw_przewiazek() * przewiazka.getRozstaw_przewiazek()); // kPa
		Ncr_z_ch = zaokragl(Ncr_z_ch, 0);
		System.out.println(Ncr_z_ch);

		lambda_z_ch = sqrt(przekroj.getPole_powierzchni() * stal.getGranica_plastycznosci() / Ncr_z_ch / 10); //
		lambda_z_ch = zaokragl(lambda_z_ch, 3);
		System.out.println(lambda_z_ch);

		//alfa
		if(przekroj.getName().substring(0, 1).equals("I")){
		if (przekroj.getWysokosc_przekroju() / przekroj.getGrubosc_stopki() > 1.2) {
			if (przekroj.getGrubosc_stopki() < 40)
				alfa2 = 0.34;
			else
				alfa2 = 0.49;
		} else {
			if (przekroj.getGrubosc_stopki() <= 100)
				alfa2 = 0.49;
			else
				alfa2 = 0.76;
		}}
		else
			alfa2 = 0.49;
		
		System.out.println(alfa2);

		teta2 = 0.5 * (1 + alfa2 * (lambda_z_ch - 0.2) + lambda_z_ch * lambda_z_ch);
		teta2 = zaokragl(teta2, 3);
		System.out.println(teta2);

		ksi2 = 1 / (teta2 + sqrt(teta2 * teta2 - lambda_z_ch * lambda_z_ch));
		ksi2 = zaokragl(ksi2, 3);
		System.out.println(ksi2);
	}

	public void nosnosc_przekroju_przy_zginaniu(Section przekroj, Stal stal, Slup slup, Przewiazka przewiazka) {
		Wpl_z_ch = 1.5 * przekroj.getWskaznik_sprezysty_przekroju();
		System.out.println(Wpl_z_ch);
		Mc_z_ch_Rd = Wpl_z_ch * stal.getGranica_plastycznosci() / 1000 / 1.0;
		Mc_z_ch_Rd = zaokragl(Mc_z_ch_Rd, 2);
		System.out.println(Mc_z_ch_Rd);
	}

	public void nosnosc_przekroju_zginanego_z_sila_podluzna(Section przekroj, Stal stal, Slup slup, Przewiazka przewiazka) {
		_a = (przekroj.getPole_powierzchni() - 2 * przekroj.getSzerokosc_stopki() * przekroj.getGrubosc_stopki() / 100) / przekroj.getPole_powierzchni();
		System.out.println(_a);

		Npl_ch_Rd = przekroj.getPole_powierzchni() * stal.getGranica_plastycznosci() / 10 / 1.0;
		System.out.println(Npl_ch_Rd);
		_n = NchEd / Npl_ch_Rd;
		System.out.println(_n);
		MN_z_ch_Rd = Mc_z_ch_Rd * (1 - pow((_n - _a) / (1 - _a), 2));
		System.out.println(MN_z_ch_Rd);
		warunek_2M = MchEd / MN_z_ch_Rd;
		System.out.println(warunek_2M);
		Cmz = 0.4;

	}

	public void nosnosc_elementu_sciskanego_i_zginanego(Section przekroj, Stal stal, Slup slup, Przewiazka przewiazka) {

		kzz_1 = Cmz * (1 + (2 * lambda_z_ch - 0.6) * NchEd / (ksi2 * przekroj.getPole_powierzchni() * stal.getGranica_plastycznosci() / 10));
		kzz_2 = Cmz * (1 + 1.4 * NchEd / (ksi2 * przekroj.getPole_powierzchni() * stal.getGranica_plastycznosci() / 10));
		System.out.println(kzz_1);
		System.out.println(kzz_2);
		if (kzz_1 > kzz_2)
			kzz = kzz_2;
		else
			kzz = kzz_1;
		kzz = zaokragl(kzz, 3);

		warunek_sz = abs(NchEd) / (ksi2 * Npl_ch_Rd) + kzz * MchEd / Mc_z_ch_Rd;
		warunek_sz = zaokragl(warunek_sz, 2);
		System.out.println(warunek_sz);
	}

	public void wyboczenie_z_z(Section przekroj, Stal stal, Slup slup, Przewiazka przewiazka) {

		// Moment bezwładności przekroju złożonego względem osi z-z
		I1 = 0.5 * slup.getRozstaw_galezi() * slup.getRozstaw_galezi() / 100 * przekroj.getPole_powierzchni() + 2 * przekroj.getMoment_bezwladnosci_z();
		I1 = zaokragl(I1, 0);
		System.out.println(I1);

		// Promień bezwładności przekroju złożonego względem osi z-z
		i0 = sqrt(I1 / 2 / przekroj.getPole_powierzchni());
		i0 = zaokragl(i0, 2);
		System.out.println(i0);

		// Smukłoąć giętna słupa przy wyboczeniu względem osi z-z
		lambda_z = slup.getDlugosc_wyboczeniowa() * 100 / i0;
		lambda_z = zaokragl(lambda_z, 2);
		System.out.println(lambda_z);
		// Wskaznik efektywnosci
		mi = 1.0;
		System.out.println(mi);

		// Zastępczy moment bezwładnosci słupa złożonego z przewiązkami
		I_eff = 0.5 * slup.getRozstaw_galezi() * slup.getRozstaw_galezi() / 100 * przekroj.getPole_powierzchni() + mi * 2 * przekroj.getMoment_bezwladnosci_z();
		I_eff = zaokragl(I_eff, 0);
		System.out.println(I_eff);

		// Moment bezwładności jednej przewiązki w płasczyznie układu
		I_b = przewiazka.getGrubosc() * przewiazka.getWysokosc() * przewiazka.getWysokosc() * przewiazka.getWysokosc()  / 12 / 10000;
		I_b = zaokragl(I_b, 1);
		System.out.println(I_b);

		// Liczba plaszczyzn przewiazek
		int n = 2;

		// Sztywność postaciowa słupa
		Sv = 24 * stal.getModul_younga() * przekroj.getMoment_bezwladnosci_z() * 10000
				/ (przewiazka.getRozstaw_przewiazek() * 1000 * przewiazka.getRozstaw_przewiazek() * 1000 * (1 + 2 * przekroj.getMoment_bezwladnosci_z() * 10000
						* slup.getRozstaw_galezi() / (n * I_b * 10000 * przewiazka.getRozstaw_przewiazek() * 1000))); // kN

		System.out.println(Sv);

		if (Sv > 2 * Math.PI * Math.PI * przekroj.getMoment_bezwladnosci_z() * 10 / (przewiazka.getRozstaw_przewiazek() * przewiazka.getRozstaw_przewiazek()))
			Sv = 2 * Math.PI * Math.PI * przekroj.getMoment_bezwladnosci_z() * 10 / (przewiazka.getRozstaw_przewiazek() * przewiazka.getRozstaw_przewiazek());

		Sv = zaokragl(Sv, 0);
		System.out.println(Sv);

		// Wstepna imperfekcja slupa
		e0 = slup.getDlugosc() / 500 * 1000; // mm
		System.out.println(slup.getDlugosc());

		// Maksymalny moment przesłowy słupa bez uwzględnienia efektów drugiego rzędu
		MED1 = 0;

		// Siła krytyczna wyboczenia giętnego słupa dwugałeziowego względem osi z-z
		Ncrz = Math.PI * Math.PI * stal.getModul_younga() * I_eff / 100 / slup.getDlugosc_wyboczeniowa() / slup.getDlugosc_wyboczeniowa();
		Ncrz = zaokragl(Ncrz, 0);
		System.out.println(Ncrz);

		// Maksymalny moment przeslowy slupa z uwzglednieniem efektow drugiego rzedu
		MEd = (slup.getSila() * e0 / 1000 + MED1) / (1 - slup.getSila() / Ncrz - slup.getSila() / Sv);
		MEd = zaokragl(MEd, 2);
		System.out.println(MEd);

		// Obliczeniowa siła podłużna w pasie
		NchEd = 0.5 * slup.getSila() + MEd * slup.getRozstaw_galezi() / 1000 * przekroj.getPole_powierzchni() / 10000 / (2 * I_eff / 100000000);
		NchEd = zaokragl(NchEd, 2);
		System.out.println(NchEd);

		// Siła poprzeczna w słupie:
		VEd = Math.PI * MEd / slup.getDlugosc();
		VEd = zaokragl(VEd, 2);
		System.out.println(VEd);

		// Siłą poprzeczna w pasie;
		VchEd = VEd * 0.5;
		VchEd = zaokragl(VchEd, 2);
		System.out.println(VchEd);

		// Moment zginający pas:
		MchEd = VchEd * przewiazka.getRozstaw_przewiazek() / 2;
		MchEd = zaokragl(MchEd, 2);
		System.out.println(MchEd);

		// Pole przekroju czynnego przy scinaniu jednego pasa
		AchV = 2 * przekroj.getSzerokosc_stopki() * przekroj.getGrubosc_stopki() / 100;
		AchV = zaokragl(AchV, 1);
		System.out.println(AchV);

		// Nośność przekroju przy ścinaniu
		VplzRd = AchV * stal.getGranica_plastycznosci() / 10 / sqrt(3) / 1.0;
		VplzRd = zaokragl(VplzRd, 1);
		System.out.println(VplzRd);

		warunek_nosonosci_pojedynczej_galezi(przekroj, stal,slup,przewiazka);
		nosnosc_przekroju_przy_zginaniu(przekroj, stal,slup,przewiazka);
		nosnosc_przekroju_zginanego_z_sila_podluzna(przekroj, stal,slup,przewiazka);
		nosnosc_elementu_sciskanego_i_zginanego(przekroj, stal,slup,przewiazka);

	}
	
	
}
