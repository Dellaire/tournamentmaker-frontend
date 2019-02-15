package de.jet.tournamentmaker.ui;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import de.jet.tournamentmaker.model.Table;
import de.jet.tournamentmaker.services.TableService;

public class TableView extends VerticalLayout implements View {

	private static final long serialVersionUID = 674192927867917381L;

	public TableView(TableService tableService) {

		Grid<Table> tableGrid = new Grid<>();
		tableGrid.addColumn(Table::getName).setCaption("Description");
		tableGrid.addColumn(Table::isActive).setCaption("Active");
		tableGrid.setItems(tableService.getTables());

		this.addComponent(new Button("Add Table", e -> {
			this.getViewComponent().getUI().addWindow(new NewTableWindow(tableService, tableGrid));
		}));
		this.addComponent(tableGrid);
	}
}