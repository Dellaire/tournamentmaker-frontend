package de.jet.tournamentmaker.service;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.jet.tournamentmaker.model.Player;

@Component
@ConfigurationProperties("player")
public class PlayerService {

	private final RestTemplate restTemplate;

	private String url;

	public PlayerService(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;
	}

	public List<Player> getPlayer() {

		return restTemplate.exchange(this.url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Player>>() {
		}).getBody();
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
