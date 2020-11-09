package com.uo.nlp4se.assg2;

import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class POSTagger {
	
	private POSTagger() {
		
	}
    public static List<CoreLabel> getPosTags (String text) {
    	
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline(); 

    	CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);

        /**
         * return List<CoreLabel>
         */
        return coreDocument.tokens();         
    	
    }
}
