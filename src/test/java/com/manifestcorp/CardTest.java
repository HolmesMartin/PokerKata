package com.manifestcorp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	
	private Card card;
	private Card card2;
	
	@Before
	public void before() {
		card = new Card("2H");
		card2 = new Card("TH");
	}

	@Test
	public void testCardHasSuit() {
		assertEquals("Card Should be Hearts", card.getSuit(), "Heart");
	}
	
	@Test
	public void testCardHasFace() {
		assertEquals("Card should be called Deuce", card.getFace(), "Deuce");
	}
	
	@Test
	public void testCardHasRank() {
		assertEquals("Card should be rank of 2", card.getRank(), (Integer)2);
	}

	@Test
	public void testCardHasRank10() {
		assertEquals("Card should be rank of 10", card2.getRank(), (Integer)10);
	}
	
	@Test
	public void testCardHasFaceTen() {
		assertEquals("Card should be called Ten", card2.getFace(), "Ten");
	}
}
