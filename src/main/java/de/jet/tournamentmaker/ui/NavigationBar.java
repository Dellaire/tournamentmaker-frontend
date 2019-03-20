package de.jet.tournamentmaker.ui;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NavigationBar extends Panel {

	private static final long serialVersionUID = -1869077464466862111L;

	private TournamentPanel tournamentPanel;

	public NavigationBar(TournamentPanel tournamentPanel) {

		this.tournamentPanel = tournamentPanel;

		HorizontalLayout content = new HorizontalLayout();
		this.setContent(content);

		tournamentPanel.initialize();
		content.addComponent(tournamentPanel);
	}

	public void setCallback(Notification callback) {
		this.tournamentPanel.setCallback(callback);
	}

	public String getTournamentName() {
		return this.tournamentPanel.getTournamentName();
	}
}
