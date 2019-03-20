package de.jet.tournamentmaker.ui;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "settings")
@StyleSheet("style.scss")
public class SettingsView extends UI {

	private static final long serialVersionUID = -4379971617421474789L;

	private final NavigationBar navigationBar;
	private final PlayerView playerView;
	private final TableView tableView;

	public SettingsView(NavigationBar navigationBar, PlayerView playerView, TableView tableView) {

		this.navigationBar = navigationBar;
		this.playerView = playerView;
		this.playerView.setTournamentNameSupplier(() -> this.navigationBar.getTournamentName());
		this.tableView = tableView;
		this.tableView.setTournamentNameSupplier(() -> this.navigationBar.getTournamentName());

		Notification callback = () -> {
			this.playerView.reloadPlayer(this.navigationBar.getTournamentName());
			this.tableView.reloadTables(this.navigationBar.getTournamentName());
		};

		this.navigationBar.setCallback(callback);
	}

	@Override
	protected void init(VaadinRequest request) {

		VerticalLayout content = new VerticalLayout();
		this.setContent(content);

		HorizontalLayout body = new HorizontalLayout();
		body.addComponent(this.playerView);
		body.addComponent(this.tableView);

		content.addComponent(this.navigationBar);
		content.addComponent(body);
	}
}