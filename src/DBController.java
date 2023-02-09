
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DBController {
	private Connection conn;

	public DBController(Connection connection) {
		this.conn = connection;
	}

	public void createTables() {
		createTableDaga();
		createTableEspadas();
		createTablePorras();
	}

	public void insertEspadas() {

		CSVController csvController = new CSVController();
		String sql = "INSERT INTO Espadas(nombre, nivel, descripcion, dano, dano_probabilidad, estadistica, encontrar) VALUES (?,?,?,?,?,?,?)";
		try {

			PreparedStatement pst = conn.prepareStatement(sql);
			ArrayList<ArrayList<String>> datos = csvController.readDataLineByLine("src/CSV/espadas.csv");

			// Elimina la primera fila (contiene las cabeceras)
			datos.remove(0);

			for (ArrayList<String> fila : datos) {
				pst.clearParameters();
				pst.setString(1, fila.get(0));
				pst.setString(2, fila.get(1));
				pst.setString(3, fila.get(2));
				pst.setString(4, fila.get(3));
				pst.setString(5, fila.get(4));
				pst.setString(6, fila.get(5));
				pst.setString(7, fila.get(6));
				pst.executeUpdate();
			}

			pst.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void insertPorras() {

		CSVController csvController = new CSVController();
		String sql = "INSERT INTO Porras(nombre, nivel, descripcion, dano, dano_probabilidad, estadistica, encontrar) VALUES (?,?,?,?,?,?,?)";
		try {

			PreparedStatement pst = conn.prepareStatement(sql);
			ArrayList<ArrayList<String>> datos = csvController.readDataLineByLine("src/CSV/porras.csv");

			// Elimina la primera fila (contiene las cabeceras)
			datos.remove(0);

			for (ArrayList<String> fila : datos) {
				pst.clearParameters();
				pst.setString(1, fila.get(0));
				pst.setString(2, fila.get(1));
				pst.setString(3, fila.get(2));
				pst.setString(4, fila.get(3));
				pst.setString(5, fila.get(4));
				pst.setString(6, fila.get(5));
				pst.setString(7, fila.get(6));
				pst.executeUpdate();
			}

			pst.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void insertDagas() {

		CSVController csvController = new CSVController();
		String sql = "INSERT INTO Daga(nombre, nivel, descripcion, dano, dano_probabilidad, estadistica, encontrar) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ArrayList<ArrayList<String>> datos =  csvController.readDataLineByLine("src/CSV/dagas.csv");

			// Elimina la primera fila (contiene las cabeceras)
			datos.remove(0);

			for (ArrayList<String> fila : datos) {
				pst.clearParameters();
				pst.setString(1, fila.get(0));
				pst.setString(2, fila.get(1));
				pst.setString(3, fila.get(2));
				pst.setString(4, fila.get(3));
				pst.setString(5, fila.get(4));
				pst.setString(6, fila.get(5));
				pst.setString(7, fila.get(6));
				pst.executeUpdate();
			}

			pst.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void rellenarTablas(){
		insertDagas();
		insertEspadas();
		insertPorras();
	}

	public void dropTables(){
		dropTableDaga();
		dropTableEspadas();
		dropTablePorras();
	}

	public void filterinfo() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce el nombre de la tabla: ");
		String tableName = scanner.nextLine();
		System.out.print("Introduce el nombre de la columna: ");
		String columnName = scanner.nextLine();
		System.out.print("Introduce el texto a buscar: ");
		String searchText = scanner.nextLine();

		// Crea un prepared statement
		String sql = "SELECT * FROM " + tableName + " WHERE " + columnName + " LIKE ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "%" + searchText + "%");

		// Ejecuta el prepared statement y obtiene el resultado
		ResultSet result = statement.executeQuery();

		// Imprime los resultados
		while (result.next()) {
			System.out.println("ID: " + result.getInt("id"));
			System.out.println(columnName + ": " + result.getString(columnName));
		}

	}


	public void createTableDaga() {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("CREATE TABLE Daga( id SERIAL PRIMARY KEY, nombre TEXT, nivel TEXT, descripcion TEXT, dano TEXT, dano_probabilidad TEXT, estadistica TEXT, encontrar TEXT )");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void createTableEspadas(){
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("CREATE TABLE Espadas( id SERIAL PRIMARY KEY, nombre TEXT, nivel TEXT, descripcion TEXT, dano TEXT, dano_probabilidad TEXT, estadistica TEXT, encontrar TEXT )");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void createTablePorras(){
		try {
			Statement st = conn.createStatement();
			st.
					 executeUpdate("CREATE TABLE Porras( id SERIAL PRIMARY KEY, nombre TEXT, nivel TEXT, descripcion TEXT, dano TEXT, dano_probabilidad TEXT, estadistica TEXT, encontrar TEXT )");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void dropTableDaga() {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS Daga cascade");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void dropTableEspadas() {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS Espadas cascade");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void dropTablePorras() {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DROP TABLE porras cascade");
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void showTeams() throws SQLException, IOException {

		Statement st = conn.createStatement();
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
