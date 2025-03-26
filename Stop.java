package application;

import java.util.ArrayList;
import java.util.Arrays;

public class Stop {
ArrayList<Object[]> links = new ArrayList<Object[]>();
String name;

public Stop (String n) {
	name=n;
}

public void addLink(Stop s, int w) {
	links.add(new Object[] {s,w});
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getWeight (Stop s) {
	for (Object[] l : links) {
		if (Arrays.asList(l).contains(s)) {
			return (int) l[1];
		}
	}
	return 0;
}

public boolean isLinked (Stop s) {
	for (Object[] l : links) {
		if (Arrays.asList(l).contains(s)) {
			return true;
		}
	}
	return false;
}

}// end of class
