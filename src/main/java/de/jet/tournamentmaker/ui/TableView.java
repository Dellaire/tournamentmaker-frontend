package de.jet.tournamentmaker.ui;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.jet.tournamentmaker.model.Table;
import de.jet.tournamentmaker.service.TableService;

@Route("tables")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TableView extends VerticalLayout {

	private static final long serialVersionUID = 674192927867917381L;

	public TableView(TableService tableService) {

		Grid<Table> tableGrid = new Grid<>();
		tableGrid.addColumn(Table::getName).setHeader("Description");
		tableGrid.addColumn(Table::isActive).setHeader("Active");
		tableGrid.setItems(tableService.getTables());

		this.add(new Button("Add Table", e -> Notification.show("Hello Spring+Vaadin user!")));
		this.add(tableGrid);

		this.setWidth("400px");
		this.setHeight("500px");
	}
}