function fillMatchTable() {
	document.getElementById("matches").innerHTML = "";
	addTableHeader();

	var matches = getContent("http://localhost:8080/tournaments")[0].rounds[0].matches;
	for (var i = 0; i < matches.length; i++) {
		addMatchToTable(matches[i], i);
	}
}

function addMatchToTable(match, row) {
	var table = document.getElementById("matches");
	var row = table.insertRow(row);

	var team1Cell = row.insertCell(0);
	var scoreCell = row.insertCell(1);
	var team2Cell = row.insertCell(2);

	team1Cell.innerHTML = match.team1.player1.name + " + "
			+ match.team1.player2.name;
	scoreCell.innerHTML = match.team1Score + " : " + match.team2Score;
	team2Cell.innerHTML = match.team2.player1.name + " + "
			+ match.team2.player2.name;
}