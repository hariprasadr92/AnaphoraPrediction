package com.uo.nlp4se.assg2;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

public class Pipeline {

    private static StanfordCoreNLP stanfordCoreNLP;
    private static Properties properties;
    private static String propertiesName = "tokenize,ssplit,pos,parse";
    
    //"tokenize,ssplit,pos,lemma, ner,parse, sentiment";
    
    private Pipeline() {

    }

    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }

    public static StanfordCoreNLP getPipeline() {

        if(stanfordCoreNLP == null ) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }

        return stanfordCoreNLP;
    }

}
