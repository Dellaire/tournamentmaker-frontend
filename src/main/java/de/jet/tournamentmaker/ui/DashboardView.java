package de.jet.tournamentmaker.ui;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.flow.router.Route;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
//import com.vaadin.spring.annotation.SpringUI

import de.jet.tournamentmaker.service.PlayerService;
import de.jet.tournamentmaker.service.TableService;

@Route("dashboard")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@SpringUI(path = "dashboard")
@Component
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