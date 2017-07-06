function fillPlayersTable() {
	document.getElementById("players").innerHTML = "";
	addHeader();

	var players = getContent("http://localhost:8081/player");
	for (var i = 0; i < players.length; i++) {
		addPlayerToTable(players[i], i);
	}
}

function addHeader() {
	var table = document.getElementById("players");
	var row = table.insertRow(0);

	var idCell = row.insertCell(0);
	var nameCell = row.insertCell(1);
	var eloCell = row.insertCell(2);
	var activeCell = row.insertCell(3);

	idCell.innerHTML = "ID";
	nameCell.innerHTML = "Name";
	eloCell.innerHTML = "Elo";
	activeCell.innerHTML = "Active";
}

function addPlayerToTable(player, row) {
	var table = document.getElementById("players");
	var row = table.insertRow(row + 1);

	var idCell = row.insertCell(0);
	var nameCell = row.insertCell(1);
	var eloCell = row.insertCell(2);
	var activeCell = row.insertCell(3);

	idCell.innerHTML = player.id;
	nameCell.innerHTML = player.name;
	eloCell.innerHTML = player.elo;
	activeCell.innerHTML = player.active;
}

function getContent(url) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", url, false);
	xmlhttp.send();

	return JSON.parse(xmlhttp.responseText);
}

function postContent(url, content) {
	// TODO execute POST request

	return content;
}