package com.ca2.routefinder;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class MapListController
{
    public ComboBox<String> mapChoiceList; // a choicebox containing a string representing each station.
    // will be filled on instantiation and used to select a stop for either start, destination, or intermediate stops
    public void fillStops(){
        mapChoiceList.getItems().clear();
        String[] names = MapViewController.map.getAllStopNames();
        mapChoiceList.getItems().addAll(names);
    }
    public void initialize(){
        fillStops();
    }
    public void updateView(){
        MapViewController.MVController.updateView();
    }
}
