package code;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * TrigramGenerator class generates words based on Map<String,
 * ArrayList<String>> it gets as input picking a starting point randomly from
 * the keys in the Map<String, ArrayList<String>> and randomly selects a new
 * word from the list present in the value for the key. This limit is set to
 * 5000 words( To reduce chance of OutOfMemory Error we added limit)
 * 
 * @author Sai Kumar Surisetty
 * 
 */
public class TrigramGenerator {

	private static int WORD_LIMIT;

	/**
	 * This method takes a Map<String, ArrayList<String>> as input and starts
	 * randomly from one of the keys in the Map<String, ArrayList<String>> and picks
	 * a random element from the list in the value of the map for this key.
	 * 
	 * It then generates the next key by splitting the current key in 2 using space
	 * as a delimiter. it uses the second word and the current element picked from
	 * the list as the new key.
	 * 
	 * This continues until no key exists in the Map or it reaches the word limit.
	 * 
	 * @param triagramMap Map<String, ArrayList<String>> used to generate the new
	 *                    words.
	 * @return String of words generated.
	 */
	public final String generate(Map<String, ArrayList<String>> trigramMap) {
		if (trigramMap == null || trigramMap.isEmpty()) {
			throw new IllegalArgumentException("Please, provide a valid input Map");
		}
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties")); // To Load config properties file
		} catch (IOException e) {
			e.printStackTrace();
		}
		WORD_LIMIT = Integer.parseInt(prop.getProperty("Word_Limit").trim()); // Getting word limit value input from
																				// config file
		StringBuilder textBuilder = new StringBuilder();
		// get a random key to start with.
		String startKey = getRandomString(new ArrayList<String>(trigramMap.keySet()));
		int wordCount = 0;
		while (trigramMap.containsKey(startKey) && wordCount < WORD_LIMIT) {
			String value = getRandomString(trigramMap.get(startKey));
			textBuilder.append(value).append(" ");
			String[] splitArray = startKey.split(" ");
			if (splitArray.length < 2) {
				throw new IllegalArgumentException("Please provide a valid Trigram map");
			}
			startKey = splitArray[1] + " " + value;
			wordCount++;
		}
		String result = textBuilder.toString().trim();
		return result;
	}

	/**
	 * This function getRandomString picks a random element from the input
	 * List<String>.
	 * 
	 * @param stringList List<String>
	 * @return String: a random String value chosen from the input String list.
	 */
	private String getRandomString(List<String> stringList) {
		Random rand = new Random();
		int randInt = rand.nextInt(stringList.size());
		String randomKey = stringList.get(randInt);
		return randomKey;
	}

	/**
	 * Write the output file using trigrams result.
	 * 
	 * @param outputFileName
	 * @param final_output
	 */
	public void writeOutputFile(String outputFileName, String final_output) {

		try {
			FileOutputStream fos = new FileOutputStream(outputFileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			// converting string to byte array
			byte[] bytes = final_output.getBytes();
			// writing byte array to file
			bos.write(bytes);
			bos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
