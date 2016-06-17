package com.manifestcorp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerKata {
	
	private List<String> bothHandsArray;
	private Player player1;
	private Player player2;
	private Player winner;
	
	public PokerKata(String handString){
		bothHandsArray = new ArrayList<String>(Arrays.asList(handString.split("[\\s|:]+")));
		player1 = new Player(new ArrayList<String> (bothHandsArray.subList(0, 6)));
		player2 = new Player(new ArrayList<String> (bothHandsArray.subList(6, 12)));
		setWinner();
	}

	private void setWinner() {
		if (player1.getPlayerHandTypeValue() > player2.getPlayerHandTypeValue()) {
			winner = player1;
		}
		else if (player1.getPlayerHandTypeValue() < player2.getPlayerHandTypeValue()) {
			winner = player2;
		}
		else {
			int breaker = 0;
			boolean tiebroke = false;
			while (!tiebroke && breaker < player1.getPlayerTieBreaker().size()) {
				if (player1.getPlayerTieBreaker().get(breaker) > player2.getPlayerTieBreaker().get(breaker)) {
					winner = player1;
					tiebroke = true;
				}
				else if (player1.getPlayerTieBreaker().get(breaker) < player2.getPlayerTieBreaker().get(breaker)) {
					winner = player2;
					tiebroke = true;
				}
				breaker++;
			}
		}
	}

	public String getWinner() {
		return (winner != null) ? winner.getPlayerName(): "Tie";
	}

	public String getWinnerMethod() {
		return winner.getPlayerHandType();
	}

}
