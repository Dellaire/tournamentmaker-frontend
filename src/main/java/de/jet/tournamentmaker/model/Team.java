package de.jet.tournamentmaker.model;

public class Team {
	private Player player1;
	private Player player2;

	public Team() {

	}

	public Player getPlayer1() {
		return player1;
	}

	public Team setPlayer1(Player player1) {
		this.player1 = player1;

		return this;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Team setPlayer2(Player player2) {
		this.player2 = player2;

		return this;
	}
}
