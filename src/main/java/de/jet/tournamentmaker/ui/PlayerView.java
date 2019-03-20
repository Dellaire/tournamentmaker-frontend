package de.jet.tournamentmaker.ui;

import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import de.jet.tournamentmaker.model.Player;
import de.jet.tournamentmaker.services.TournamentService;

@Component
public class PlayerView extends VerticalLayout implements View {

	private static final long serialVersionUID = -1574593816169880530L;

	private final Grid<Player> playerGrid;
	private final TournamentService tournamentService;
	private Supplier<String> tournamentNameSupplier;

	public PlayerView(TournamentService tournamentService) {

		this.playerGrid = new Grid<Player>();
		this.tournamentService = tournamentService;

		this.playerGrid.addColumn(Player::getName).setCaption("Name");
		this.playerGrid.addColumn(Player::getScore).setCaption("Score");
		this.playerGrid.addColumn(Player::getElo).setCaption("Elo");
		this.playerGrid.addColumn(Player::isActive).setCaption("Active");
		if (this.tournamentNameSupplier != null)
			this.reloadPlayer(this.tournamentNameSupplier.get());

		Button addPlayer = new Button("Add Player");
		addPlayer.addClickListener(clickEvent -> this.getViewComponent().getUI()
				.addWindow(new NewPlayerWindow(this.tournamentService, this.tournamentNameSupplier, this.playerGrid)));

		this.addComponent(addPlayer);
		this.addComponent(this.playerGrid);
	}

	public void setTournamentNameSupplier(Supplier<String> tournamentNameSupplier) {
		this.tournamentNameSupplier = tournamentNameSupplier;
	}
	
	public void reloadPlayer(String tournamentName) {
		this.playerGrid.setItems(this.tournamentService.getPlayer(tournamentName));
	}
}