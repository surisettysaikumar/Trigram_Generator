package testcases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import code.TrigramGenerator;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  Includes some JUnit cases for testRandomKey,testWriteOutputFile
 * @author Sai Kumar Surisetty
 *
 */

class TrigramGeneratorTest {

	@Test
	public void testRandomKey() {    // Check If Array list has any Null value
		List<String> wordsList=new ArrayList<String>();
		wordsList.add("Hi");
		wordsList.add("sai");
		wordsList.add("kumar");
		int randomNumber = new Random().nextInt(wordsList.size()-1);
		String key1 = wordsList.get(randomNumber);
		assertTrue(!key1.equals(null));
	} 
	
	@Test
	public void testWriteOutputFile() { // Checking functionality of Write output method
		TrigramGenerator triGen = new TrigramGenerator();
		String test_output="Hi! My name is Sai Kumar";
		triGen.writeOutputFile("testoutput.txt", test_output);
		File file = new File("testoutput.txt");
		assertEquals(true,file.exists());
	}

}
