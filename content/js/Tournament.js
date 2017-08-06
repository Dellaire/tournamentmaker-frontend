var matches = new Map();

function fillMatchTable() {
	var tournaments = getContent("http://localhost:8080/tournaments");
	addTournamentList(tournaments);
	changeTournament(tournaments);
}

function addMatchesTableHeader() {
	var table = document.getElementById("matches");
	table.innerHTML = "<tr><th>Tournament name</th><th>Round name</th><th>Team 1</th><th>vs.</th><th>Team 2</th><th></th></tr>";
}

function addMatchToTable(tournamentName, roundName, match) {
	matches.set(match.id, match);

	var table = document.getElementById("matches");
	var row = table.insertRow(-1);

	var tournamentCell = row.insertCell(0);
	var roundCell = row.insertCell(1);
	var team1Cell = row.insertCell(2);
	var scoreCell = row.insertCell(3);
	var team2Cell = row.insertCell(4);
	var addScoreCell = row.insertCell(5);

	tournamentCell.innerHTML = tournamentName;
	roundCell.innerHTML = roundName;
	team1Cell.innerHTML = match.team1.player1.name + " + "
			+ match.team1.player2.name;
	scoreCell.innerHTML = match.team1Score + " : " + match.team2Score;
	team2Cell.innerHTML = match.team2.player1.name + " + "
			+ match.team2.player2.name;
	addScoreCell.innerHTML = "<form><input id=\"team1Score_"
			+ match.id
			+ "\" type=\"text\" /><input id=\"team2Score_"
			+ match.id
			+ "\" type=\"text\" /><input type=\"button\" value=\"Set score\" onclick=\"setScore('"
			+ match.id + "')\" /></form>";
}

function addTournamentList(tournaments) {
	var tournamentList = "";
	for (var i = 0; i < tournaments.length; i++) {
		tournamentList += "<option value=\"" + tournaments[i].id + "\">"
				+ tournaments[i].id + "</option>"
	}
	document.getElementById("tournamentList").innerHTML = tournamentList;
}

function changeTournament(tournaments) {
	var tournamentName = document.getElementById("tournamentList").value;

	document.getElementById("matches").innerHTML = "";
	addMatchesTableHeader(tournaments);

	var tournament = getContent("http://localhost:8080/tournaments/"
			+ tournamentName);
	for (var j = 0; j < tournament.rounds.length; j++) {
		for (var k = 0; k < tournament.rounds[j].matches.length; k++) {
			addMatchToTable(tournament.id, tournament.rounds[j].name,
					tournament.rounds[j].matches[k]);
		}
	}
}

function putRound() {
	var tournamentName = document.getElementById("tournamentList").value;
	if (headRessource("http://localhost:8080/tournaments/" + tournamentName) == 302) {
		putContent("http://localhost:8080/tournaments/" + tournamentName
				+ "/rounds/generate", null);
	} else {
		console.log("The tournament with ID '" + tournamentName
				+ "' does not exist.");
	}
}

function postTournament() {
	tournamentName = document.getElementById("tournamentName").value;
	var newTournament = {
		"id" : tournamentName
	}

	postContent("http://localhost:8080/tournaments", newTournament);
}

function setScore(matchId) {
	var team1Score = document.getElementById("team1Score_" + matchId).value;
	var team2Score = document.getElementById("team2Score_" + matchId).value;

	matches.get(matchId).team1Score = team1Score;
	matches.get(matchId).team2Score = team2Score;

	putContent("http://localhost:8080/matches", matches.get(matchId));
}