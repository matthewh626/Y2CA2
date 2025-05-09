package com.ca2.routefinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Map {
	ArrayList<Stop> stops = new ArrayList<Stop>();
	
	public Map(String filePath) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			br.readLine(); // this is to toss the line with the column titles
			while ((line = br.readLine()) != null) {																			//this loop reads a line from the
		        String[] values = line.split(",");																				//csv file, splits it at commas
		        if (!stopExsists(values[0])) addStop(values[0]);																//checks if both the start and 
		        if (!stopExsists(values[1])) addStop(values[1]);																//destination are existing stops
		        getStop(values[0]).addLink(getStop(values[1]), 1, Integer.parseInt(values[2]),Integer.parseInt(values[4]));		//and adds them if not, it then 
			}																													//adds a link from the first to
			br.close();																											//the second with a default
		} catch (Exception e) {e.printStackTrace();}																			//weight of 1.
		
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
				res = res || s.getName().equalsIgnoreCase(name);
			}
			return res;
		}
		
	}// end of Path Class
	
	public Stop getStop(String name) {
		for (Stop s : stops) {
			if (s.getName().equalsIgnoreCase(name)) return s;
		}
		return null;
	}
	
	public Stop[] getAllStops() {
		return (Stop[]) stops.toArray();
	}
	
	public boolean stopExsists(String name) {
		for (Stop s : stops) {
			if (s.getName().equalsIgnoreCase(name)) return true;
		}
		return false;
	}
	
	public boolean addStop(String name) {
		return stops.add(new Stop(name));
	}
	
	public boolean remStop(String name) {
		return stops.remove(getStop(name));
	}
	
	public Path findDFSPath(Stop origin, Stop destination) throws DestionationUnreachableException{
		if (origin.isLinked(destination)) return (new Path(new Stop[]{origin, destination})); // early return point for if origin and destination are adjacent
		ArrayList<Stop> candidate = new ArrayList<Stop>();
		ArrayList<Integer> tree = new ArrayList<Integer>();
		int depth = 0; // this is counting back from the end of the array list
		candidate.add(origin);
		while (!candidate.getLast().isLinked(destination)) {
		while (candidate.getLast().hasLinks()) { // this loop does the main plunge
			tree.add(0);
			candidate.add(candidate.getLast().getLink(tree.get(depth)).dest);
			depth++;
			if (candidate.getLast().isLinked(destination)) return new Path(candidate.toArray(new Stop[candidate.size()])); //early return for if first plunge hits the destination
		}
			candidate.removeLast(); //these three take a step back
			tree.removeLast();
			depth--;
			if(tree.get(depth)==candidate.getLast().links.size()-1) { //if the current stop has all of its links checked take a second step back
				candidate.removeLast(); 
				tree.removeLast();
				depth--;
		}
			else tree.set(depth, tree.get(depth)+1);
		}
		
		System.out.println("Warning: pathfinder is returning null, this code should never be reached");
		return null;
	}
	
	public Path findDFSPathAvoiding(Stop origin, Stop destionation, Stop[] toAvoid) throws DestionationUnreachableException{
		return null;
	}
	
	public Path findDFSPathHitting(Stop origin, Stop destionation, Stop[] toAvoid, Stop[] toHit) throws DestionationUnreachableException{
		return null;
		
	}
	
	public Path findBFSPath(Stop origin, Stop destionation) throws DestionationUnreachableException {
		return null;
	}
	
	public Path findBFSPathAvoiding(Stop origin, Stop destionation, Stop[] toAvoid) throws DestionationUnreachableException{
		return null;
	}
	
	public Path findBFSPathHitting(Stop origin, Stop destionation,Stop[] toAvoid, Stop[] toHit) throws DestionationUnreachableException{
		return null;
		
	}

	
}// end of Map Class

