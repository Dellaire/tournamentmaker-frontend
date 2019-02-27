package de.jet.tournamentmaker.ui;

import org.springframework.stereotype.Component;

@Component
public class ValueStore {

	private String tournamentName;

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
}
