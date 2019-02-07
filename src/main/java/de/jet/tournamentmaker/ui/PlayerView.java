package de.jet.tournamentmaker.ui;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import de.jet.tournamentmaker.model.Player;
import de.jet.tournamentmaker.service.PlayerService;

public class PlayerView extends VerticalLayout implements View {

	private static final long serialVersionUID = -1574593816169880530L;

	public PlayerView(PlayerService playerService) {

		Grid<Player> playerGrid = new Grid<>();
		playerGrid.addColumn(Player::getName).setCaption("Name");
		playerGrid.addColumn(Player::getScore).setCaption("Score");
		playerGrid.addColumn(Player::getElo).setCaption("Elo");
		playerGrid.addColumn(Player::isActive).setCaption("Active");
		playerGrid.setItems(playerService.getPlayer());

		this.addComponent(new Button("Add Player", e -> {
			this.getViewComponent().getUI().addWindow(new NewPlayerWindow(playerService, playerGrid));
		}));
		this.addComponent(playerGrid);
	}
}