package de.jet.tournamentmaker.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.jet.tournamentmaker.model.Player;
import de.jet.tournamentmaker.model.Table;
import de.jet.tournamentmaker.model.Tournament;

@Component
@ConfigurationProperties("tournaments")
public class TournamentService {

	private final RestTemplate restTemplate;

	private String url;

	public TournamentService(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;
	}

	public List<Tournament> getTournaments() {

		return restTemplate
				.exchange(this.url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Tournament>>() {
				}).getBody();
	}

	public Tournament getTournament(String tournamentName) {

		return restTemplate.exchange(this.url + "/" + tournamentName, HttpMethod.GET, null,
				new ParameterizedTypeReference<Tournament>() {
				}).getBody();
	}

	public Tournament postTournament(String tournamentName) {

		HttpEntity<Tournament> playerEntity = new HttpEntity<Tournament>(new Tournament().setName(tournamentName));

		return restTemplate
				.exchange(this.url, HttpMethod.POST, playerEntity, new ParameterizedTypeReference<Tournament>() {
				}).getBody();
	}

	public List<Player> getPlayer(String tournamentName) {

		if (tournamentName == null) {
			return Arrays.asList();
		}

		return restTemplate.exchange(this.url + "/" + tournamentName + "/player", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Player>>() {
				}).getBody();
	}

	public Player addPlayer(String tournamentName, Player player) {

		HttpEntity<Player> playerEntity = new HttpEntity<Player>(player);

		return restTemplate.exchange(this.url + "/" + tournamentName + "/player", HttpMethod.PUT, playerEntity,
				new ParameterizedTypeReference<Player>() {
				}).getBody();
	}

	public List<Table> getTables(String tournamentName) {

		if (tournamentName == null) {
			return Arrays.asList();
		}

		return restTemplate.exchange(this.url + "/" + tournamentName + "/tables", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Table>>() {
				}).getBody();
	}

	public Table addTable(String tournamentName, Table table) {

		HttpEntity<Table> playerEntity = new HttpEntity<Table>(table);

		return restTemplate.exchange(this.url + "/" + tournamentName + "/tables", HttpMethod.PUT, playerEntity,
				new ParameterizedTypeReference<Table>() {
				}).getBody();
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
