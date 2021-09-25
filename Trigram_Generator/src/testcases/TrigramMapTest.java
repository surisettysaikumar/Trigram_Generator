package testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

import code.TrigramGenerator;

public class TrigramMapTest {

	
	@Test
	public void testNullMap() { // Function to test map is valid or not
		
		Map<String, ArrayList<String>> trigramMap=null;
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			TrigramGenerator TMap =new TrigramGenerator();
			TMap.generate(trigramMap);
		});
		assertEquals("Please, provide a valid input Map", exception.getMessage());
	}
	
	
	
	
}
