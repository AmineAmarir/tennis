package com.kata.tennis.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SetTest {

	private String playerOne = "PlayerOne";
	private String playerTwo = "PlayerTwo";
	private Set set;

	@Before
	public void setup() {
		this.set = new Set(playerOne, playerTwo);
	}

	@Test
	public void set_should_start_with_score_of_0_0() {
		assertThat(set.getSetScore(), is(equalTo("0-0")));
	}

	@Test
	public void set_should_start_with_score_of_1_0() {
		set.playerOneScore();
		set.playerOneScore();
		set.playerOneScore();
		set.playerOneScore();
		assertThat(set.getSetScore(), is(equalTo("1-0")));
	}

	@Test
	public void set_should_start_with_score_of_2_0() {
		for (int i = 0; i < 2; i++) {
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
		}
		assertThat(set.getSetScore(), is(equalTo("2-0")));
	}

	@Test
	public void set_should_start_with_score_of_3_0() {
		for (int i = 0; i < 3; i++) {
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
		}
		assertThat(set.getSetScore(), is(equalTo("3-0")));
	}

	@Test
	public void set_should_start_with_score_of_4_0() {
		for (int i = 0; i < 4; i++) {
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
		}
		assertThat(set.getSetScore(), is(equalTo("4-0")));
	}

	@Test
	public void set_should_start_with_score_of_5_0() {
		for (int i = 0; i < 5; i++) {
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
		}
		assertThat(set.getSetScore(), is(equalTo("5-0")));
	}

	@Test
	public void set_should_have_set_score_playerOne_Win() {
		for (int i = 0; i < 6; i++) {
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
		}
		assertThat(set.getSetScore(), is(equalTo("PlayerOne Win (6-0)")));
	}

	@Test
	public void set_should_have_set_score_playerTwo_Win() {
		for (int i = 0; i < 6; i++) {
			set.playerTwoScore();
			set.playerTwoScore();
			set.playerTwoScore();
			set.playerTwoScore();
		}
		assertThat(set.getSetScore(), is(equalTo("PlayerTwo Win (0-6)")));
	}

	@Test
	public void game_should_have_set_score_playerTwo_Win_sprint_2_user_story_1() {

		// 1-0
		set.playerOneScore();
		set.playerOneScore();
		set.playerTwoScore();
		set.playerOneScore();
		set.playerOneScore();
		// 1-1
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		// 1-2
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		// 1-3
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		// 1-4
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		// 1-5
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		// 1-6 => PlayerTwo Win
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();
		set.playerTwoScore();

		assertThat(set.getSetScore(), is(equalTo("PlayerTwo Win (1-6)")));
	}

	@Test
	public void game_should_have_game_score_playerOne_Win_sprint_2_user_story_2() {

		// 5-0
		for (int i = 0; i < 5; i++) {
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
			set.playerOneScore();
		}
		
		// 5-6
		for (int i = 0; i < 6; i++) {
			set.playerTwoScore();
			set.playerTwoScore();
			set.playerTwoScore();
			set.playerTwoScore();
		}

		// 6-6
		set.playerOneScore();
		set.playerOneScore();
		set.playerOneScore();
		set.playerOneScore();
		
		// 7-6 TieBreak(7-2)
		set.playerOneScore();
		set.playerTwoScore();
		set.playerOneScore();
		set.playerOneScore();
		set.playerTwoScore();
		set.playerOneScore();
		set.playerOneScore();
		set.playerOneScore();
		set.playerOneScore();

		assertThat(set.getSetScore(), is(equalTo("PlayerOne Win (7-6)")));
	}
}
