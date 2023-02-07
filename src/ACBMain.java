import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class ACBMain {

	public static void main(String[] args) throws IOException, SQLException, ParseException {
		ACBMenu menu = new ACBMenu();
		
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection c = connectionFactory.connect();

		DBController dbController = new DBController(c);
		DagaController dagaController = new DagaController(c);

		int option = menu.mainMenu();
		while (option > 0 && option < 12) {
			switch (option) {
			case 1:
				dbController.dropTables();
				dbController.createTables();
				break;

			case 2:
				dagaController.insertDagas();
				break;

			case 3:
				dagaController.showDagas();
				break;

			case 4:
				dbController.dropTableDaga();
				break;

			case 5:
				// dbaccessor.altaRevista();
				break;

			case 6:
				// dbaccessor.altaArticle();
				break;

			case 7:
				// dbaccessor.actualitzarTitolRevistes(conn);
				break;

			case 8:
				// dbaccessor.afegeixArticleARevista(conn);
				break;

			case 9:
				// dbaccessor.desassignaArticleARevista(conn);
				break;

			case 10:
				// dbaccessor.carregaAutors(conn);
				break;

			case 11:
				// dbaccessor.sortir();
				break;

			default:
				System.out.println("Introdueixi una de les opcions anteriors");
				break;

			}
			option = menu.mainMenu();
		}

	}

}
