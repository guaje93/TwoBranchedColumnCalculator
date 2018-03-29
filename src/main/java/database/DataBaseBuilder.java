package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DataBaseBuilder {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:src/main/resources/database/sections.db";

	private Connection conn;
	private Statement stat;

	public DataBaseBuilder() {
		try {
			Class.forName(DataBaseBuilder.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika JDBC");
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Problem z otwarciem polaczenia");
			e.printStackTrace();
		}

		createTables();
	}
	
	public boolean createTables() {
		String createSection = "CREATE TABLE IF NOT EXISTS sections (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"name varchar(255), " +
				"wysokosc_przekroju double," + 
				"szerokosc_stopki double," + 
				"grubosc_stopki double, " + 
				"grubosc_srodnika double," + 
				"promien_zaokraglenia double, " + 
				"pole_powierzchni double," + 
				"moment_bezwladnosci_y double," + 
				"moment_bezwladnosci_z double," + 
				"promien_bezwladnosci_y double," + 
				"promien_bezwladnosci_z double," + 
				"wskaznik_sprezysty_przekroju double )";
		try {
			stat.execute(createSection);
		} catch (SQLException e) {
			System.err.println("Blad przy tworzeniu tabeli");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertSection(String name, double wysokosc_przekroju, double szerokosc_stopki, double grubosc_stopki, double grubosc_srodnika,
			double promien_zaokraglenia, double pole_powierzchni, double moment_bezwladnosci_y,
			double moment_bezwladnosci_z, double promien_bezwladnosci_y, double promien_bezwladnosci_z,
			double wskaznik_sprezysty_przekroju) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("insert into sections values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			prepStmt.setString(1, name);
			prepStmt.setDouble(2, wysokosc_przekroju);
			prepStmt.setDouble(3, szerokosc_stopki);
			prepStmt.setDouble(4, grubosc_stopki);
			prepStmt.setDouble(5, grubosc_srodnika);
			prepStmt.setDouble(6, promien_zaokraglenia);
			prepStmt.setDouble(7, pole_powierzchni);
			prepStmt.setDouble(8, moment_bezwladnosci_y);
			prepStmt.setDouble(9, moment_bezwladnosci_z);
			prepStmt.setDouble(10, promien_bezwladnosci_y);
			prepStmt.setDouble(11, promien_bezwladnosci_z);
			prepStmt.setDouble(12, wskaznik_sprezysty_przekroju);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Blad przy wstawianiu przekroju");
			e.printStackTrace();
			return false;
		}
		return true;
	}

/*	public void change(String searchedField, String searchedValue, String changedField, String newValue) {

		try {
			// Polecenie zmiany
			String changeSQL = "UPDATE mountains SET " + changedField + " = '" + newValue + "' WHERE " + searchedField
					+ "='" + searchedValue + "';";
			System.out.println("Polecenie zmiany:\n" + changeSQL);
			// Uwaga: wywołujemy metodę executeUpdate
			stat.executeUpdate(changeSQL);

		} catch (Exception e) {
			System.out.println("Nie mogę poprawić danych " + e.getMessage());
		}
	}

	public void delete(String deleteField, String deleteValue) {

		try {
			String deleteSQL = "DELETE FROM mountains WHERE " + deleteField + "='" + deleteValue + "';";
			System.out.println("Polecenie:\n" + deleteSQL);
			stat.executeUpdate(deleteSQL);

		} catch (Exception e) {
			System.out.println("Nie mogę usunąć danych " + e.getMessage());
		}
	}
*/
	public List<data.Section> selectSection(String Query) {
		List<data.Section> sections = new LinkedList<data.Section>();
		try {
			ResultSet result = stat.executeQuery(Query);
			int id;
			String name;
			double wysokosc_przekroju,szerokosc_stopki, grubosc_stopki, grubosc_srodnika,
			promien_zaokraglenia, pole_powierzchni, moment_bezwladnosci_y,
			moment_bezwladnosci_z, promien_bezwladnosci_y, promien_bezwladnosci_z,
			wskaznik_sprezysty_przekroju;
			
			while (result.next()) {
				id = result.getInt("id");
				name = result.getString("name");
				wysokosc_przekroju = result.getDouble("wysokosc_przekroju");
				szerokosc_stopki = result.getDouble("szerokosc_stopki");
				grubosc_stopki = result.getDouble("grubosc_stopki");
				grubosc_srodnika = result.getDouble("grubosc_srodnika");
				promien_zaokraglenia = result.getDouble("promien_zaokraglenia");
				pole_powierzchni = result.getDouble("pole_powierzchni");
				moment_bezwladnosci_y = result.getDouble("moment_bezwladnosci_y");
				moment_bezwladnosci_z = result.getDouble("moment_bezwladnosci_z");
				promien_bezwladnosci_y = result.getDouble("promien_bezwladnosci_y"); 
				promien_bezwladnosci_z = result.getDouble("promien_bezwladnosci_z");
				wskaznik_sprezysty_przekroju = result.getDouble("wskaznik_sprezysty_przekroju");
				
				sections.add(new data.Section(id, name, wysokosc_przekroju,szerokosc_stopki, grubosc_stopki, grubosc_srodnika,
						promien_zaokraglenia, pole_powierzchni, moment_bezwladnosci_y,
						moment_bezwladnosci_z, promien_bezwladnosci_y, promien_bezwladnosci_z,
						wskaznik_sprezysty_przekroju));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return sections;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Problem z zamknieciem polaczenia");
			e.printStackTrace();
		}
	}
}