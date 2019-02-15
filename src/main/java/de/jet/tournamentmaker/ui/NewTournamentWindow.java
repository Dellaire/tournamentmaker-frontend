package de.jet.tournamentmaker.ui;

import java.util.function.Consumer;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import de.jet.tournamentmaker.services.TournamentService;

public class NewTournamentWindow extends Window {

	private static final long serialVersionUID = -7413305617596831145L;

	public NewTournamentWindow(TournamentService tournamentService, Notification notification) {

		this.setCaption("Add Tournament");
		this.center();

		HorizontalLayout tournamentForm = new HorizontalLayout();

		TextField tournamentName = new TextField();
		Button confirm = new Button("Add");
		confirm.addClickListener(event -> {
			tournamentService.postTournament(tournamentName.getValue());
			notification.trigger();
		});

		tournamentForm.addComponent(tournamentName);
		tournamentForm.addComponent(confirm);

		this.setContent(tournamentForm);
	}
}
