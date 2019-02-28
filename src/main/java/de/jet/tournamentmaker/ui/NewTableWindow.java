package de.jet.tournamentmaker.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import de.jet.tournamentmaker.model.Table;
import de.jet.tournamentmaker.services.TournamentService;

public class NewTableWindow extends Window {

	private static final long serialVersionUID = -7413305617596831145L;

	public NewTableWindow(TournamentService tournamentService, ValueStore valueStore, Grid<Table> tableGrid) {

		this.setCaption("Add Table");
		this.center();
		this.setModal(true);

		HorizontalLayout tableForm = new HorizontalLayout();

		TextField tableName = new TextField();
		Button confirm = new Button("Add");
		confirm.addClickListener(event -> {
			tournamentService.addTable(valueStore.getTournamentName(), new Table().setName(tableName.getValue()));
			tableGrid.setItems(tournamentService.getTables(valueStore.getTournamentName()));
			this.close();
		});

		tableForm.addComponent(tableName);
		tableForm.addComponent(confirm);

		this.setContent(tableForm);
	}
}
