package com.manifestcorp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	private Player player;
	private static final String BLACK = "Black";
	private ArrayList<String> playerArray;
	
	@Before
	public void before() {
		playerArray = new ArrayList<String>(Arrays.asList(BLACK,"2H","3C","7S","TD","AH"));
		player = new Player(playerArray);
	}
	
	@Test
	public void testGetPlayerName() {
		assertEquals("player name should be Black", player.getPlayerName(), BLACK);
	}
	
	@Test
	public void testGetPlayerHandType() {
		assertEquals("player's hand should be High Card", player.getPlayerHandType(), "High Card");
	}
	
	@Test
	public void testGetPlayerHandTypeValue() {
		assertEquals("player's hand should have only High Card Value of 1", player.getPlayerHandTypeValue(), (Integer)1);
	}
	
	@Test
	public void testGetPlayerHandTieBreakerList() {
		playerArray = new ArrayList<String>(Arrays.asList(BLACK,"8H","8C","AS","TD","TH")); 
		player = new Player(playerArray);
		List<Integer> tieList = new ArrayList<Integer>(Arrays.asList(10, 8, 14));
		assertEquals("player's Tie Breaker Order List should have 10, then 8, then 14", player.getPlayerTieBreaker(), tieList);
	}
}
