package de.jet.tournamentmaker.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import de.jet.tournamentmaker.model.Table;
import de.jet.tournamentmaker.service.TableService;

public class NewTableWindow extends Window {

	private static final long serialVersionUID = -7413305617596831145L;

	public NewTableWindow(TableService tableService, Grid<Table> tableGrid) {

		this.setCaption("Add Table");
		this.center();

		HorizontalLayout tableForm = new HorizontalLayout();

		TextField tableName = new TextField();
		Button confirm = new Button("Add");
		confirm.addClickListener(event -> {
			tableService.postTable(new Table().setName(tableName.getValue()));
			tableGrid.setItems(tableService.getTables());
		});

		tableForm.addComponent(tableName);
		tableForm.addComponent(confirm);

		this.setContent(tableForm);
	}
}
