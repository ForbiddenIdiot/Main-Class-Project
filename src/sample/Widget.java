/*
	* Angel Molina
	* 10/26/19
	* Class created to test its parent class, Product
	*/


package sample;

// Reused from H2 Template
import java.io.IOException;
import java.sql.*;

public class Widget extends Product {
		private Connection con = null;

		public Widget(String name)  throws SQLException { // constructor
				super(name);
				con = DriverManager.getConnection("jdbc:h2:C:/Users/dell main/IdeaProjects/Main-Class-Project/lib");
		} // end constructor

		/* TEST- Imported from ProductManager */

		public void createEmployee() {
				try {
						Statement stmt = con.createStatement();
						stmt.execute("CREATE TABLE IF NOT EXISTS employee(" +
							"uid int primary key," +
							"name varchar(255));" );
				} catch (SQLException e) {
						sqlExceptionHandler(e);
				}
		} // end method createEmployee

		public void insertProd(String iQuery, String[] insertValues) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(iQuery);
				pstmt.setInt(1, Integer.parseInt(insertValues[0]));
				pstmt.setString(2, insertValues[1]);
				pstmt.executeUpdate();
		} // end method insertProd

		public void selectAll() {
				ResultSet rs = null;

				try {
						Statement stmt = con.createStatement();
						rs = stmt.executeQuery("SELECT * FROM employee;");

						while(rs.next()) {
								System.out.printf("uID = %d%n", rs.getInt("uid"));
								System.out.printf("Name = %s%n", rs.getString("name"));
						}

				} catch (SQLException e) {
						sqlExceptionHandler(e);
				}
		} // end method selectAll()

		public void closeCon() {
				try {
						con.close();
				} catch (SQLException e) {
						sqlExceptionHandler(e);
				}
		} // end method closeCon

		public void sqlExceptionHandler(SQLException error) {
				// add logging, could make into a wrapper function
				System.out.println("Standard Failure: " + error.getMessage());
		} // end method sqlExceptionHandler

		/********************* // END TEST
		 */

	/*	ProductManager pm = new ProductManager();
        pm.createEmployee();
        pm.selectAll();

		// Finally let's insert some data
		// Will use stringBuilder or similar in video to build/map this
		// Main point for both: USE PLACEHOLDERS
		String insertQuery = "INSERT INTO EMPLOYEE " +
			"(uid, name)" +
			" VALUES (?, ?)";
		String[] itemp = {"370", "help me"};

        pm.insertProd(insertQuery, itemp);
        pm.selectAll();


		// And close our connection at end
        pm.closeCon();*/
}
