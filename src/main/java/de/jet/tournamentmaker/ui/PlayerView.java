package de.jet.tournamentmaker.ui;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.jet.tournamentmaker.model.Player;

@Route("player")
public class PlayerView extends VerticalLayout {

	private static final long serialVersionUID = -1574593816169880530L;

	private RestTemplate restTemplate = new RestTemplate();
	
	public PlayerView() {

		Grid<Player> playerGrid = new Grid<>();
		playerGrid.addColumn(Player::getName).setHeader("Name");
		playerGrid.addColumn(Player::getScore).setHeader("Score");
		playerGrid.addColumn(Player::getElo).setHeader("Elo");
		playerGrid.addColumn(Player::isActive).setHeader("Active");

		List<Player> player = this.restTemplate.exchange("http://localhost:8080/player", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Player>>() {
				}).getBody();
		playerGrid.setItems(player);

		this.add(new Button("Add Player", e -> Notification.show("Hello Spring+Vaadin user!")));
		this.add(playerGrid);

		this.setWidth("500px");
		this.setHeight("500px");
	}
}