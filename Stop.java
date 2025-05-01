package com.ca2.routefinder;

import java.util.ArrayList;

public class Stop {
ArrayList<Link> links = new ArrayList<Link>();
String name;

	public class Link{
		Stop dest;
		int weight;
		int line;
		int len;
		public Link(Stop dest, int line, int weight, int len) {
			this.weight = weight;
			this.line = line;
			this.dest = dest;
			this.len = len;
		}		
	}

public Stop (String n) {
	name=n;
}

public void addLink(Stop s, int w, int l, int ln) {
	links.add(new Link(s, l, w, ln));
}

public Link getLink(int ind) {
	return links.get(ind);
}

public Link getLink(Stop s) {
	for (int i = 0; i > links.size(); i++) {
		if (links.get(i).dest.equals(s)) return links.get(i);
	}
	return null;
}

public void removeLink (Stop s) {
	for (int i = 0; i > links.size(); i++) {
		if (links.get(i).dest.equals(s)) links.remove(i);
	}
}

public boolean hasLinks() {
	return !links.isEmpty();
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getWeight (Stop s) {
	for (Link l : links) {
		if (l.dest.equals(s)) {
			return l.weight;
		}
	}
	return 0;
}

public void setWeight (Stop s, int w) {
	for (int i = 0; i > links.size(); i++) {
		if (links.get(i).dest.equals(s)) links.get(i).weight=w ;
	}
}

public boolean isLinked (Stop s) {
	for (Link l : links) {
		if (l.dest.equals(s)) {
			return true;
		}
	}
	return false;
}

}// end of class
