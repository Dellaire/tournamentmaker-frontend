package de.jet.tournamentmaker.ui;

import java.util.stream.Collectors;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

import de.jet.tournamentmaker.services.TournamentService;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TournamentPanel extends Panel {

	private static final long serialVersionUID = 3890715887100719059L;

	private final TournamentService tournamentService;
	private Notification callback;
	private ComboBox<String> tournaments = new ComboBox<>();

	public TournamentPanel(TournamentService tournamentService) {

		this.tournamentService = tournamentService;
	}

	public TournamentPanel initialize() {

		HorizontalLayout content = new HorizontalLayout();
		this.setContent(content);

		this.tournaments.addValueChangeListener(event -> {
			this.callback.trigger();
		});
		this.tournaments.setEmptySelectionAllowed(false);
		
		this.loadTournaments(this.tournaments);
		content.addComponent(this.tournaments);

		content.addComponent(new Button("Add Tournament", e -> {
			this.getUI().addWindow(new NewTournamentWindow(this.tournamentService, tournamnetName -> {
				this.loadTournaments(this.tournaments);
				this.tournaments.setSelectedItem(tournamnetName);
			}));
		}));

		return this;
	}

	private void loadTournaments(ComboBox<String> tournaments) {

		tournaments.setItems(this.tournamentService.getTournaments().stream().map(tournament -> tournament.getName())
				.collect(Collectors.toList()));
	}

	public void setCallback(Notification callback) {
		this.callback = callback;
	}

	public String getTournamentName() {
		return this.tournaments.getValue();
	}
}
