package com.uo.nlp4se.assg2;

import java.util.List;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.Synset;
import net.sf.extjwnl.dictionary.Dictionary;

public class WordnetUtil {
	
	public static final POS VERB = POS.VERB;
    public static boolean checkIfWeatherVerb(String verb) {
    	
    	boolean isWeatherVerb = false;

    	try {    		
			Dictionary d = Dictionary.getDefaultResourceInstance();	
			IndexWord indexWord = d.lookupIndexWord(VERB, verb);
			System.out.println(verb);
			if(indexWord!=null) {
				List<Synset> senses = indexWord.getSenses();
				if (!senses.isEmpty()) {
					for (Synset s:  senses) {
						System.out.println(s.getLexFileName());
						if(s.getLexFileName().equals("verb.weather")) {
							isWeatherVerb=true;
							break;
						}
					}
				}	
			}
					
			return isWeatherVerb;
			
		} catch (JWNLException e) {

			e.printStackTrace();
			return isWeatherVerb;

		}
    }
    
    public static boolean checkIfCognitionVerb(String verb) {
    	
    	boolean isCognitionVerb = false;

    	try {    		
			Dictionary d = Dictionary.getDefaultResourceInstance();	
			System.out.println(verb);
			IndexWord indexWord = d.lookupIndexWord(VERB, verb);
			if(indexWord!=null) {
				List<Synset> senses = indexWord.getSenses();
				if (!senses.isEmpty()) {
					for (Synset s:  senses) {
						System.out.println(s.getLexFileName());
						if(s.getLexFileName().equals("verb.cognition")) {
							isCognitionVerb=true;
							break;
						}
					}
				}	
			}
					
			return isCognitionVerb;
			
		} catch (JWNLException e) {

			e.printStackTrace();
			return isCognitionVerb;

		}
    }

}
