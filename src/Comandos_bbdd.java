import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public class Comandos_bbdd {
    String dbURL="jdbc:postgresql://192.168.22.140:5432/stardew";
    Connection conn;

    {
        try {
            conn = DriverManager.getConnection( dbURL, "victor","password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Statement st;

    {
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void crea_tabla() throws IOException {
       try (BufferedReader br = new BufferedReader(new FileReader("src/schema.sql")))
       {
           st.execute(br.lines().collect(Collectors.joining(" \n")));
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    public void eliminar_tabla() throws IOException {new FileReader("src/schema.sql")))
        {
            st.execute(br.lines().collect(Collectors.joining(" \n")));
        }

    }
}
