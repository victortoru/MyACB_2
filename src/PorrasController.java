import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PorrasController {

    private Connection connection;

    public PorrasController(Connection connection) {
        this.connection = connection;
    }

    public void insertPorras() {

        CSVController csvController = new CSVController();
        String sql = "INSERT INTO Porras(nombre, nivel, descripcion, dano, dano_probabilidad, estadistica, encontrar) VALUES (?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = connection.prepareStatement(sql);
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
    public void showPorras() throws SQLException, IOException {

        Statement st = connection.createStatement();
        ResultSet rs;

        rs = st.executeQuery("SELECT * FROM Porras");
        while (rs.next()) {
            System.out.println(	"Nombre: " + rs.getString("nombre") + " " +
                    "Nivel: " + rs.getString("nivel") + " " +
                    "Descripción: " + rs.getString("descripcion") + " " +
                    "Daño: " + rs.getString("dano") + " " +
                    "Probabilidad de daño: " + rs.getString("dano_probabilidad") + " " +
                    "Estadística: " + rs.getString("estadistica") + " " +
                    "Encontrar: " + rs.getString("encontrar"));
        }

        rs.close();
        st.close();
    }
}
