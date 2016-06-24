package dataDriven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvData {
	
	public static  List<String[]> csvData(String fileName){
		
		List<String[]> records = new ArrayList<String[]>();

		try {
		String record;
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
		}
	
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}

}
