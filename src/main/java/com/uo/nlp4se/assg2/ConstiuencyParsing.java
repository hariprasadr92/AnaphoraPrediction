package com.uo.nlp4se.assg2;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.trees.tregex.TregexPattern;

import java.util.*;

public class ConstiuencyParsing {

  public static void main(String[] args) {
  
    StanfordCoreNLP pipeline = Pipeline.getPipeline();
    // build annotation for a review
    Annotation annotation =
        new Annotation("It  is  retarded  under  certain  conditions,  none  of  which,  however,  appear  to  have  been  present  in  this  case.");
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
        //System.err.println("found constituent: "+constituent.toString());
        //System.err.println(tree.getLeaves().subList(constituent.start(), constituent.end()+1));
      }
    }
    //tregex code 
    String regex = "NP !< NP";
    TregexPattern p = TregexPattern.compile(regex);
    TregexMatcher m = p.matcher(tree);
    
    while (m.find()) {
    	Tree subtree = m.getMatch();
        Set<Constituent> treeConstituentss = subtree.constituents(new LabeledScoredConstituentFactory());
        for (Constituent constituent : treeConstituentss) {
            if (constituent.label() != null 
          		  //&& (constituent.label().toString().equals("VP") || constituent.label().toString().equals("NP"))
          		  ) {
              //System.err.println("found constituent: "+constituent.toString());
              System.err.println(tree.getLeaves());
            }
          }
        
    	  // System.out.println(m.getMatch().constituents());
    }


  }
}