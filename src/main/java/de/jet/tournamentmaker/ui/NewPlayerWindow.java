package de.jet.tournamentmaker.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import de.jet.tournamentmaker.model.Player;
import de.jet.tournamentmaker.service.PlayerService;

public class NewPlayerWindow extends Window {

	private static final long serialVersionUID = -7413305617596831145L;

	public NewPlayerWindow(PlayerService playerService) {

		this.setCaption("Add Player");

		HorizontalLayout playerForm = new HorizontalLayout();

		TextField playerName = new TextField();
		Button confirm = new Button("Add");
		confirm.addClickListener(event -> {
			playerService.postPlayer(new Player().setName(playerName.getValue()));
		});

		playerForm.addComponent(playerName);
		playerForm.addComponent(confirm);
		
		this.setContent(playerForm);
	}
}
