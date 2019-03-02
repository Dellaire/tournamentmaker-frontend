package de.jet.tournamentmaker.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "tournament")
public class TournamentView extends UI {

	private static final long serialVersionUID = 4410538572843013449L;

	private final NavigationBar navigationBar;
	private final MatchesView matchesView;

	public TournamentView(NavigationBar navigationBar, MatchesView matchesView) {

		this.navigationBar = navigationBar;
		this.matchesView = matchesView;

		VerticalLayout content = new VerticalLayout();
		this.setContent(content);

		HorizontalLayout body = new HorizontalLayout();
		body.addComponent(this.matchesView);

		content.addComponent(this.navigationBar);
		content.addComponent(body);
	}

	@Override
	protected void init(VaadinRequest request) {

	}
}