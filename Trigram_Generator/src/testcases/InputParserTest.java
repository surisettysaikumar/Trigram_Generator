package testcases;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;
import code.InputParser;

class InputParserTest {
	@Test
	public void parseInputFileNullTest() { // Method checking if input file is null
		Throwable exception = assertThrows(NullPointerException.class, () -> {
		 InputParser IP =new InputParser();
		 IP.parseInputFile(null); });
		 assertEquals("File name is Invalid", exception.getMessage());     
		   }
	
	
	@Test
	public void parseInputFileValidTest() { // Method verifies if file exists or not
		 File file = new File("input.txt");
		 assertEquals(true, file.exists());     
		   }
}
