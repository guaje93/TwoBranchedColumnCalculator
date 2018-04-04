package data;

public class Przewiazka {

	private double ilosc_przewiazek;
	private double rozstaw_przewiazek;
	private double szerokosc;
	private double wysokosc;
	private double grubosc;
	
	public double getIlosc_przewiazek() {
		return ilosc_przewiazek;
	}

	public void setIlosc_przewiazek(double ilosc_przewiazek) {
		this.ilosc_przewiazek = ilosc_przewiazek;
	}

	public double getRozstaw_przewiazek() {
		return rozstaw_przewiazek;
	}

	public void setRozstaw_przewiazek(double rozstaw_przewiazek) {
		this.rozstaw_przewiazek = rozstaw_przewiazek;
	}

	public double getSzerokosc() {
		return szerokosc;
	}

	public void setSzerokosc(double szerokosc) {
		this.szerokosc = szerokosc;
	}

	public double getWysokosc() {
		return wysokosc;
	}

	public void setWysokosc(double wysokosc) {
		this.wysokosc = wysokosc;
	}

	public double getGrubosc() {
		return grubosc;
	}

	public void setGrubosc(double grubosc) {
		this.grubosc = grubosc;
	}

	

	public Przewiazka(double ilosc_przewiazek,double rozstaw_przewiazek,double szerokosc,double wysokosc,double grubosc){
		
	this.ilosc_przewiazek   = ilosc_przewiazek;
	this.rozstaw_przewiazek = rozstaw_przewiazek;
	this.szerokosc          = szerokosc;
	this.wysokosc           = wysokosc;
	this.grubosc            = grubosc;
	}

	public Przewiazka() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
