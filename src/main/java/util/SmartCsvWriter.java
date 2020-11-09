package util;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;
import java.util.List;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.uo.nlp4se.assg2.model.PAAResult;;

public class SmartCsvWriter {
	
	/**
	 * Writes the list of PAAResult objects in to a csv
	 * @return void 
	 * @throws 
	 * @param List of {@link PAAResult} objects
	 * 
	 */
	public static void writeToFile(List<PAAResult> results)  {
		
		String filename1 = "target";
		Date date= new Date();
		String filename = filename1+"_"+date.toString()+".csv";
		try {
			Writer writer= new FileWriter("output.csv");
			
			StatefulBeanToCsv<PAAResult> beanToCSV = 
					new StatefulBeanToCsvBuilder<PAAResult>(writer).build();
			
			
			beanToCSV.write(results);
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	 

}
