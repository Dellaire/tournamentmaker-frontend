function fillTournamentTable() {
	document.getElementById("tournaments").innerHTML = "";

	var table = document.getElementById("tournaments");
	var row = table.insertRow(0);
	var cell = row.insertCell(0);
	cell.innerHTML = JSON
			.stringify(getContent("http://localhost:8080/tournaments"));
}