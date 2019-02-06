package de.jet.tournamentmaker.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import de.jet.tournamentmaker.model.Table;
import de.jet.tournamentmaker.service.TableService;

public class TableView extends VerticalLayout {

	private static final long serialVersionUID = 674192927867917381L;

	public TableView(TableService tableService) {

		Grid<Table> tableGrid = new Grid<>();
		tableGrid.addColumn(Table::getName).setCaption("Description");
		tableGrid.addColumn(Table::isActive).setCaption("Active");
		tableGrid.setItems(tableService.getTables());

		this.addComponent(new Button("Add Table", e -> Notification.show("Hello Spring+Vaadin user!")));
		this.addComponent(tableGrid);

		this.setWidth("400px");
		this.setHeight("500px");
	}
}