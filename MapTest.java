package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MapTest {
static Map testInstance;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testInstance = new Map("/home/sunbro/eclipse-workspace/metroMap/application/vienna_subway.csv");
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
			assert(testInstance.findDFSPath(testInstance.getStop("Keplerplatz"), testInstance.getStop("oberlaa")) != null);
			
		} catch (DestionationUnreachableException e) {
			e.printStackTrace();
		}
	}

}
