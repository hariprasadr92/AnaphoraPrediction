package com.uo.nlp4se.assg2;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.parser.nndep.DependencyParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.util.logging.Redwood;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates how to first use the tagger, then use the NN dependency
 * parser. Note that the parser will not work on untagged text.
 *
 * @author Jon Gauthier
 */
public class DependencyParserDemo  {

  /** A logger for this class */
  private static final Redwood.RedwoodChannels log = Redwood.channels(DependencyParserDemo.class);

  private DependencyParserDemo() {}
 
  public static List<TypedDependency> getDependencies (String text) {
	  
	  List<TypedDependency> dependencies = new ArrayList<TypedDependency>();
	  


	    MaxentTagger tagger = Pipeline.getTagger();
	    DependencyParser parser = Pipeline.getDepParser();
	    DocumentPreprocessor tokenizer = new DocumentPreprocessor(new StringReader(text));
	    
		/*
		 * input should mostly be one lexical sentence. If more than once sentence is
		 * given, then the dependencies will be appended and returned as a single list
		 */
	    for (List<HasWord> sentence : tokenizer) {
	
	      List<TaggedWord> tagged = tagger.tagSentence(sentence);
	      GrammaticalStructure gs = parser.predict(tagged); // main step where depparse takes place	      
	      // Print typed dependencies
	      dependencies.addAll(gs.typedDependenciesEnhancedPlusPlus());	      
	      
	    }
	    return dependencies;
  }

}
