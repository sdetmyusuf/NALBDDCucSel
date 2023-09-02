package fwutilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReaderUtil {
	
	public String sysPathGetter() {
		String sysPath = System.getProperty("user.dir");
		System.out.println(sysPath);
		return sysPath;
	}

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
	
	
	public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load properties file "+ filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        }
        return properties;
    }
	
	public static void main(String[] args) {
		new PropertyFileReaderUtil().sysPathGetter();
	}

}
