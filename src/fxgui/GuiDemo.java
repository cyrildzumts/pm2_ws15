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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author Cyrille Ngassam Nkwenga
 * 
 * JavaFx Demo.
 * Description :
 * To compile and run this code JavaFx Jar needs first to be installed
 * and the project on Eclipse needs to be set with the appropriate path to that
 * package.
 * This code is really just a dummy JavaFx try of my.
 * There are no Listeners to track events that might happen when 
 * clicking on some Buttons or adding text on any text area.
 * This code implements a Form  for adding a new course into
 * a fictive database ( which of course is not implemented.
 * setOnAction(...) is your way to implement a Listener when the button
 * is clicked for example.
 * 
 * Clicking either on Cancel or on Add will quit the application
 *
 */
public class GuiDemo extends Application {
	
	private VBox layout;
	//private Group core;
	private Scene scene;
	private Button validate;
	private Button cancel;
	private List<String> addItemsList;

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		addItemsList = Arrays.asList("Course", "Labor", "Homework", "Exam", "Notice");
		layout = new VBox(10);
		layout.setPadding(new Insets(20));
		layout.setStyle("-fx-background: #3FB8B3");
		Text title = new Text("Add Course");
		layout.getChildren().add(title);
		// Dropdown Menu to choose the Item to add.
		VBox dropMenuLayout = new VBox(10, new Label("Choose what you want to add."));
		ChoiceBox<String> dropmenu = new ChoiceBox<>();
		dropmenu.getItems().addAll(addItemsList);
		dropMenuLayout.getChildren().add(dropmenu);
		dropmenu.setStyle("-fx-background-color: #A9C8D0");
		
		
		// Course Title Entry
		VBox titleLayout = new VBox(10);
		titleLayout.getChildren().add(new Label("Title"));
		titleLayout.getChildren().add(new TextField("Enter the title here..."));
		// Professor Entry
		VBox professorLayout = new VBox(10);
		professorLayout.getChildren().add(new Label("Professor"));
		professorLayout.getChildren().add(new TextField("Professor firstname"));
		professorLayout.getChildren().add(new TextField("Professor lastname"));
		
		// Calender Entry
		String itemStartEndDate = "Start: 08:15 - End: 11:30";
		String [] dayLabels = {"Mo", "Tu", "We", "Th", "Fr"};
		VBox coursePlanLayout = new VBox(5); 
		coursePlanLayout.getChildren().add(new Label("Calender"));
		for(int i = 0; i < dayLabels.length; i++){
			coursePlanLayout.getChildren().add(new HBox(10, new CheckBox(dayLabels[i]), new Label(itemStartEndDate)));
		}
		
		// Description Entry
		VBox descriptionLayout = new VBox(10);
		descriptionLayout.getChildren().add(new Label ("Description"));
		descriptionLayout.getChildren().add(new TextArea (" Enter the Course's Description here"));
		validate = new Button("Add");
		cancel = new Button("Cancel");
		cancel.setStyle("-fx-base: #E84144");
		validate.setStyle("-fx-base: #3FB8B3");
		HBox buttons = new HBox(20, cancel, validate);
		cancel.setOnAction(e-> Platform.exit());
		validate.setOnAction(e-> Platform.exit());
		layout.getChildren().addAll(dropMenuLayout,titleLayout,professorLayout,coursePlanLayout,descriptionLayout, buttons);

		scene = new Scene(layout, 300, 600);
		stage.setScene(scene);
		stage.setTitle("Add Course Form");
		stage.show();
		
	}

}
