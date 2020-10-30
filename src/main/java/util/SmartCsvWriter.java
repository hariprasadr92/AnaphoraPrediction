package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.uo.nlp4se.assg2.model.Friend;
import com.uo.nlp4se.assg2.model.PAAResult;;

public class SmartCsvWriter {
	
	public void writeToFile() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		Writer writer= new FileWriter("friends.csv");
		
		StatefulBeanToCsv<Friend> beanToCSV = 
				new StatefulBeanToCsvBuilder<Friend>(writer).build();
		
		List<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend(10,"hp","10-Aug"));
		friends.add(new Friend(10,"maddy","22-Jul"));
		
		
		beanToCSV.write(friends);
		writer.close();
	}

}
