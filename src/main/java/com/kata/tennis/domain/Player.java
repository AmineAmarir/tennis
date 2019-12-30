package com.kata.tennis.domain;

import java.util.Arrays;
import java.util.List;

public class Player {

	protected static final List<String> scores = Arrays.asList("0", "15", "30", "40");

	private String name;
	private int currentScore;

	public Player(String name) {
		this.name = name;
		this.currentScore = 0;
	}

	public void score() {
		this.currentScore++;
	}

	public String getName() {
		return name;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public String tennisScore() {
		return scores.get(currentScore);
	}

}
