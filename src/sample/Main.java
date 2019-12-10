/*
* Angel Molina
* 9/30/19
* Contains code for Production Line Database Program (Class project)
*/

package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.sql.SQLException;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {
	public static void main(String[] args) throws SQLException {

			ArrayList<Object> objectList = new ArrayList<>();
			List<String> productNames = new ArrayList<>();

            // Test Driver Class
			Driver.testAudioPlayer(objectList, "Walkman");
			Driver.testAudioPlayer(objectList, "Apple iPod");
			Driver.testAudioPlayer(objectList, "MP3");

			//  Application.launch(args); // Test Production Class

			//widget.closeCon();

			//  Test Screen Class
			Driver.testScreen();

			// Test MoviePlayer Class
			Driver.testMoviePlayer(objectList, "Blu-Ray");
			Driver.testMoviePlayer(objectList, "Home Theater");
			Driver.testMoviePlayer(objectList, "MoviMagic");

			// Add product names to a list
            for (Object obj : objectList) {
            	if (obj instanceof Product) {
                	productNames.add(((Product) obj).getName());
                    }
                }

            // Sort products by name
			Collections.sort(productNames);

            // Print sorted list of product names
			System.out.print("Product name list: ");
               System.out.println(productNames);

            // Test EmployeeInfo class
            System.out.println("\n1st Employee:");
            Driver.testEmployee(objectList);
            System.out.println("\n2nd Employee:");
            Driver.testEmployee(objectList);
            System.out.println("\n3rd Employee:");
            Driver.testEmployee(objectList);

            // Print Object collection
            Driver.print(objectList);
		}

		@Override
		public void start(Stage primaryStage) throws SQLException {

			Production production = new Production();
			ArrayList<String> productionRun = new ArrayList<>();

			primaryStage.setTitle("Final Project"); // Title of program
			Group root = new Group();
			Scene scene = new Scene(root, 400, 250, Color.WHITE);

			ComboBox cb = new ComboBox(); // Create ComboBox
			cb.getItems().addAll(ItemType.values());
			// Create a tile pane
			TilePane tilePane = new TilePane(cb);

			TabPane tabPane = new TabPane();

			BorderPane borderPane = new BorderPane();

			TextField tfQuantity = new TextField("1");
			Button prodButton = new Button("OK");
			Text prodRunText = new Text("");

			for (int i = 0; i < 5; i++) {
				VBox vbox = new VBox();
				Tab tab = new Tab(); // Create new tab
				if (i == 0) {
					tab.setText("Production");
					vbox.getChildren().add(new Label("Please enter a quantity: ")); // Create Label
					vbox.getChildren().add(tfQuantity); // Create TextField
					vbox.getChildren().add(prodButton);
					vbox.getChildren().add(prodRunText);
					} else {
						tab.setText("Tab" + i); // Set tab text
						vbox.getChildren().add(new Label("Tab" + i + " ")); // Create Label
						vbox.getChildren().add(new Button("Press Me!")); // Create Button
					}

					vbox.setAlignment(Pos.CENTER);
					tab.setContent(vbox);
					tabPane.getTabs().add(tab);
				}
				// bind to take available space
				borderPane.prefHeightProperty().bind(scene.heightProperty());
				borderPane.prefWidthProperty().bind(scene.widthProperty());

				borderPane.setCenter(tabPane);
				borderPane.setTop(tilePane);
				root.getChildren().add(borderPane);
				//root.getChildren().add(tilePane);
				primaryStage.setScene(scene);
				primaryStage.show();

				// When user clicks on OK button,
				// program will store quanity of product
				// entered by the user into the database
				// The program will then display
				// the full record
				// of products by date and quantity
				prodButton.setOnAction(e -> {
				try {
					String de = production.dataEntry(Integer.parseInt(tfQuantity.getText()));
					productionRun.add(de);
					Collections.sort(productionRun, Collections.reverseOrder());
					prodRunText.setText(productionRun.toString());
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				});

		} // end start()

} // end class Main

// Driver class for AudioPlayer
class Driver {

		public static void testAudioPlayer(ArrayList<Object> prodList,
										   String name) {
			System.out.println("[Audio Player Test]");
				// instantiate AudioPlayer
				AudioPlayer aPlayer = new AudioPlayer(name, "Apple",
					"160 Kbps");
				// print AudioPlayer object details
				System.out.println(aPlayer.toString());
				// test AudioPlayer functions
				aPlayer.play();
				aPlayer.stop();
				aPlayer.previous();
				aPlayer.next();
				System.out.println("[End Audio Player Test]");
				System.out.println("");

				addToobjectList(prodList, aPlayer);
		} // end method testAudioPlayer

		public static void testScreen() {
				System.out.println("[Screen Test]");
				// instantiate Screen
				Screen screen = new Screen("1366 x 768", 60, 10);
				System.out.println(screen.toString());
				System.out.println("[End Screen Test]");

		} // end method testScreen

		public static void testMoviePlayer(ArrayList<Object> prodList, String name) {
				System.out.println("[Movie Player Test]");
				// instantiate MoviePlayer
				MoviePlayer mp = new MoviePlayer(name, "Sony",
					new Screen("1366 x 768", 60, 10),
					MonitorType.LED);
				System.out.println(mp.toString());
				mp.play();
				mp.stop();
				mp.previous();
				mp.next();
				System.out.println("[End MoviePlayer Test]");
				System.out.println("");

				addToobjectList(prodList, mp);
		} // end method testScreen

	public static void addToobjectList (ArrayList<Object> objectList,
										 Object obj) {
			objectList.add(obj);
	}

	public static void testEmployee (ArrayList<Object> objList) {
		System.out.println("[Employee Test]");
		// instantiate EmployeeInfo
		EmployeeInfo ei = new EmployeeInfo();
		System.out.println("Welcome to the company, "
				+ ei.getName() + "!");
		System.out.println(ei.getName() + "'s Dept ID in reverse: "
				+ ei.reverseString(ei.getDeptId()));
		System.out.println(ei.toString());
		System.out.println("[End Employee Test]");

		addToobjectList(objList, ei);
	} // end method testEmployee

    public static void print(ArrayList<Object> objList) {
		    System.out.print("[Full ArrayList of products and employees:]");
		    System.out.println("\n" + objList);
    }
}	// end class Driver

