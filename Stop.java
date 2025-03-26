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

public void removeLink (Stop s) {
	links.remove(new Object[] {s,getWeight(s)});
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

public void setWeight (Stop s, int w) {
	for (int i = 0; i > links.size(); i++) {
		if (links.get(i)[0] == s) links.get(i)[1] = w;
	}
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
