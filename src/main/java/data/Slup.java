package data;

public class Slup {

	private double dlugosc_wyboczeniowa;
	private double dlugosc;
	private double sila;
	private double rozstaw_galezi;
	
	
	public double getDlugosc_wyboczeniowa() {
		return dlugosc_wyboczeniowa;
	}
	public void setDlugosc_wyboczeniowa(double dlugosc_wyboczeniowa) {
		this.dlugosc_wyboczeniowa = dlugosc_wyboczeniowa;
	}
	public double getDlugosc() {
		return dlugosc;
	}
	public void setDlugosc(double dlugosc) {
		this.dlugosc = dlugosc;
	}
	public double getSila() {
		return sila;
	}
	public void setSila(double sila) {
		this.sila = sila;
	}
	public double getRozstaw_galezi() {
		return rozstaw_galezi;
	}
	public void setRozstaw_galezi(double rozstaw_galezi) {
		this.rozstaw_galezi = rozstaw_galezi;
	}

	public Slup(double dlugosc_wyboczeniowa, double dlugosc, double sila, double rozstaw_galezi) {
		
		this.dlugosc_wyboczeniowa = dlugosc_wyboczeniowa;
		this.dlugosc = dlugosc;
		this.sila = sila;
		this.rozstaw_galezi = rozstaw_galezi;
	}
	public Slup() {
		// TODO Auto-generated constructor stub
	}
}
