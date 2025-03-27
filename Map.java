package application;

import java.util.ArrayList;

public class Map {
	ArrayList<Stop> stops = new ArrayList<Stop>();
	
	public class Path{
		Stop[] stops;
		
		Path (Stop[] stops) {
			this.stops = stops;
		}
		
		public int getTotalWeight() {
			return 0;
		}
		
		public boolean passes(Stop s) {
			return false;
		}
		public boolean passes(String name) {
			return false;
		}
		
	}// end of Path Class
	
	public Stop getStop(String name) {
		return null;
	}
	
	public Stop[] getAllStops() {
		return (Stop[]) stops.toArray();
	}
	
	public boolean stopExsists(String name) {
		return false;
	}
	
	public boolean addStop(String name) {
		return false;
	}
	
	public boolean remStop(String name) {
		return false;
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

