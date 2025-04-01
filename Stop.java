package application;

import java.util.ArrayList;
import java.util.Arrays;

public class Stop {
ArrayList<Link> links = new ArrayList<Link>();
String name;

	public class Link{
		Stop dest;
		int weight;
		int line;
		public Link(Stop dest, int line, int weight) {
			this.weight = weight;
			this.line = line;
			this.dest = dest;
		}		
	}

public Stop (String n) {
	name=n;
}

public void addLink(Stop s, int w, int l) {
	links.add(new Link(s, l, w));
}

public Link getLink(int ind) {
	return links.get(ind);
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
