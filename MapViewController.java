package com.ca2.routefinder;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MapViewController
{// controller:fx of mapView.fxml
    public static Map map;
    public AnchorPane staticMapView, dynamicMapView;
    public Map.Path currentPath;
    @FXML
    public ImageView mapView;
    @FXML
    public ToggleButton searchMode; // selected = depthfirst, deselcted = breadthfirst


    void printPath(){ // draws Path output onto mapView

    }
    void getPath(){ // gets new Path from Map using currently set parameters
        if(searchMode.isSelected()){ // DFS

        }
        else{ // BFS

        }
    }
    void getParameters(){ // get user path settings, to be used when getting Path

    }
    // OnClick/Interact Methods \/\/\/\/
    @FXML
    void updateView() // update all UI and input fields with type validation
    {

    }
}
