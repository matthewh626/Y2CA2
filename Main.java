package com.ca2.routefinder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
	public static Stage mainStage;
	public static Scene mapView;
	@Override
	public void start(Stage stage) throws IOException
	{
		mainStage = stage;
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mapView.fxml")); // to be duplicated for each scene
		mapView = new Scene(fxmlLoader.load());
		// another view may be added
		stage.setTitle("Route Finder");
		stage.setScene(mapView);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
	
}//lower bound of class


// --- MARKING SCHEME ---
//done• Custom graph data structure/classes = 10% Done in Map and its subclasses
//todo• Generate any single valid route between two stations = 10%
//todo• Generate multiple valid route permutations using DFS = 10%
//todo• Shortest route using Dijkstra’s algorithm = 10%
//todo• Shortest route with line change penalties using Dijkstra’s algorithm = 10%
//todo• Illustrating routes on map = 15%
//todo• Waypoint support = 5%
//todo• Avoiding specified stations = 5%
//todo• JavaFX GUI = 10%
//todo• JUnit testing = 5%
//todo• JMH benchmarking of key methods = 5%
//todo• General (overall completeness, structure, commenting, logic, etc.) = 5%
