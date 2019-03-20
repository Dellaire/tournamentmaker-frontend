package de.jet.tournamentmaker.ui;

import java.util.function.Supplier;

import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import de.jet.tournamentmaker.model.Player;
import de.jet.tournamentmaker.services.TournamentService;

public class NewPlayerWindow extends Window {

	private static final long serialVersionUID = -7413305617596831145L;

	public NewPlayerWindow(TournamentService tournamentService, Supplier<String> tournamentNameSupplier, Grid<Player> playerGrid) {

		this.setCaption("Add Player");
		this.center();
		this.setModal(true);

		HorizontalLayout playerForm = new HorizontalLayout();

		TextField playerName = new TextField();
		playerName.focus();
		
		Button confirm = new Button("Add");
		confirm.addClickListener(event -> {
			tournamentService.addPlayer(tournamentNameSupplier.get(), new Player().setName(playerName.getValue()));
			playerGrid.setItems(tournamentService.getPlayer(tournamentNameSupplier.get()));
			this.close();
		});

		playerForm.addComponent(playerName);
		playerForm.addComponent(confirm);

		this.setContent(playerForm);
	}
}
