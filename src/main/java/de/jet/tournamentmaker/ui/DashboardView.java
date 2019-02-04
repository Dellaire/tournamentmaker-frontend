package de.jet.tournamentmaker.ui;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("dashboard")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DashboardView extends HorizontalLayout {

	private static final long serialVersionUID = -4379971617421474789L;

	public DashboardView(TableView tableView, PlayerView playerView) {

		this.add(tableView);
		this.add(playerView);

		setSizeFull();
	}
}