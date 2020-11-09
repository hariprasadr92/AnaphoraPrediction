package com.uo.nlp4se.assg2;

import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.trees.tregex.TregexPattern;

public class ConstituencyParsing {
	
	private ConstituencyParsing() {
		
	}

	public static List<Tree> applyTregex(String tregexExpr, Tree tree ){
	  
	    TregexPattern p = TregexPattern.compile(tregexExpr);
	    TregexMatcher m = p.matcher(tree);
	    List<Tree> matchedSubtrees = new ArrayList<Tree>();
	    while (m.find()) {
	    	matchedSubtrees.add(m.getMatch());
	    }
	    return matchedSubtrees;
	}
  
	  public static Tree getConstituencyParseTree ( String text) {
		  
		  StanfordCoreNLP pipeline = Pipeline.getPipeline();
		  Annotation annotation =
		        new Annotation(text);
		    // annotate
		    pipeline.annotate(annotation);
		    // return  tree
		    return  annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0).get(TreeCoreAnnotations.TreeAnnotation.class);
		   
	  }
}