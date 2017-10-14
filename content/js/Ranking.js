var statistics = new Map();
var nameOfCurrentTournament2 = "";

function fillRankingTable() {
	var tournaments = getContent("http://localhost:8085/tournaments");
	addTournamentList2(tournaments);

	if (nameOfCurrentTournament2 != "") {
		document.getElementById("tournamentList").value = nameOfCurrentTournament2;
	} else {
		nameOfCurrentTournament2 = document.getElementById("tournamentList").value;
	}

	fillRTable(tournaments);
}

function addRankingsTableHeader() {
	var table = document.getElementById("rankings");
	table.innerHTML = "<tr><th>Player name</th><th>Score</th><th>Wins</th><th>Defeats</th><th>Draws</th><th>Goals</th><th>Counter goals</th></tr>";
}

function fillRTable(tournaments) {
	document.getElementById("rankings").innerHTML = "";
	addRankingsTableHeader(tournaments);

	if (nameOfCurrentTournament2 != "") {
		var tournament = getContent("http://localhost:8085/ranking/"
				+ nameOfCurrentTournament2);
		for (var i = 0; i < tournament.length; i++) {
			addStatisticToTable(tournament[i])
		}
	}
}

function addStatisticToTable(playerStatistic) {
	statistics.set(playerStatistic.playerName, playerStatistic);

	var table = document.getElementById("rankings");
	var row = table.insertRow(-1);

	var playerNameCell = row.insertCell(0);
	var scoreCell = row.insertCell(1);
	var winsCell = row.insertCell(2);
	var defeatsCell = row.insertCell(3);
	var drawsCell = row.insertCell(4);
	var goalsCell = row.insertCell(5);
	var counterGoalsCell = row.insertCell(6);

	playerNameCell.innerHTML = playerStatistic.playerName;
	scoreCell.innerHTML = playerStatistic.score;
	winsCell.innerHTML = playerStatistic.wins;
	defeatsCell.innerHTML = playerStatistic.defeats;
	drawsCell.innerHTML = playerStatistic.draws;
	goalsCell.innerHTML = playerStatistic.goals;
	counterGoalsCell.innerHTML = playerStatistic.counterGoals;
}

function addTournamentList2(tournaments) {
	var tournamentList = "";
	for (var i = 0; i < tournaments.length; i++) {
		tournamentList += "<option value=\"" + tournaments[i].id + "\">"
				+ tournaments[i].id + "</option>"
	}
	document.getElementById("tournamentList2").innerHTML = tournamentList;
}