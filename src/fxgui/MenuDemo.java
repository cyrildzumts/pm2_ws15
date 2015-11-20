package fxgui;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
//import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MenuDemo extends Application {
	private MenuBar barMenu;
	private Menu menu;

	public static void main(String [] args){
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		Menu file = new Menu("File");
		Menu camera = new Menu("Camera");
		Menu alarm = new Menu("Alarm");
		barMenu = new MenuBar(file, camera,alarm);
		MenuItem tonItem = new MenuItem("Ton");
		CheckMenuItem alarmAus = new CheckMenuItem("Alarm Aus");
		alarmAus.setSelected(true);
		Menu plane = new Menu("Plane");
		MenuItem item1 = new MenuItem("Item1");
		MenuItem item2 = new MenuItem("Item2");
		MenuItem item3 = new MenuItem("Item3");
		plane.getItems().addAll(item1,item2,item3);
		alarm.getItems().addAll(tonItem,alarmAus, plane);
		Scene scene = new Scene(barMenu, 300,400);
		stage.setScene(scene);
		stage.setTitle("Menu Demo");
		stage.show();
		
	}
	

}
