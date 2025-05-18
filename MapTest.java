package com.ca2.routefinder;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ca2.routefinder.Map.Path;

import javafx.scene.image.WritableImage;

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
			Path temp = testInstance.findDFSPath(testInstance.getStop("Neulaa"), testInstance.getStop("Zieglergasse"));
			assert(temp != null);
		} catch (DestionationUnreachableException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void getAllStopsTest() {
		assert(testInstance.getAllStopNames() != null);
	}

	@Test
	void bfsTest() {
		try {
			Path temp = testInstance.findBFSPath(testInstance.getStop("Neulaa"), testInstance.getStop("Zieglergasse"));
			assert(temp != null);
			System.out.println(temp.toString());
		} catch (DestionationUnreachableException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void bfsBenchTest() {
		try {
			Path temp = null;
			int minMs = 1000;
			int maxMs = 0;
			int avgMs = 0;
			int lastMs = 0;
			System.out.println("Starting Breadth first search benchmark...");
			for (int i = 0; i < 101; i++) {
			long startTime = System.nanoTime();
			testInstance.findBFSPath(testInstance.getStop("Neulaa"), testInstance.getStop("Zieglergasse"));
			long endTime = System.nanoTime();
			lastMs = (int) (endTime - startTime);
			//System.out.println("Breadth First Search took " + lastMs + " nanoseconds");
			minMs = lastMs < minMs ? lastMs : minMs;
			maxMs = lastMs > maxMs ? lastMs : maxMs;
			avgMs = (avgMs + lastMs)/2;
			}
			System.out.println("Benchmark compleate, Stats;");
			System.out.println("Minimum time: " + minMs + "ns, equivelent to " + 1000000000/minMs + " FPS");
			System.out.println("Maximum time: " + maxMs + "ns, equivelent to " + 1000000000/maxMs + " FPS");
			System.out.println("Average time: " + avgMs + "ns, equivelent to " + 1000000000/avgMs + " FPS");
			temp = testInstance.findBFSPath(testInstance.getStop("Neulaa"), testInstance.getStop("Zieglergasse"));
			assert(temp != null);
		} catch (DestionationUnreachableException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void dfsBenchTest() {
		try {
			Path temp = null;
			int minMs = 1000;
			int maxMs = 0;
			int avgMs = 0;
			int lastMs = 0;
			System.out.println("Starting Depth first search benchmark...");
			for (int i = 0; i < 101; i++) {
			long startTime = System.nanoTime();
			testInstance.findDFSPath(testInstance.getStop("Neulaa"), testInstance.getStop("Zieglergasse"));
			long endTime = System.nanoTime();
			lastMs = (int) (endTime - startTime);
			//System.out.println("Breadth First Search took " + lastMs + " nanoseconds");
			minMs = lastMs < minMs ? lastMs : minMs;
			maxMs = lastMs > maxMs ? lastMs : maxMs;
			avgMs = (avgMs + lastMs)/2;
			}
			System.out.println("Benchmark compleate, Stats;");
			System.out.println("Minimum time: " + minMs + "ns, equivelent to " + 1000000000/minMs + " FPS");
			System.out.println("Maximum time: " + maxMs + "ns, equivelent to " + 1000000000/maxMs + " FPS");
			System.out.println("Average time: " + avgMs + "ns, equivelent to " + 1000000000/avgMs + " FPS");
			temp = testInstance.findDFSPath(testInstance.getStop("Neulaa"), testInstance.getStop("Zieglergasse"));
			assert(temp != null);
		} catch (DestionationUnreachableException e) {
			e.printStackTrace();
		}
	}
	
}
