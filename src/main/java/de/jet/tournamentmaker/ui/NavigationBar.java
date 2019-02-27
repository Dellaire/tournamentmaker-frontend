package de.jet.tournamentmaker.ui;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

@Component
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
	
	public void setCallback(Consumer<String> callback) {
		this.tournamentPanel.setCallback(callback);
	}
}
