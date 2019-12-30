package com.kata.tennis.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Player playerOne;
	private Player playerTwo;
	private Game game;

	@Before
	public void setup() {
		playerOne = new Player("PlayerOne");
		playerTwo = new Player("PlayerTwo");
		game = new Game(playerOne, playerTwo);
	}

	@Test
	public void game_should_start_with_score_of_0_0() {
		assertThat(game.getPlayerOneCurrentScore(), is(equalTo(0)));
		assertThat(game.getPlayerTwoCurrentScore(), is(equalTo(0)));
	}

	@Test
	public void game_should_be_with_score_of_1_0_when_playerOne_scores() {
		game.playerOneScore();
		assertThat(game.getPlayerOneCurrentScore(), is(equalTo(1)));
		assertThat(game.getPlayerTwoCurrentScore(), is(equalTo(0)));
	}

	@Test
	public void game_should_have_score_of_1_1_when_playerOne_scores_and_playerTwo_scores() {
		game.playerOneScore();
		game.playerTwoScore();
		assertThat(game.getPlayerOneCurrentScore(), is(equalTo(1)));
		assertThat(game.getPlayerTwoCurrentScore(), is(equalTo(1)));
	}

	@Test
	public void game_should_have_game_score_15_15() {
		game.playerOneScore();
		game.playerTwoScore();
		assertThat(game.getGameScore(), is(equalTo("15-15")));
	}

	@Test
	public void game_should_have_game_score_15_30() {
		game.playerOneScore();
		game.playerTwoScore();
		game.playerTwoScore();
		assertThat(game.getGameScore(), is(equalTo("15-30")));
	}

	@Test
	public void game_should_have_game_score_15_40() {
		game.playerOneScore();
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();
		assertThat(game.getGameScore(), is(equalTo("15-40")));
	}

	@Test
	public void game_should_have_game_score_30_40() {
		game.playerOneScore();
		game.playerOneScore();
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();
		assertThat(game.getGameScore(), is(equalTo("30-40")));
	}

	@Test
	public void game_should_have_game_score_40_40() {
		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();
		assertThat(game.getGameScore(), is(equalTo("40-40")));
	}

	@Test
	public void game_should_have_game_score_playerOne_Win() {
		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();
		assertThat(game.getGameScore(), is(equalTo("PlayerOne Win")));
	}

	@Test
	public void game_should_have_game_score_playerTwo_Win() {
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();
		assertThat(game.getGameScore(), is(equalTo("PlayerTwo Win")));
	}

	@Test
	public void game_should_have_game_score_deuce() {
		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerOneScore();
		game.playerTwoScore();
		assertThat(game.getGameScore(), is(equalTo("DEUCE")));
	}

	@Test
	public void game_should_have_game_score_advantage_PlayerOne() {
		game.playerOneScore();
		game.playerTwoScore();
		game.playerOneScore();
		game.playerTwoScore();
		game.playerOneScore();
		game.playerTwoScore();
		game.playerOneScore();
		game.playerTwoScore();
		game.playerOneScore();
		assertThat(game.getGameScore(), is(equalTo("ADVANTAGE PlayerOne")));
	}

	@Test
	public void game_should_have_game_score_advantage_PlayerTwo() {
		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerOneScore();
		game.playerTwoScore();
		game.playerTwoScore();
		assertThat(game.getGameScore(), is(equalTo("ADVANTAGE PlayerTwo")));
	}

	@Test
	public void game_should_have_game_score_playerOne_Win_sprint_1() {
		game.playerOneScore();
		game.playerOneScore();
		game.playerTwoScore();
		game.playerOneScore();
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();
		assertThat(game.getGameScore(), is(equalTo("PlayerOne Win")));
	}
}
