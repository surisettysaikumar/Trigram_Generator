package testcases;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import code.InputParser;

class PopulateTrigramTest {
	
	@Test
	public void PopulateTrigramNullTest() { // Method to verify if null list is parsed
		 Throwable exception = assertThrows(NullPointerException.class, () -> {
		 InputParser IP =new InputParser();
		 IP.populateTrigrams(null);
		    });
		 assertEquals("list is null, Please check again!", exception.getMessage());
	}
	
	@Test
	public void parseInputFileEmptyTest() { // Method to test wordslist size>=3
		List<String> wordsList=new ArrayList<String>();
		wordsList.add("Hi");
		wordsList.add("sai");
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
		 InputParser IP =new InputParser();
		 IP.populateTrigrams(wordsList);
		    });
		assertEquals("Minimum 3 elements required to generate Triagram", exception.getMessage());     
	}

}
