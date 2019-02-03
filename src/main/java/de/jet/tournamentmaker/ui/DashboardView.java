package de.jet.tournamentmaker.ui;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("dashboard")
public class DashboardView extends HorizontalLayout {

	private static final long serialVersionUID = -4379971617421474789L;

	public DashboardView() {

		this.add(new TableView());
		this.add(new PlayerView());

		setSizeFull();
	}
}