package com.manifestcorp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Card {

	private static Map<String, String> suitHash = new HashMap<String, String>() {{
		put("H","Heart");
		put("S", "Spade");
		put("C", "Club");
		put("D", "Diamond");
	};};
	
	private static Map<String, List<Object>> faceRankHash = new HashMap<String, List<Object>>() {{
		put("2", Arrays.asList(2, "Deuce"));
		put("3", Arrays.asList(3, "Three"));
		put("4", Arrays.asList(4, "Four"));
		put("5", Arrays.asList(5, "Five"));
		put("6", Arrays.asList(6, "Six"));
		put("7", Arrays.asList(7, "Seven"));
		put("8", Arrays.asList(8, "Eight"));
		put("9", Arrays.asList(9, "Nine"));
		put("T", Arrays.asList(10, "Ten"));
		put("J", Arrays.asList(11, "Jack"));
		put("Q", Arrays.asList(12, "Queen"));
		put("K", Arrays.asList(13, "King"));
		put("A", Arrays.asList(14, "Ace"));
	};};
	
	private Integer rank;
	private String face;
	private String suit;

	public Card(String cardString) {
		String[] cardArray = cardString.split("");
		setFaceAndRank(cardArray[0]);
		setSuit(cardArray[1]);
	}

	public void setSuit(String suitChar) {
		suit = suitHash.get(suitChar);
	}

	public void setFaceAndRank(String rankChar) {
		rank = (Integer)faceRankHash.get(rankChar).get(0);
		face = (String)faceRankHash.get(rankChar).get(1);
	}

	public String getSuit() {
		return suit;
	}

	public String getFace() {
		return face;
	}

	public Integer getRank() {
		return rank;
	}

}