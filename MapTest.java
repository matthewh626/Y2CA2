package com.ca2.routefinder;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ca2.routefinder.Map.Path;

@SuppressWarnings("unused")
class MapTest {
static Map testInstance;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testInstance = new Map("/home/sunbro/eclipse-workspace/metroMap/com/ca2/routefinder/vienna_subway.csv");
	}

	@Test
	void test() {
		assert(testInstance.stops.getFirst() != null);
		System.out.println("|" + testInstance.stops.getFirst().name + "|");
		assert(testInstance.getStop("Oberlaa") != null);
	}
	
	@Test
	void dfsTest() {
		try {
			Path temp = testInstance.findDFSPath(testInstance.getStop("Neulaa"), testInstance.getStop("donaumarina"));
			assert(temp != null);
			System.out.println(temp.toString());
			
		} catch (DestionationUnreachableException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void getAllStopsTest() {
		assert(testInstance.getAllStopNames() != null);
	}

}
