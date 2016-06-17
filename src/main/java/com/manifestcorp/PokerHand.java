package com.manifestcorp;

import java.util.*;

public class PokerHand {
	
	private List<Card> listOfCards = new ArrayList<Card>();
	private String handType;
	private Integer handTypeValue;
	private List<Integer> tieBreakerOrder;

	public PokerHand(List<String> arrayOfCards) {
		for (String card : arrayOfCards) {
			listOfCards.add(new Card(card));
		}
		findBestHand();
	}

	public void findBestHand() {
		organizeHandFromHighestRankToLowest();
		setBestHandType();
		fillRemainingTieBreakerList();
	}

	public void organizeHandFromHighestRankToLowest() {
		listOfCards.sort((Card c1, Card c2) -> c1.getRank().compareTo(c2.getRank()));
		Collections.reverse(listOfCards);
	}

	private void setBestHandType() {
		if (isStraightFlush()) {
			handTypeValue = (Integer)9;
			handType = "Straight Flush";
		}
		else if (isFourOfAKind()) {
			handTypeValue = (Integer)8;
			handType = "Four of a Kind";
		}
		else if (isFullHouse()) {
			handTypeValue = (Integer)7;
			handType = "Full House";
		}
		else if (isFlush()) {
			handTypeValue = (Integer)6;
			handType = "Flush";
		}
		else if (isStraight()) {
			handTypeValue = (Integer)5;
			handType = "Straight";
		}
		else if (isThreeOfAKind()) {
			handTypeValue = (Integer)4;
			handType = "Three of a Kind";
		}
		else if (isTwoPair()) {
			handTypeValue = (Integer)3;
			handType = "Two Pair";
		}
		else if (isOnePair()) {
			handTypeValue = (Integer)2;
			handType = "One Pair";
		}
		else {
			handTypeValue = (Integer)1;
			handType = "High Card";
		}
	}

	private boolean isStraightFlush() {
		return (isStraight() && isFlush());
	}

	private boolean isFourOfAKind() {
		return primaryRankChecker(4);
	}

	private boolean isFullHouse() {
		return (primaryRankChecker(3) && secondaryRankChecker(2));
	}

	private boolean isFlush() {
		boolean isFlush = true;
		tieBreakerOrder = new ArrayList<Integer>();
		int i = 0;
		while (isFlush && i < 5) {
			isFlush = (listOfCards.get(0).getSuit() == listOfCards.get(i).getSuit());
			i++;
		}
		return isFlush;
	}

	private boolean isStraight() {
		boolean isStraight = true;
		tieBreakerOrder = new ArrayList<Integer>();
		int i = 0;
		while (isStraight && i < 5) {
			isStraight = (listOfCards.get(i).getRank() == (listOfCards.get(0).getRank() - i));
			i++;
		}
		return isStraight;
	}

	private boolean isThreeOfAKind() {
		return primaryRankChecker(3);
	}

	private boolean isTwoPair() {
		return (primaryRankChecker(2) && secondaryRankChecker(2));
	}

	private boolean isOnePair() {
		return primaryRankChecker(2);
	}
	
	private boolean primaryRankChecker(int countCheck) {
		tieBreakerOrder = new ArrayList<Integer>();
		return secondaryRankChecker(countCheck);
	}
	
	private boolean secondaryRankChecker(int countCheck) {
		for (int i = 0; i < 5; i++) {
			int count = 0;
			for (int j = i; j < 5; j++) {
				if (listOfCards.get(i).getRank() == listOfCards.get(j).getRank()) {
					count++;
				}
			}
			if (count == countCheck && !tieBreakerOrder.contains(listOfCards.get(i).getRank())) {
				tieBreakerOrder.add(listOfCards.get(i).getRank());
				return true;
			}
		}
		return false;
	}
	
	private void fillRemainingTieBreakerList() {
		for (Card card : listOfCards) {
			if (!tieBreakerOrder.contains(card.getRank())) {tieBreakerOrder.add(card.getRank());}
		}
	}

	
	public String cardFace(int i) {
		return listOfCards.get(i).getFace();
	}

	public Integer cardRank(int i) {
		return listOfCards.get(i).getRank();
	}

	public String cardSuit(int i) {
		return listOfCards.get(i).getSuit();
	}
		
	public String getBestHandType() {
		return handType;
	}

	public Integer getBestHandTypeValue() {
		return handTypeValue;
	}
	
	public List<Integer> getTieBreaker() {
		return tieBreakerOrder;
	}
}
