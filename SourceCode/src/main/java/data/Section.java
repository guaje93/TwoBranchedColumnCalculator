package data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import database.BaseModel;

@DatabaseTable(tableName = "sections")
public class Section implements BaseModel{

    @DatabaseField(generatedId = true)
	protected int ID;

    @DatabaseField(columnName = "name", canBeNull = false, unique = false)
	protected String name;

    @DatabaseField(columnName = "wysokosc_przekroju", canBeNull = false, unique = false)
	protected double wysokosc_przekroju;
    
    @DatabaseField(columnName = "szerokosc_stopki", canBeNull = false, unique = false)
	protected double szerokosc_stopki;
    
    @DatabaseField(columnName = "grubosc_stopki", canBeNull = false, unique = false)
	protected double grubosc_stopki;
    
    @DatabaseField(columnName = "grubosc_srodnika", canBeNull = false, unique = false)
	protected double grubosc_srodnika;
    
    @DatabaseField(columnName = "promien_zaokraglenia", canBeNull = false, unique = false)
	protected double promien_zaokraglenia;
    
    @DatabaseField(columnName = "pole_powierzchni", canBeNull = false, unique = false)
	protected double pole_powierzchni;
    
    @DatabaseField(columnName = "moment_bezwladnosci_y", canBeNull = false, unique = false)
	protected double moment_bezwladnosci_y;
    
    @DatabaseField(columnName = "moment_bezwladnosci_z", canBeNull = false, unique = false)
	protected double moment_bezwladnosci_z;
    
    @DatabaseField(columnName = "promien_bezwladnosci_y", canBeNull = false, unique = false)
	protected double promien_bezwladnosci_y;
    
    @DatabaseField(columnName = "promien_bezwladnosci_z", canBeNull = false, unique = false)
	protected double promien_bezwladnosci_z;
    
    @DatabaseField(columnName = "wskaznik_sprezysty_przekroju", canBeNull = false, unique = false)
	protected double wskaznik_sprezysty_przekroju;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWysokosc_przekroju(double wysokosc_przekroju) {
		this.wysokosc_przekroju = wysokosc_przekroju;
	}

	public void setSzerokosc_stopki(double szerokosc_stopki) {
		this.szerokosc_stopki = szerokosc_stopki;
	}

	public void setGrubosc_stopki(double grubosc_stopki) {
		this.grubosc_stopki = grubosc_stopki;
	}

	public void setGrubosc_srodnika(double grubosc_srodnika) {
		this.grubosc_srodnika = grubosc_srodnika;
	}

	public void setPromien_zaokraglenia(double promien_zaokraglenia) {
		this.promien_zaokraglenia = promien_zaokraglenia;
	}

	public void setPole_powierzchni(double pole_powierzchni) {
		this.pole_powierzchni = pole_powierzchni;
	}

	public void setMoment_bezwladnosci_y(double moment_bezwladnosci_y) {
		this.moment_bezwladnosci_y = moment_bezwladnosci_y;
	}

	public void setMoment_bezwladnosci_z(double moment_bezwladnosci_z) {
		this.moment_bezwladnosci_z = moment_bezwladnosci_z;
	}

	public void setPromien_bezwladnosci_y(double promien_bezwladnosci_y) {
		this.promien_bezwladnosci_y = promien_bezwladnosci_y;
	}

	public void setPromien_bezwladnosci_z(double promien_bezwladnosci_z) {
		this.promien_bezwladnosci_z = promien_bezwladnosci_z;
	}

	public void setWskaznik_sprezysty_przekroju(double wskaznik_sprezysty_przekroju) {
		this.wskaznik_sprezysty_przekroju = wskaznik_sprezysty_przekroju;
	}

	
	

	public String getName() {
		return name;
	}

	public double getWysokosc_przekroju() {
		return wysokosc_przekroju;
	}

	public double getSzerokosc_stopki() {
		return szerokosc_stopki;
	}

	public double getGrubosc_stopki() {
		return grubosc_stopki;
	}

	public double getGrubosc_srodnika() {
		return grubosc_srodnika;
	}

	public double getPromien_zaokraglenia() {
		return promien_zaokraglenia;
	}

	public double getPole_powierzchni() {
		return pole_powierzchni;
	}

	public double getMoment_bezwladnosci_y() {
		return moment_bezwladnosci_y;
	}

	public double getMoment_bezwladnosci_z() {
		return moment_bezwladnosci_z;
	}

	public double getPromien_bezwladnosci_y() {
		return promien_bezwladnosci_y;
	}

	public double getPromien_bezwladnosci_z() {
		return promien_bezwladnosci_z;
	}

	public double getWskaznik_sprezysty_przekroju() {
		return wskaznik_sprezysty_przekroju;
	}

	public double getAlfa(double wysokosc_przekroju, double grubosc_stopki, char znak) {
		double alfa = 0;
		return alfa;
	}

		
	public Section(int iD, String name, double wysokosc_przekroju, double szerokosc_stopki, double grubosc_stopki,
			double grubosc_srodnika, double promien_zaokraglenia, double pole_powierzchni, double moment_bezwladnosci_y,
			double moment_bezwladnosci_z, double promien_bezwladnosci_y, double promien_bezwladnosci_z,
			double wskaznik_sprezysty_przekroju) {
		super();
		ID = iD;
		this.name = name;
		this.wysokosc_przekroju = wysokosc_przekroju;
		this.szerokosc_stopki = szerokosc_stopki;
		this.grubosc_stopki = grubosc_stopki;
		this.grubosc_srodnika = grubosc_srodnika;
		this.promien_zaokraglenia = promien_zaokraglenia;
		this.pole_powierzchni = pole_powierzchni;
		this.moment_bezwladnosci_y = moment_bezwladnosci_y;
		this.moment_bezwladnosci_z = moment_bezwladnosci_z;
		this.promien_bezwladnosci_y = promien_bezwladnosci_y;
		this.promien_bezwladnosci_z = promien_bezwladnosci_z;
		this.wskaznik_sprezysty_przekroju = wskaznik_sprezysty_przekroju;
	}

	public Section() {
		// TODO Auto-generated constructor stub
	}

	
	
	
}
