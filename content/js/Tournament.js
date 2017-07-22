function fillMatchTable() {
	document.getElementById("matches").innerHTML = "";
	addTableHeader();

	addMatchesTableHeader();

	var tournaments = getContent("http://localhost:8080/tournaments");
	for (var i = 0; i < tournaments.length; i++) {
		for (var j = 0; j < tournaments[i].rounds.length; j++) {
			for (var k = 0; k < tournaments[i].rounds[j].matches.length; k++) {
				addMatchToTable(tournaments[i].id,
						tournaments[i].rounds[j].name,
						tournaments[i].rounds[j].matches[k]);
			}
		}
	}
}

function addMatchesTableHeader() {
	var table = document.getElementById("matches");
	var row = table.insertRow(0);

	var tournamentCell = row.insertCell(0);
	var roundCell = row.insertCell(1);
	var team1Cell = row.insertCell(2);
	var scoreCell = row.insertCell(3);
	var team2Cell = row.insertCell(4);

	tournamentCell.innerHTML = "Tournament name";
	roundCell.innerHTML = "Round name";
	team1Cell.innerHTML = "Team 1";
	scoreCell.innerHTML = "vs.";
	team2Cell.innerHTML = "Team 2";
}

function addMatchToTable(tournamentName, roundName, match) {
	var table = document.getElementById("matches");
	var row = table.insertRow(-1);

	var tournamentCell = row.insertCell(0);
	var roundCell = row.insertCell(1);
	var team1Cell = row.insertCell(2);
	var scoreCell = row.insertCell(3);
	var team2Cell = row.insertCell(4);

	tournamentCell.innerHTML = tournamentName;
	roundCell.innerHTML = roundName;
	team1Cell.innerHTML = match.team1.player1.name + " + "
			+ match.team1.player2.name;
	scoreCell.innerHTML = match.team1Score + " : " + match.team2Score;
	team2Cell.innerHTML = match.team2.player1.name + " + "
			+ match.team2.player2.name;
}

function putRound() {
	var tournamentName = document.getElementById("tournamentName").value;
	putContent("http://localhost:8080/tournaments/" + tournamentName
			+ "/rounds/generate");
}

function postTournament() {
	var tournamentName = document.getElementById("tournamentName").value;
	var body = {
		"id" : tournamentName
	};

	postContent("http://localhost:8080/tournaments", body);
}