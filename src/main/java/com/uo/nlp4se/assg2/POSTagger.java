package com.uo.nlp4se.assg2;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class POSTagger {

    public static void main(String[] args) {

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        String text = "When I - \"strongly\" say{write} ... 'something' is [done], it; for sure is bull-shit ?";
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreLabel> coreLabelList = coreDocument.tokens();

        for (CoreLabel coreLabel : coreLabelList) {

            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            System.out.println(coreLabel.originalText() + "-" + pos);

            if(pos.equals(".")) {
                System.out.println(coreLabel.originalText() + "-" + pos);

            }

        }
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
