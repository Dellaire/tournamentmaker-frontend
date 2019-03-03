package de.jet.tournamentmaker.ui;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import de.jet.tournamentmaker.model.Match;
import de.jet.tournamentmaker.services.TournamentService;

@Component
public class MatchesView extends VerticalLayout {

	private static final long serialVersionUID = 4781676108750926317L;

	private final Grid<Match> matchesGrid;
	private final TournamentService tournamentService;

	public MatchesView(TournamentService tournamentService, ValueStore valueStore) {

		this.matchesGrid = new Grid<Match>();
		this.tournamentService = tournamentService;

		Button newRound = new Button("New Round");
		newRound.addClickListener(event -> this.tournamentService.generateRound(valueStore.getTournamentName()));

		this.matchesGrid.addColumn(
				match -> match.getTeam1().getPlayer1().getName() + " - " + match.getTeam1().getPlayer1().getName())
				.setCaption("Team 1");
		this.matchesGrid.addColumn(match -> match.getTeam1Score());
		this.matchesGrid.addColumn(match -> match.getTeam2Score());
		this.matchesGrid.addColumn(
				match -> match.getTeam2().getPlayer1().getName() + " - " + match.getTeam1().getPlayer1().getName())
				.setCaption("Team 2");

		this.addComponent(newRound);
		this.addComponent(this.matchesGrid);
	}

	public void reloadMatches(String tournamentName) {

		List<Match> matches = this.tournamentService.getTournament(tournamentName).getRounds().stream()
				.map(round -> round.getMatches()).flatMap(Collection::stream).collect(Collectors.toList());
		this.matchesGrid.setItems(matches);
	}
}