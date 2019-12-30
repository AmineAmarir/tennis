package com.kata.tennis.domain;

import java.util.ArrayList;
import java.util.List;

public class Set {

	private String playerOne;
	private int playerOneSetScore;
	private String playerTwo;
	private int playerTwoSetScore;
	private List<Game> games = new ArrayList<>();
	private TieBreak tieBreak;

	public Set(String playerOne, String playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	public Game getCurrentGame() {
		if (isTieBreak()) {
			if (tieBreak == null) {
				this.tieBreak = new TieBreak();
			}
			return null;
		}
		if (this.games.isEmpty()) {
			final Game newGame = new Game(new Player(playerOne), new Player(playerTwo));
			this.games.add(newGame);
			return newGame;
		}
		return this.games.get(this.games.size() - 1);
	}

	public boolean playerOneScore() {
		if (isSetEnded()) {
			throw new IllegalStateException("The set has ended");
		}
		if (isTieBreak()) {
			if (tieBreak == null) {
				this.tieBreak = new TieBreak();
			} else if (tieBreak.isTieBreakEnded()) {
				throw new IllegalStateException("The tie break has ended");
			}
			this.tieBreak.playerOneScore();
			if (tieBreak.isTieBreakEnded()) {
				playerOneSetScore++;
			}
			return isSetEnded();
		} else if (this.getCurrentGame()
				.playerOneScore()) {
			playerOneSetScore++;
			if (!isSetEnded()) {
				final Game newGame = new Game(new Player(playerOne), new Player(playerTwo));
				this.games.add(newGame);
				return false;
			}
		}
		return true;
	}

	public boolean playerTwoScore() {
		if (isSetEnded()) {
			throw new IllegalStateException("The set has ended");
		}
		if (isTieBreak()) {
			if (tieBreak == null) {
				this.tieBreak = new TieBreak();
			} else if (tieBreak.isTieBreakEnded()) {
				throw new IllegalStateException("The tie break has ended");
			}
			this.tieBreak.playerTwoScore();
			if (tieBreak.isTieBreakEnded()) {
				playerTwoSetScore++;
			}
			return isSetEnded();
		} else if (this.getCurrentGame()
				.playerTwoScore()) {
			playerTwoSetScore++;
			if (!isSetEnded()) {
				final Game newGame = new Game(new Player(playerOne), new Player(playerTwo));
				this.games.add(newGame);
				return false;
			}
		}
		return true;
	}

	private boolean isSetEnded() {
		if (this.playerOneSetScore == 7 || this.playerTwoSetScore == 7) {
			return true;
		}
		return (this.playerOneSetScore == 6 || this.playerTwoSetScore == 6) && Math.abs(this.playerOneSetScore - this.playerTwoSetScore) > 1;
	}

	private boolean isTieBreak() {
		return this.playerOneSetScore == 6 && this.playerTwoSetScore == 6;
	}

	public String getSetScore() {
		if (isSetEnded()) {
			if (this.playerOneSetScore == 7 || this.playerOneSetScore - this.playerTwoSetScore > 1) {
				return this.playerOne + " Win (" + playerOneSetScore + "-" + playerTwoSetScore + ")";
			} else if (this.playerTwoSetScore == 7 || this.playerOneSetScore - this.playerTwoSetScore < 1) {
				return this.playerTwo + " Win (" + playerOneSetScore + "-" + playerTwoSetScore + ")";
			}
		}
		return playerOneSetScore + "-" + playerTwoSetScore;
	}

}
