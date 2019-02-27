package de.jet.tournamentmaker.ui;

import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

import de.jet.tournamentmaker.services.TournamentService;

@Component
public class TournamentPanel extends Panel {

	private static final long serialVersionUID = 3890715887100719059L;

	private final TournamentService tournamentService;
	private final ValueStore valueStore;
	private Consumer<String> callback;

	public TournamentPanel(TournamentService tournamentService, ValueStore valueStore) {

		this.tournamentService = tournamentService;
		this.valueStore = valueStore;
	}

	public TournamentPanel initialize() {

		HorizontalLayout content = new HorizontalLayout();
		this.setContent(content);

		ComboBox<String> tournaments = new ComboBox<>();
		tournaments.addValueChangeListener(event -> {
			this.valueStore.setTournamentName(event.getValue());
			this.callback.accept(event.getValue());
		});
		this.loadTournaments(tournaments);
		content.addComponent(tournaments);

		content.addComponent(new Button("Add Tournament", e -> {
			this.getUI().addWindow(
					new NewTournamentWindow(this.tournamentService, () -> this.loadTournaments(tournaments)));
		}));

		return this;
	}

	private void loadTournaments(ComboBox<String> tournaments) {

		tournaments.setItems(this.tournamentService.getTournaments().stream().map(tournament -> tournament.getName())
				.collect(Collectors.toList()));
	}

	public void setCallback(Consumer<String> callback) {
		this.callback = callback;
	}
}
