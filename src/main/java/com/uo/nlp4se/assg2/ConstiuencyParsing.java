package com.uo.nlp4se.assg2;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.*;

import java.util.*;

public class ConstiuencyParsing {

  public static void main(String[] args) {
  
    StanfordCoreNLP pipeline = Pipeline.getPipeline();
    // build annotation for a review
    Annotation annotation =
        new Annotation("When in normal operation, the output shall be the result of the equation.");
    // annotate
    pipeline.annotate(annotation);;
    // get tree
    Tree tree =
        annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0).get(TreeCoreAnnotations.TreeAnnotation.class);
    System.out.println(tree.pennString());
    Set<Constituent> treeConstituents = tree.constituents(new LabeledScoredConstituentFactory());
    for (Constituent constituent : treeConstituents) {
      if (constituent.label() != null 
    		  && (constituent.label().toString().equals("VP") || constituent.label().toString().equals("NP"))
    		  ) {
        System.err.println("found constituent: "+constituent.toString());
        System.err.println(tree.getLeaves().subList(constituent.start(), constituent.end()+1));
      }
    }
  }
}