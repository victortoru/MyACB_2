import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class ACBMain {

	public static void main(String[] args) throws IOException, SQLException, ParseException {
		ACBMenu menu = new ACBMenu();
		
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection c = connectionFactory.connect();
		Comandos_bbdd comandos = new Comandos_bbdd();

		int option = menu.mainMenu();
		while (option > 0 && option < 12) {
			switch (option) {
			case 1:
				comandos.crea_tabla();
				break;

			case 2:
				// dbaccessor.mostraRevistes();
				break;

			case 3:
				// dbaccessor.mostraRevistesArticlesAutors();
				break;

			case 4:
				// dbaccessor.altaAutor();
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
