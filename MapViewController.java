package com.ca2.routefinder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapViewController
{// controller:fx of mapView.fxml
    public static Map map = new Map("src/main/java/com/ca2/routefinder/vienna_subway.csv");
    public static MapViewController MVController;
    public AnchorPane staticMapView, dynamicMapView;
    public Map.Path currentPath;
    public Stop start, destination;
    public ArrayList<Stop> selectedStops = new ArrayList<Stop>();
    @FXML
    public ImageView mapView;
    @FXML
    public TextArea pathInfo;
    @FXML
    public ToggleButton searchMode, pass, avoid; // selected = depthfirst, deselcted = breadthfirst
    @FXML
    public Button fullMapView;
    @FXML
    public ComboBox<String> startBox, destinationBox, stop1, stop2, stop3;


    void printPath(){ // draws Path output onto mapView

    }
    public void findPath()throws DestionationUnreachableException{ // gets new Path from Map using currently set parameters
        updateView();

        if(searchMode.isSelected()){ // DFS
            if(pass.isSelected()) // hit selected stops
                currentPath = map.findDFSPathHitting(start,destination,new Stop[] {null},getSelectedStops());
            else if(avoid.isSelected()) // avoid selected stops
                currentPath = map.findDFSPathAvoiding(start,destination,getSelectedStops());
            else // otherwise, parameterless
                currentPath = map.findDFSPath(start,destination);
        }
        else{ // BFS
            if(pass.isSelected()) // hit selected stops
                currentPath = map.findBFSPathHitting(start,destination,new Stop[] {null},getSelectedStops());
            else if(avoid.isSelected()) // avoid selected stops
                currentPath = map.findBFSPathAvoiding(start,destination,getSelectedStops());
            else // otherwise, parameterless
                currentPath = map.findBFSPath(start,destination);
        }
        if (currentPath != null) {
            fullMapView.setDisable(false);
            pathInfo.setText(String.valueOf(currentPath.toString()));
        }
        else{
            fullMapView.setDisable(true);
        }
    }
    void getParameters(){ // get user path settings, to be used when getting Path

    }
    // OnClick/Interact Methods \/\/\/\/
    @FXML
    public void updateView() // update all UI and input fields with type validation
    {
        // toggleButton change
        if(searchMode.isSelected())
            searchMode.setText("Depth-First");
        else
            searchMode.setText("Breadth-First");

        // set stops; start, dest, and selected
        if(map.getStop(startBox.getSelectionModel().getSelectedItem()) != null){
            start = map.getStop(startBox.getSelectionModel().getSelectedItem());
        }
        if(map.getStop(destinationBox.getSelectionModel().getSelectedItem()) != null){
            destination = map.getStop(destinationBox.getSelectionModel().getSelectedItem());
        }
        selectedStops.clear(); // update and add stops in order of selection
        if(stop1.getSelectionModel().getSelectedItem() != null) selectedStops.add(map.getStop(stop1.getSelectionModel().getSelectedItem()));
        if(stop2.getSelectionModel().getSelectedItem() != null) selectedStops.add(map.getStop(stop2.getSelectionModel().getSelectedItem()));
        if(stop3.getSelectionModel().getSelectedItem() != null) selectedStops.add(map.getStop(stop3.getSelectionModel().getSelectedItem()));
    }
    Stop[] getSelectedStops()
    {
        return selectedStops.toArray(Stop[]::new);
    }
    public void initialize() // when new controller instance is created, it becomes PVController
    {
        MVController = this;
    }
    @FXML
    public void openFullMapView() throws IOException{
        Main.mainStage.setScene(Main.fullMapView);
        FullMapViewController.FMVController.paintPath(currentPath);
    }
}
