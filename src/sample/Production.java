/*
	* Angel Molina
	* 10/26/19
	* Records data about items and saves it to a table
	*/

package sample;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Production {

		private Connection con = null;

		int currID = 0;
		String manufacturedOn;

	public Production() throws SQLException {

			//con = DriverManager.getConnection("jdbc:h2:C:/Users/dell main/IdeaProjects/Main-Class-Project/lib");
		con = DriverManager.getConnection("jdbc:h2:C:/Windows.old.000/Users/dell main/IdeaProjects/Main-Class-Project/lib");

			Scanner scanner = new Scanner(System.in);

			// Below code is used ONLY for testing temporary Widget class
			System.out.println("Please enter a quantity: ");
			int quantity = scanner.nextInt();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			manufacturedOn = dateFormat.format(date);
			System.out.println("Manufactured on " + manufacturedOn);

	} // end constructor

		public void createTable() {
			// create production table
			try {
						Statement stmt = con.createStatement();
						// DROP TABLE query is for resetting Production Table each time the program runs
						stmt.execute("DROP TABLE production;");
						// SQL code to create new table
						stmt.execute("CREATE TABLE IF NOT EXISTS production(" +
							"id int primary key, quantity int, manufacturedOn text);" );
			} catch (SQLException e) {
						sqlExceptionHandler(e);
			}

			// create employee table
			try {
				Statement stmt = con.createStatement();
				// DROP TABLE query is for resetting Production Table each time the program runs
				stmt.execute("DROP TABLE employee;");
				// SQL code to create new table
				stmt.execute("CREATE TABLE IF NOT EXISTS employee(" +
						"id int primary key, quantity int, manufacturedOn text);" );
			} catch (SQLException e) {
				sqlExceptionHandler(e);
			}

		} // end method createTable

		public void insertProd(String iQuery, String[] insertValues) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(iQuery);
				pstmt.setInt(1, Integer.parseInt(insertValues[0]));
				pstmt.setInt(2, Integer.parseInt(insertValues[1]));
				pstmt.setString(3, insertValues[2]);
				pstmt.executeUpdate();
		} // end method insertProd

		public void selectAll() {
				ResultSet rs = null;

				try {
						Statement stmt = con.createStatement();
						rs = stmt.executeQuery("SELECT * FROM production;");

						while(rs.next()) {
								System.out.printf("Transaction ID: %d%n", rs.getInt("id"));
								System.out.printf("Quantity: %s%n", rs.getInt("quantity"));
								System.out.printf("Date of manufacture: %s%n",
									rs.getString("manufacturedOn"));
						}

				} catch (SQLException e) {
						sqlExceptionHandler(e);
				}
		} // end method selectAll()

		public void sqlExceptionHandler(SQLException error) {
				// add logging, could make into a wrapper function
				System.out.println("Standard Failure: " + error.getMessage());
		}

		public String dataEntry (int quantity) throws SQLException {
				String insertQuery = "INSERT INTO PRODUCTION " +
					"(id, quantity, manufacturedOn)" +
					" VALUES (?, ?, ?)";
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				manufacturedOn = dateFormat.format(date);
				String[] itemp = {Integer.toString(currID++), Integer.toString(quantity), manufacturedOn};

				createTable();
				insertProd(insertQuery, itemp);
				selectAll();

				return "\nTransaction ID: " + Integer.toString(currID)
					+ "\nQuantity produced: " + Integer.toString(quantity)
					+ "\nManufactured on: " + manufacturedOn;
		}



} // end class Production
