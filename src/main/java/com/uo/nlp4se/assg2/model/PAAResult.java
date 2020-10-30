package com.uo.nlp4se.assg2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * 
 * @author Hari
 * PAA stands for Pro-nominal Anaphora Analysis. This is a class thats is equivalent to once instance of 
 * analyzed output data of our NLP pipeline
 * 
 */
public class PAAResult {
	
	private String label;
	private	String text; 
	private Integer	f1Position;
	private Integer	f2NTokens;
	private Integer	f3NPunc;
	private Integer	f4NPrecNP;
	private Integer	f5NSuccNP;
	private Boolean	f6IsFollowsPP;
	
	private String f7POSNeighboursB1;
	private String f7POSNeighboursB2;
	private String f7POSNeighboursB3;
	private String f7POSNeighboursB4;
	private String f7POSNeighboursA1;
	private String f7POSNeighboursA2;
	private String f7POSNeighboursA3;
	private String f7POSNeighboursA4;
	
	private Boolean	f8IsFollByGerund;
	private Boolean	f9IsFollByPrep;
	private Integer	f10NFollAdj;
	private Boolean	f11IsPrecByVerb;
	private Boolean	f12IsFollByVerb;
	private Boolean	f13IsFollByAdj;
	private Boolean	f14IsFollByNPAdj;
	private Integer	f15NTkPrecInfVerb;
	private Integer	f16NtkBtwPrep;
	private Boolean	f17IsFollByAdjNP;
	private String f18DepRel;
	private Boolean	f19IsFollByWeathAdj;
	private Boolean	f20IsFollByCognitiveVerbs;
}
