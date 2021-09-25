package code;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**
 * Main class handles as the entrypoint/main class for this Trigram generator
 * Includes logging activty, parsing Input txt file to InputParser and Trigram Generator method 
 * populateTrigrams and writing the output to Output.txt file
 * config.properties file has word_limit,InputFile,OutputFile details.
 * 
 * @author Sai Kumar Surisetty
 * 
 */

public class Main {

	public static void main(String[] args) {

		Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
		InputParser InpParObj = new InputParser();
		TrigramGenerator TriGenObj = new TrigramGenerator();
		Properties prop=new Properties();

		try {	
			//Log Starter
			InpParObj.logStarter();	
			// Read the configuration file for input properties.
			InputStream input = new FileInputStream("config.properties");
			// load the properties file
			prop.load(input);
			// Fetch all the properties values.
			String inputFileName = prop.getProperty("inputFileName");
			String outputFileName = prop.getProperty("outputFileName");
			// Creating a Map with Trigrams using populateTrigrams() method
			result = InpParObj.populateTrigrams(InpParObj.parseInputFile(inputFileName));
			//Trigram Display
			InpParObj.trigramDisplay(result);
			//Calling generate method to get the final string result of Trigram
			String final_output = TriGenObj.generate(result);
			// Writing the output to a file
			TriGenObj.writeOutputFile(outputFileName, final_output);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
