package fwutilities;

import io.cucumber.java.Scenario;

public class StringUtils {
//	
//	public static String nameGenerator(Scenario scenario) {
//		String sname = scenario.getName();
//		String fsname = sname.replace(" ", "-");
//		return fsname;
//		
//	}

	public static String nameGenerator(Scenario scenario) {
		String sname = scenario.getName();
		String fsname = sname.replace(" ", "-");
		return fsname;
	}


}
