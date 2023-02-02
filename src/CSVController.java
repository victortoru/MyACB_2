
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CSVController {


	// Java code to illustrate reading a
// CSV file line by line
	public ArrayList<ArrayList<String>> readDataLineByLine(String file)
	{

		ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();

		try {
			// Create an object of filereader
			// class with CSV file as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvReader object passing
			// file reader as a parameter
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;

			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				ArrayList<String> fila = new ArrayList<String>();
				for (String cell : nextRecord) {
					fila.add(cell);
//					System.out.print(cell + "\t");
				}
				datos.add(fila);
//				System.out.println();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return datos;
	}
}
