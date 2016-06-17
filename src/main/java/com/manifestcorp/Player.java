package com.manifestcorp;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private PokerHand hand;
	
	public Player(ArrayList<String> playerHand) {
		name = playerHand.get(0);
		hand = new PokerHand(new ArrayList<String> (playerHand.subList(1, 6)));
	}

	public String getPlayerName() {
		return name;
	}

	public String getPlayerHandType() {
		return hand.getBestHandType();
	}

	public Integer getPlayerHandTypeValue() {
		return hand.getBestHandTypeValue();
	}

	public List<Integer> getPlayerTieBreaker() {
		return hand.getTieBreaker();
	}
	
	

}
