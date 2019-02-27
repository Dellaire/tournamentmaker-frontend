package de.jet.tournamentmaker.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import de.jet.tournamentmaker.model.Player;
import de.jet.tournamentmaker.services.TournamentService;

public class NewPlayerWindow extends Window {

	private static final long serialVersionUID = -7413305617596831145L;

	public NewPlayerWindow(TournamentService tournamentService, ValueStore valueStore, Grid<Player> playerGrid) {

		this.setCaption("Add Player");
		this.center();
		this.setModal(true);

		HorizontalLayout playerForm = new HorizontalLayout();

		TextField playerName = new TextField();
		Button confirm = new Button("Add");
		confirm.addClickListener(event -> {
			tournamentService.addPlayer(valueStore.getTournamentName(), new Player().setName(playerName.getValue()));
			playerGrid.setItems(tournamentService.getPlayer(valueStore.getTournamentName()));
			this.close();
		});

		playerForm.addComponent(playerName);
		playerForm.addComponent(confirm);

		this.setContent(playerForm);
	}
}
