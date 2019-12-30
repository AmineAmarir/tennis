package com.kata.tennis.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	private Player player;

	@Before
	public void setup() {
		player = new Player("PlayerOne");
	}

	@Test
	public void player_should_start_with_score_of_0() {
		Assert.assertThat(player.getCurrentScore(), is(equalTo(0)));
	}

	@Test
	public void player_should_start_with_score_of_0_check_tennis_score() {
		Assert.assertThat(player.tennisScore(), is(equalTo("0")));
	}

	@Test
	public void player_after_scoring_once() {
		player.score();
		Assert.assertThat(player.getCurrentScore(), is(equalTo(1)));
	}

	@Test
	public void player_after_scoring_once_check_tennis_score() {
		player.score();
		Assert.assertThat(player.tennisScore(), is(equalTo("15")));
	}

}
