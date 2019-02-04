package de.jet.tournamentmaker.ui;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.jet.tournamentmaker.model.Player;
import de.jet.tournamentmaker.service.PlayerService;

@Route("player")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PlayerView extends VerticalLayout {

	private static final long serialVersionUID = -1574593816169880530L;

	public PlayerView(PlayerService playerService) {

		Grid<Player> playerGrid = new Grid<>();
		playerGrid.addColumn(Player::getName).setHeader("Name");
		playerGrid.addColumn(Player::getScore).setHeader("Score");
		playerGrid.addColumn(Player::getElo).setHeader("Elo");
		playerGrid.addColumn(Player::isActive).setHeader("Active");
		playerGrid.setItems(playerService.getPlayer());

		this.add(new Button("Add Player", e -> Notification.show("Hello Spring+Vaadin user!")));
		this.add(playerGrid);

		this.setWidth("500px");
		this.setHeight("500px");
	}
}