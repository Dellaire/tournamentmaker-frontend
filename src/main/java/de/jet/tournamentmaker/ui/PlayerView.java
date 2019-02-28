package de.jet.tournamentmaker.ui;

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

	public PlayerView(TournamentService tournamentService, ValueStore valueStore) {

		this.playerGrid = new Grid<Player>();
		this.tournamentService = tournamentService;

		this.playerGrid.addColumn(Player::getName).setCaption("Name");
		this.playerGrid.addColumn(Player::getScore).setCaption("Score");
		this.playerGrid.addColumn(Player::getElo).setCaption("Elo");
		this.playerGrid.addColumn(Player::isActive).setCaption("Active");

		Button addPlayer = new Button("Add Player");
		addPlayer.addClickListener(clickEvent -> this.getViewComponent().getUI()
				.addWindow(new NewPlayerWindow(this.tournamentService, valueStore, this.playerGrid)));

		this.addComponent(addPlayer);
		this.addComponent(this.playerGrid);
	}

	public void reloadPlayer(String tournamentName) {
		this.playerGrid.setItems(this.tournamentService.getPlayer(tournamentName));
	}
}