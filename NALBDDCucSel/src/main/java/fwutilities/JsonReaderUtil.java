package fwutilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class JsonReaderUtil {

	public void JsonReaderUtil(String filePath) {

		// String filePath = "/NALBDDCucSel/TestData-FW/TestJsonFile.json";
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				// Parse each line as JSON
				JSONObject jsonObject = new JSONObject(line);
				System.out.println("Processed JSON object: " + jsonObject);
				// You can access fields in the JSON object like this:
				// String value = jsonObject.getString("key");
			}
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}

	}

	public void jsonReaderMethod(String filePath) {

		//String filePath = "path/to/your/json/file.json";

		try {
			// Step 1: Read JSON file
			StringBuilder jsonContent = new StringBuilder();
			try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
				String line;
				while ((line = reader.readLine()) != null) {
					jsonContent.append(line);
				}
			}

			// Parse JSON content
			JSONObject jsonObject = //new JSONObject(jsonContent.toString());
			
			new JSONObject(jsonContent.toString().replace("@Username", "john-doe"));

			// Step 2: Update JSON data
			// Example: Update a value in the JSON file
			if (jsonObject.has("name")) {
				jsonObject.put("name", "Updated Name");
			}

			// Example: Add a new key-value pair
			jsonObject.put("newKey", "New Value");
		

			// Example: Update a value in a nested JSON object
			if (jsonObject.has("nestedObject")) {
				JSONObject nestedObject = jsonObject.getJSONObject("nestedObject");
				nestedObject.put("nestedKey", "Updated Nested Value");
			}

			// Step 3: Write updated data back to the file
			try (FileWriter fileWriter = new FileWriter(filePath)) {
				fileWriter.write(jsonObject.toString(4)); // Pretty print with 4 spaces
			}

			System.out.println("JSON file successfully updated.");

		} catch (IOException e) {
			System.err.println("Error reading or writing the file: " + e.getMessage());
		}

	}

	public static void main(String[] args) {

//		C:\Users\Mohd Yusuf\eclipse-projects\eclipse-projects\NALBDDCucSel\NALBDDCucSel\TestData-FW\TestJsonFile.json
//		C:\Users\Mohd Yusuf\eclipse-projects\eclipse-projects\NALBDDCucSel\TestData-FW\TestJsonFile.json

		String filePath = System.getProperty("user.dir") + "\\TestData-FW\\TestJsonFile.json";
		System.out.println(filePath);
		JsonReaderUtil obj = new JsonReaderUtil();
		obj.jsonReaderMethod(filePath);

	}

}
