package com.kata.tennis.domain;

public class Game {

	private Player playerOne;
	private Player playerTwo;

	public Game(Player player1, Player player2) {
		this.playerOne = player1;
		this.playerTwo = player2;
	}

	public int getPlayerOneCurrentScore() {
		return playerOne.getCurrentScore();
	}

	public int getPlayerTwoCurrentScore() {
		return playerTwo.getCurrentScore();
	}

	public String getGameScore() {
		if (playerOne.getCurrentScore() > 3 && playerTwo.getCurrentScore() > 3) {
			if (playerOne.getCurrentScore() == playerTwo.getCurrentScore()) {
				return "DEUCE";
			}
			if (playerOne.getCurrentScore() - playerTwo.getCurrentScore() == 1) {
				return "ADVANTAGE " + playerOne.getName();
			}
			if (playerTwo.getCurrentScore() - playerOne.getCurrentScore() == 1) {
				return "ADVANTAGE " + playerTwo.getName();
			}
		}
		if (playerOne.getCurrentScore() > 3) {
			return playerOne.getName() + " Win";
		}
		if (playerTwo.getCurrentScore() > 3) {
			return playerTwo.getName() + " Win";
		}
		return playerOne.tennisScore() + "-" + playerTwo.tennisScore();
	}

	public boolean playerOneScore() {
		if (isGameEnded()) {
			throw new IllegalStateException("The game has ended");
		}
		this.playerOne.score();
		return isGameEnded();
	}

	public boolean playerTwoScore() {
		if (isGameEnded()) {
			throw new IllegalStateException("The game has ended");
		}
		this.playerTwo.score();
		return isGameEnded();
	}

	private boolean isGameEnded() {
		return (playerOne.getCurrentScore() > 3 || playerTwo.getCurrentScore() > 3) && Math.abs(playerOne.getCurrentScore() - playerTwo.getCurrentScore()) > 1;
	}
}
