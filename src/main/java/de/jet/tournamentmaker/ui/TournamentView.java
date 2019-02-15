package de.jet.tournamentmaker.ui;

import java.util.stream.Collectors;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

import de.jet.tournamentmaker.services.TournamentService;

@SpringUI(path = "tournaments")
public class TournamentView extends UI {

	private static final long serialVersionUID = 4410538572843013449L;

	private final TournamentService tournamentService;

	public TournamentView(TournamentService tournamentService) {
		this.tournamentService = tournamentService;
	}

	@Override
	protected void init(VaadinRequest request) {

		HorizontalLayout content = new HorizontalLayout();
		this.setContent(content);

		ComboBox<String> tournaments = new ComboBox<>();
		this.loadTournaments(tournaments);
		content.addComponent(tournaments);

		content.addComponent(new Button("Add Tournament", e -> {
			this.getUI().addWindow(new NewTournamentWindow(this.tournamentService, () -> {
				this.loadTournaments(tournaments);
			}));
		}));
	}

	private void loadTournaments(ComboBox<String> tournaments) {

		tournaments.setItems(this.tournamentService.getTournaments().stream().map(tournament -> tournament.getName())
				.collect(Collectors.toList()));
	}
}