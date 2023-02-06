import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACBMenu {
	private int option;

	public ACBMenu() {
		super();
	}

	public int mainMenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {

			System.out.println(" \nMENU PRINCIPAL \n");

			System.out.println("Escull una opció: ");
			System.out.println("1. Crea las tablas en la BD");
			System.out.println("2. Insertar Info en las Tablas");
			System.out.println("3. Muestra la información de las tablas");
			System.out.println("4. Eliminar tablas");
			System.out.println("5. Modificar tablas");
			System.out.println("6. Eliminar Info de Tablas");
			System.out.println("7. Modificat Info de las tablas");
			System.out.println("8. Mostrar Tablas");
			System.out.println("9. Sortir");
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("valor no vàlid");
				e.printStackTrace();

			}

		} while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7
				&& option != 8 && option != 9 && option != 10);

		return option;
	}



}
