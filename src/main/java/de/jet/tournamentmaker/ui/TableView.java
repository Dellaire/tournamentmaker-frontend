package de.jet.tournamentmaker.ui;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.jet.tournamentmaker.model.Table;

@Route("tables")
public class TableView extends VerticalLayout {

	private static final long serialVersionUID = 674192927867917381L;

	private RestTemplate restTemplate = new RestTemplate();

	public TableView() {

		Grid<Table> tableGrid = new Grid<>();
		tableGrid.addColumn(Table::getName).setHeader("Description");
		tableGrid.addColumn(Table::isActive).setHeader("Active");

		List<Table> tables = this.restTemplate.exchange("http://localhost:8080/tables", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Table>>() {
				}).getBody();
		tableGrid.setItems(tables);

		this.add(new Button("Add Table", e -> Notification.show("Hello Spring+Vaadin user!")));
		this.add(tableGrid);

		this.setWidth("400px");
		this.setHeight("500px");
	}
}