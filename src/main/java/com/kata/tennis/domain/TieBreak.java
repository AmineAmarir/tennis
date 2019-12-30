package com.kata.tennis.domain;

public class TieBreak {

	private int playerOneScore = 0;
	private int playerTwoScore = 0;

	public int getPlayerOneScore() {
		return playerOneScore;
	}

	public boolean playerOneScore() {
		if (isTieBreakEnded()) {
			throw new IllegalStateException("The tie break has ended");
		}
		this.playerOneScore++;
		return isTieBreakEnded();
	}

	public int getPlayerTwoScore() {
		return playerTwoScore;
	}

	public boolean playerTwoScore() {
		if (isTieBreakEnded()) {
			throw new IllegalStateException("The tie break has ended");
		}
		this.playerTwoScore++;
		return isTieBreakEnded();
	}

	public boolean isTieBreakEnded() {
		return (this.playerOneScore > 6 || this.playerTwoScore > 6) && Math.abs(this.playerOneScore - this.playerTwoScore) > 1;
	}

}
