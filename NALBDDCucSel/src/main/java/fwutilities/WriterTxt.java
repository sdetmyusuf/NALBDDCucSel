package fwutilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import com.google.common.io.FileWriteMode;

public class WriterTxt {

	public static void writeInFile(String filepath, String data) {
		try {
			File file = new File(filepath);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 5; j++) {
					
					int num = (int) (Math.random()*100);
					
					bw.write(num+",");
				
					
				}
			}
			
			bw.write(data);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		
		WriterTxt.writeInFile(path+"\\src\\main\\resources\\TestRecord.csv", "Data to be tested");
	}

}
