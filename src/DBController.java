
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBController {

	private Connection connection;

	public DBController(Connection connection) {
		this.connection = connection;
	}

	public void createTables() {
		createTableDaga();
	}

	public void dropTables(){
		dropTableDaga();
	}

	public void createTableDaga() {
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("CREATE TABLE Daga( id SERIAL PRIMARY KEY, nombre TEXT, nivel TEXT, descripcion TEXT, dano TEXT, dano_probabilidad TEXT, estadistica TEXT, encontrar TEXT )");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void createTableEspadas(){
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("CREATE TABLE Espadas( id SERIAL PRIMARY KEY, nombre TEXT, nivel TEXT, descripcion TEXT, dano TEXT, dano_probabilidad TEXT, estadistica TEXT, encontrar TEXT )");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void createTablePorras(){
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("CREATE TABLE Porras( id SERIAL PRIMARY KEY, nombre TEXT, nivel TEXT, descripcion TEXT, dano TEXT, dano_probabilidad TEXT, estadistica TEXT, encontrar TEXT )");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void dropTableDaga() {
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS Daga");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void dropTableEspadas() {
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS Espadas");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void dropTablePorras() {
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS Porraso");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void showTeams() throws SQLException, IOException {

		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT * FROM team");
		while (rs.next()) {
			System.out.println("Name: " + rs.getString("name") + " " +
							   "Type: " + rs.getString("type") + " " +
							   "Country: " + rs.getString("country") + " " +
							   "City: " + rs.getString("city") + " " +
							   "Court name: " + rs.getString("court_name"));
		}

		rs.close();
		st.close();
	}
}
