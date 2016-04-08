package it.polito.tdp.lab3.controller;
	
import it.polito.tdp.lab3.model.Segreteria;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SegreteriaStudenti.fxml"));
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Segreteria seg = new Segreteria();
			SegreteriaStudentiController controller =  loader.getController();
			controller.setModel(seg);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
