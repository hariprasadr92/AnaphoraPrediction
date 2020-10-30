package com.uo.nlp4se.assg2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.uo.nlp4se.assg2.model.LabelTextPair;
import com.uo.nlp4se.assg2.model.PAAResult;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import util.AppConstants;
import util.SmartCsvReader;

public class Starter {

	public static void main(String[] args) {
		
		String filepath = "src/main/resources/assg2_lite.csv";

		List<LabelTextPair> data = readCSVintoList(filepath);
		
		for (LabelTextPair datum: data ) {
			
			TokenizePOSAndAnalyze (datum);
		}
		
	}
	
	public static List<LabelTextPair> readCSVintoList (String filepath) {
		
		SmartCsvReader smartCsvReader = new SmartCsvReader();
		List<LabelTextPair> data = new ArrayList<LabelTextPair>();
		try {
			data= smartCsvReader.readFromCsv(filepath);
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static PAAResult TokenizePOSAndAnalyze(LabelTextPair labelTextPair) {
		
		List<CoreLabel> coreLabelList= POSTagger.getPosTags(labelTextPair.getText());
		List<String> anaphoraWords = Arrays.asList("it","its","it's");
		
		boolean isRowCreated = false;
		Integer punctCount=0;
		
		List<PAAResult> rowstoBeInserted = Collections.EMPTY_LIST;
		
		for (CoreLabel token: coreLabelList) {
			
            String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);

			if(AppConstants.CORE_NLP_PUNCT_POS_TAGS.contains(pos)) {
				punctCount++;
			}
			
			if(anaphoraWords.contains(token.originalText().toLowerCase())){
				
				isRowCreated= true;
				PAAResult result = new PAAResult();
				result.setF1Position(token.index());  // Setting F1
				result.setF2NTokens(coreLabelList.size());

				System.out.println("--------"+token.originalText()+" "+token.index());
				
				rowstoBeInserted.add(result);
				
			}
			
		}
		
		if(isRowCreated) {
			
			for (PAAResult result : rowstoBeInserted) {
				
				result.setF3NPunc(punctCount);

			}
		}
		
		return null;	
	}
	
	

}
