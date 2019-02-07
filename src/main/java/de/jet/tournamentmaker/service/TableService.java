package de.jet.tournamentmaker.service;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.jet.tournamentmaker.model.Table;

@Component
@ConfigurationProperties("tables")
public class TableService {

	private final RestTemplate restTemplate;

	private String url;

	public TableService(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;
	}

	public List<Table> getTables() {

		return restTemplate.exchange(this.url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Table>>() {
		}).getBody();
	}
	
	public Table postTable(Table table) {

		HttpEntity<Table> playerEntity = new HttpEntity<Table>(table);

		return restTemplate.exchange(this.url, HttpMethod.POST, playerEntity, new ParameterizedTypeReference<Table>() {
		}).getBody();
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
