package de.jet.tournamentmaker.ui;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

import de.jet.tournamentmaker.services.PlayerService;
import de.jet.tournamentmaker.services.TableService;

@SpringUI(path = "settings")
@StyleSheet("style.scss")
public class DashboardView extends UI {

	private static final long serialVersionUID = -4379971617421474789L;

	private final PlayerService playerService;
	private final TableService tableService;

	public DashboardView(PlayerService playerService, TableService tableService) {

		this.playerService = playerService;
		this.tableService = tableService;
	}

	@Override
	protected void init(VaadinRequest request) {

		HorizontalLayout content = new HorizontalLayout();
		this.setContent(content);

		content.addComponent(new PlayerView(this.playerService));
		content.addComponent(new TableView(this.tableService));
	}
}