package de.jet.tournamentmaker.ui;

import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import de.jet.tournamentmaker.model.Table;
import de.jet.tournamentmaker.services.TournamentService;

@Component
public class TableView extends VerticalLayout implements View {

	private static final long serialVersionUID = 674192927867917381L;

	private final Grid<Table> tableGrid = new Grid<Table>();
	private final TournamentService tournamentService;
	private Supplier<String> tournamentNameSupplier;

	public TableView(TournamentService tournamentService) {

		this.tournamentService = tournamentService;

		this.tableGrid.addColumn(Table::getName).setCaption("Description");
		this.tableGrid.addColumn(Table::isActive).setCaption("Active");
		if (this.tournamentNameSupplier != null)
			this.reloadTables(this.tournamentNameSupplier.get());

		this.addComponent(new Button("Add Table", e -> {
			this.getViewComponent().getUI()
					.addWindow(new NewTableWindow(this.tournamentService, this.tournamentNameSupplier, tableGrid));
		}));
		this.addComponent(tableGrid);
	}

	public void setTournamentNameSupplier(Supplier<String> tournamentNameSupplier) {
		this.tournamentNameSupplier = tournamentNameSupplier;
	}
	
	public void reloadTables(String tournamentName) {
		this.tableGrid.setItems(this.tournamentService.getTables(tournamentName));
	}
}