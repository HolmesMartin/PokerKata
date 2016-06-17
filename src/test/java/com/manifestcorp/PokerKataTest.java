package com.manifestcorp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PokerKataTest {

	private PokerKata kata;
	private static final String GAME_1 = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
	private static final String GAME_2 = "Black::2H 3D 5S 9C KD White: 2D 3D 5C 9H KS";
	private static final String GAME_3 = "Black: 2H 4D 5S 9C KD White: 2D 3D 5C 9H KS";
	private static final String GAME_4 = "Black: 2H 4H 5H 9H KH White: 2D 3D 5C 9H KS";
	
	@Before
	public void before() {
		kata = new PokerKata(GAME_1);
	}
	
	@Test
	public void testGetBasicWinner() {
		assertEquals("Player White should win by High Card on Ace", kata.getWinner(), "White");
	}
	
	@Test
	public void testGetWinnerTie() {
		kata = new PokerKata(GAME_2);
		assertEquals("Both Players should Tie", kata.getWinner(), "Tie");
	}
	
	@Test
	public void testGetBlackWinnerByHighCardOn4D() {
		kata = new PokerKata(GAME_3);
		assertEquals("Player Black should win by High Card on 4", kata.getWinner(), "Black");
	}
	
	@Test
	public void testGetBlackWinnerByFlush() {
		kata = new PokerKata(GAME_4);
		assertEquals("Player Black should win by High Card on 4", kata.getWinnerMethod(), "Flush");
	}
	
}
