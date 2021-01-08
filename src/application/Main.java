package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Stage window;

	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root =FXMLLoader.load(getClass().getResource("fxml/Home.fxml"));
			Parent root1 =FXMLLoader.load(getClass().getResource("fxml/Login.fxml"));
			Parent root2 =FXMLLoader.load(getClass().getResource("fxml/ManageEmploye.fxml"));
			Scene scene = new Scene(root,680,700);
			Scene scene1 = new Scene(root1,400,250);
			Scene scene2 = new Scene(root2,680,700);
			scene.getStylesheets().add(getClass().getResource("css/application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
