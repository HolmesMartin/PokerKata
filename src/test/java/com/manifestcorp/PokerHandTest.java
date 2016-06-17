package com.manifestcorp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PokerHandTest {

	private List<String> cardArray;
	private PokerHand hand;

	
	@Before
	public void before() {
		cardArray = new ArrayList<String>(Arrays.asList("2H","TD","3C","7S","AH")); 
		hand = new PokerHand(cardArray);
	}
	
	@Test
	public void testCardFaceInHand() {
		assertEquals("card in fourth hand position should say Ten", hand.cardFace(1), "Ten");
	}
	
	@Test
	public void testCardRankInHand() {
		assertEquals("card in fourth hand position should be 10", hand.cardRank(1), (Integer)10);
	}
	
	@Test
	public void testCardSuitInHand() {
		assertEquals("card in fourth hand position should be Diamond", hand.cardSuit(1), "Diamond");
	}
	
	@Test
	public void testBestHandTypeValue() {
		assertEquals("Best Hand Type Value should return 1 for value", hand.getBestHandTypeValue(), (Integer)1);
	}
	
	@Test
	public void testBestHandTypeHighCard(){
		assertEquals("Best Hand Type should return High Card", hand.getBestHandType(), "High Card");
	}
	
	@Test
	public void testBestHandTypeStraight(){
		cardArray = new ArrayList<String>(Arrays.asList("2H","5H","3D","6H","4D")); 
		hand = new PokerHand(cardArray);
		assertEquals("Best Hand Type should return Straight", hand.getBestHandType(), "Straight");
	}
	
	@Test
	public void testBestHandTypeFlush(){
		cardArray = new ArrayList<String>(Arrays.asList("2H","5H","3H","7H","TH")); 
		hand = new PokerHand(cardArray);
		assertEquals("Best Hand Type should return Straight", hand.getBestHandType(), "Flush");
	}
	
	@Test
	public void testBestHandTypeStraightFlush(){
		cardArray = new ArrayList<String>(Arrays.asList("2H","6H","3H","4H","5H")); 
		hand = new PokerHand(cardArray);
		assertEquals("Best Hand Type should return Flush", hand.getBestHandType(), "Straight Flush");
	}
	
	@Test
	public void testBestHandTypeFourOfAKind(){
		cardArray = new ArrayList<String>(Arrays.asList("2H","TC","TS","TD","TH")); 
		hand = new PokerHand(cardArray);
		assertEquals("Best Hand Type should return Four of a Kind", hand.getBestHandType(), "Four of a Kind");
	}
	
	@Test
	public void testBestHandTypeThreeOfAKind(){
		cardArray = new ArrayList<String>(Arrays.asList("2H","8C","TS","TD","TH")); 
		hand = new PokerHand(cardArray);
		assertEquals("Best Hand Type should return Three of a Kind", hand.getBestHandType(), "Three of a Kind");
	}
	
	@Test
	public void testBestHandTypeOnePair(){
		cardArray = new ArrayList<String>(Arrays.asList("2H","8C","7S","TD","TH")); 
		hand = new PokerHand(cardArray);
		assertEquals("Best Hand Type should return One Pair", hand.getBestHandType(), "One Pair");
	}
	
	@Test
	public void testBestHandTypeTwoPair(){
		cardArray = new ArrayList<String>(Arrays.asList("2H","8C","8S","TD","TH")); 
		hand = new PokerHand(cardArray);
		assertEquals("Best Hand Type should return Two Pair", hand.getBestHandType(), "Two Pair");
	}
	
	@Test
	public void testBestHandTypeFullHouse(){
		cardArray = new ArrayList<String>(Arrays.asList("8H","8C","8S","TD","TH")); 
		hand = new PokerHand(cardArray);
		assertEquals("Best Hand Type should return Full House", hand.getBestHandType(), "Full House");
	}
	
	@Test
	public void testTieBreakerOrderListReturn(){
		cardArray = new ArrayList<String>(Arrays.asList("8H","8C","AS","TD","TH")); 
		hand = new PokerHand(cardArray);
		List<Integer> tieList = new ArrayList<Integer>(Arrays.asList(10, 8, 14));
		assertEquals("Tie Breaker Order List should have 10, then 8, then 14", hand.getTieBreaker(), tieList);
	}
}
