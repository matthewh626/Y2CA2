package com.ca2.routefinder;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.BufferedReader;
import java.io.FileReader;

public class FullMapViewController
{
    public static FullMapViewController FMVController;
    @FXML
    AnchorPane view;

    public void paintPath(Map.Path path)
    {
        System.out.println("setting up map");
        // values: [0] - name [1,2] - X,Y
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/ca2/routefinder/stopPositions.csv"));
            String line;
            br.readLine(); // this is to toss the line with the column titles
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println();
                if (path.passes(values[0])) {
                    Circle s = new Circle(5, Paint.valueOf("White"));
                    s.setId(values[0].replace(" ", ""));

                    s.setLayoutX(Double.parseDouble(values[1])+8);
                    s.setLayoutY(Double.parseDouble(values[2])+8);
                    view.getChildren().add(s);
                }
            }
            Stop[] stops = path.stops;
            Node start, end; // start and end points of each line
            for (int i = 0; i < stops.length; i++) {
                if(i+1 == stops.length) break; // last stop reached, stop
                System.out.println("#"+stops[i+1].name.replace(" ", ""));
                System.out.println(stops[i+1].name);
                start = view.getScene().lookup("#"+stops[i].name.replace(" ", ""));
                end = view.getScene().lookup("#"+stops[i+1].name.replace(" ", ""));

                Line s = new Line(start.getLayoutX(), start.getLayoutY(), end.getLayoutX(), end.getLayoutY());
                s.setFill(Paint.valueOf("Blue"));
                s.setStrokeWidth(3);
                view.getChildren().add(s);
            }
            br.close();
        } catch (Exception e) {e.printStackTrace();}
    }
    public void printAllStops()
    {
        System.out.println("setting up map");
        // values: [0] - name [1,2] - X,Y
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/ca2/routefinder/stopPositions.csv"));
            String line;
            br.readLine(); // this is to toss the line with the column titles
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (MapViewController.map.stopExsists(values[0])) {
                    Circle s = new Circle(5, Paint.valueOf("White"));
                    s.setId(values[0]);
                    s.setLayoutX(Double.parseDouble(values[1])+8);
                    s.setLayoutY(Double.parseDouble(values[2])+8);
                    view.getChildren().add(s);
                }
            }
            br.close();
        } catch (Exception e) {e.printStackTrace();}
    }
    @FXML
    public void openRoutePlanner()
    {
        Main.mainStage.setScene(Main.mapView);
    }
    public void initialize()
    {
        FMVController = this;
    }
}
