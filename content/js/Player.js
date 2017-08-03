var players = new Map();

function fillPlayerTable() {
	document.getElementById("players").innerHTML = "";
	addTableHeader();

	var players = getContent("http://localhost:8081/player");
	for (var i = 0; i < players.length; i++) {
		addPlayerToTable(players[i]);
	}
}

function addTableHeader() {
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

function addPlayerToTable(player) {
	players.set(player.id, player);

	var table = document.getElementById("players");
	var row = table.insertRow(-1);

	var idCell = row.insertCell(0);
	var nameCell = row.insertCell(1);
	var eloCell = row.insertCell(2);
	var activeCell = row.insertCell(3);

	var checked = "";
	if (player.active) {
		checked = "checked=\"checked\"";
	}

	idCell.innerHTML = player.id;
	nameCell.innerHTML = player.name;
	eloCell.innerHTML = player.elo;
	activeCell.innerHTML = "<form><input type=\"checkbox\" id=\"activePlayer_"
			+ player.id + "\" value=\"active\" " + checked
			+ " onClick=\"putPlayer('" + player.id + "')\"></form>";
}

function postPlayer() {
	var playerName = document.getElementById("playerName").value;
	var body = {
		"name" : playerName
	};

	postContent("http://localhost:8081/player", body);
}

function putPlayer(playerId) {
	var player = players.get(playerId);
	player.active = document.getElementById("activePlayer_" + playerId).checked;

	putContent("http://localhost:8081/player", player);
}