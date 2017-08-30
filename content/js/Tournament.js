var matches = new Map();
var nameOfCurrentTournament = "";

function fillMatchTable() {
	var tournaments = getContent("http://localhost:8080/tournaments");
	addTournamentList(tournaments);

	if (nameOfCurrentTournament != "") {
		document.getElementById("tournamentList").value = nameOfCurrentTournament;
	} else {
		nameOfCurrentTournament = document.getElementById("tournamentList").value;
	}

	fillTable(tournaments);
}

function addMatchesTableHeader() {
	var table = document.getElementById("matches");
	table.innerHTML = "<tr><th>Tournament name</th><th>Round name</th><th>Team 1</th><th>vs.</th><th>Team 2</th><th>Table</th><th></th></tr>";
}

function fillTable(tournaments) {
	document.getElementById("matches").innerHTML = "";
	addMatchesTableHeader(tournaments);

	var tournament = getContent("http://localhost:8080/tournaments/"
			+ nameOfCurrentTournament);
	if (tournament.rounds != null) {
		for (var j = 0; j < tournament.rounds.length; j++) {
			for (var k = 0; k < tournament.rounds[j].matches.length; k++) {
				addMatchToTable(tournament.id, tournament.rounds[j].name,
						tournament.rounds[j].matches[k]);
			}
		}
	}
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
	var tableCell = row.insertCell(5);
	var addScoreCell = row.insertCell(6);

	tournamentCell.innerHTML = tournamentName;
	roundCell.innerHTML = roundName;
	team1Cell.innerHTML = match.team1.player1.name + " + "
			+ match.team1.player2.name;
	scoreCell.innerHTML = match.team1Score + " : " + match.team2Score;
	team2Cell.innerHTML = match.team2.player1.name + " + "
			+ match.team2.player2.name;
	tableCell.innerHTML = match.tableName;
	addScoreCell.innerHTML = "<form><input id=\"team1Score_"
			+ roundName
			+ "_"
			+ match.id
			+ "\" type=\"text\" /><input id=\"team2Score_"
			+ roundName
			+ "_"
			+ match.id
			+ "\" type=\"text\" /><input type=\"button\" value=\"Set score\" onclick=\"setScore('"
			+ roundName + "', '" + match.id + "')\" /></form>";
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
	nameOfCurrentTournament = document.getElementById("tournamentList").value;

	fillTable(tournaments);
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

function setScore(roundName, matchId) {
	var team1Score = document.getElementById("team1Score_" + roundName + "_"
			+ matchId).value;
	var team2Score = document.getElementById("team2Score_" + roundName + "_"
			+ matchId).value;

	matches.get(matchId).team1Score = team1Score;
	matches.get(matchId).team2Score = team2Score;

	putContent("http://localhost:8080/tournaments/" + nameOfCurrentTournament
			+ "/rounds/" + roundName + "/matches", matches.get(matchId));
}