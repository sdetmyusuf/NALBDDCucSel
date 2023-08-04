package fwutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReaderUtil {

	public Properties propFileReader(String filePath) {

		FileInputStream fis = null;
		Properties prop = null;

		try {
			fis = new FileInputStream(filePath);

			prop = new Properties();

			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}
