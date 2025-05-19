package com.ca2.routefinder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
	public static Stage mainStage;
	public static Scene mapView, fullMapView;
	@Override
	public void start(Stage stage) throws IOException
	{
		mainStage = stage;
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mapView.fxml")); // to be duplicated for each scene
		mapView = new Scene(fxmlLoader.load());
		fxmlLoader = new FXMLLoader(Main.class.getResource("fullMapView.fxml"));
		fullMapView = new Scene(fxmlLoader.load());
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
//done• Generate any single valid route between two stations = 10%
//done• Generate multiple valid route permutations using DFS = 10%
//todo• Shortest route using Dijkstra’s algorithm = 10%
//todo• Shortest route with line change penalties using Dijkstra’s algorithm = 10%
//done• Illustrating routes on map = 15%
//todo• Waypoint support = 5%
//done* Avoiding specified stations = 5%
//done• JavaFX GUI = 10%
//done• JUnit testing = 5%
//done• JMH benchmarking of key methods = 5%
//done• General (overall completeness, structure, commenting, logic, etc.) = 5%
