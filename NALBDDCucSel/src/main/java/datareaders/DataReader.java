package datareaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	public static List<HashMap<String, String>> data(String filepath, String sheetname) {
		List<HashMap<String, String>> mydata = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			Row heaRow = sheet.getRow(0);

			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);
					switch (currentCell.getCellType()) {
					case STRING:
						currentHash.put(heaRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
					}

				}
				mydata.add(currentHash);
			}
			fis.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mydata;
	}
	
	public static void main(String[] args) {
		List<HashMap<String, String>> testDatat = 	DataReader.data("C:\\Users\\Mohd Yusuf\\codeRepository\\NALCucSelBDD\\NALBDDCucSel\\TestData-FW\\TestData.xlsx", "Sheet1");
		
		Iterator<HashMap<String, String>> itr = testDatat.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println(System.getProperty("user.dir"));
	}
}
