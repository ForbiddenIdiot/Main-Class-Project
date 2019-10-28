/*
	* Angel Molina
	* 9/30/19
	* Contains code for Production Line Database Program (Class project)
	*/

package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Reused from H2 Template
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {
		public static void main(String[] args) throws SQLException {
				/* Create instance of Widget class to test its parent class Product
				Widget widget = new Widget("widget");
				widget.createEmployee();
				widget.selectAll();


				String insertQuery = "INSERT INTO EMPLOYEE " +
					"(uid, name)" +
					" VALUES (?, ?)";
				String[] itemp = {"101", widget.getName()};

				widget.insertProd(insertQuery, itemp);*/

				Driver.testAudioPlayer(); // Test Driver Class

				Application.launch(args); // Test Production Class

				// widget.closeCon();
		}

		@Override
		public void start(Stage primaryStage) throws SQLException {

				Production production = new Production();
				ArrayList<String> productionRun = new ArrayList<>();

				primaryStage.setTitle("Final Project"); // Title of program
				Group root = new Group();
				Scene scene = new Scene(root, 400, 250, Color.WHITE);

				String itemTypes[] = {"AU", "VI", "AM", "VM"};
				ComboBox cb = new ComboBox(FXCollections
					.observableArrayList(itemTypes)); // Create ComboBox
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
								prodRunText.setText(productionRun.toString());
						} catch (SQLException ex) {
								ex.printStackTrace();
						}
				});

		} // end start()

		enum ItemType {
				AU, VI, AM, VM
		/*
		AU - Audio
		VI - Visual
		AM - AudioMobile
		VM - VisualMobile
		 */
		}

} // end class Main

// Driver class for AudioPlayer
class Driver {
		public static void testAudioPlayer() {
				// instantiate AudioPlayer
				AudioPlayer aPlayer = new AudioPlayer("iPod", "Apple",
					"160 Kbps");
				// print AudioPlayer object details
				System.out.println(aPlayer.toString());
				// test AudioPlayer functions
				aPlayer.play();
				aPlayer.stop();
				aPlayer.previous();
				aPlayer.next();
		}
}	// end class Driver