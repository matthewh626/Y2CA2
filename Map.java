package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Map {
	ArrayList<Stop> stops = new ArrayList<Stop>();
	
	public Map(String filePath) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine()) != null) {											//this loop reads a line from the
		        String[] values = line.split(",");												//csv file, splits it at commas
		        if (!stopExsists(values[0])) addStop(values[0]);								//checks if both the start and 
		        if (!stopExsists(values[1])) addStop(values[1]);								//destination are existing stops
		        getStop(values[0]).addLink(getStop(values[1]), 1, Integer.parseInt(values[2]));	//and adds them if not, it then 
			}																					//adds a link from the first to
			br.close();																			//the second with a default
		} catch (Exception e) {e.printStackTrace();}											//weight of 1.
		
	}
	
	public class Path{
		Stop[] stops;
		
		Path (Stop[] stops) {
			this.stops = stops;
		}
		
		public int getTotalWeight() {
			int res = 0;
			for (int i = 0; i < stops.length -1; i++) {
				res += stops[i].getWeight(stops[i+1]); // this is done like this because Stop.getWeight gives the weight for the 
			}										   // link from the parent stop to the stop passed in, only works for direct
			return res;								   // links, for multi step weights a path must be generated.
		}
		
		public boolean passes(Stop s) {
			return Arrays.asList(stops).contains(s);
		}
		public boolean passes(String name) {
			boolean res = false;
			for (Stop s : stops) {
				res = res || s.getName()==name;
			}
			return res;
		}
		
	}// end of Path Class
	
	public Stop getStop(String name) {
		for (Stop s : stops) {
			if (s.getName()==name) return s;
		}
		return null;
	}
	
	public Stop[] getAllStops() {
		return (Stop[]) stops.toArray();
	}
	
	public boolean stopExsists(String name) {
		for (Stop s : stops) {
			if (s.getName()==name) return true;
		}
		return false;
	}
	
	public boolean addStop(String name) {
		return stops.add(new Stop(name));
	}
	
	public boolean remStop(String name) {
		return stops.remove(getStop(name));
	}
	
	public Path findDFSPath(Stop origin, Stop destionation) throws DestionationUnreachableException{
		return null;
	}
	
	public Path findDFSPathAvoiding(Stop origin, Stop destionation, Stop[] toAvoid) throws DestionationUnreachableException{
		return null;
	}
	
	public Path findBFSPath(Stop origin, Stop destionation) throws DestionationUnreachableException {
		return null;
	}
	
	public Path findBFSPathAvoiding(Stop origin, Stop destionation, Stop[] toAvoid) throws DestionationUnreachableException{
		return null;
	}
	
}// end of Map Class

