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
	var row = table.insertRow(-1);

	var nameCell = row.insertCell(0);
	var eloCell = row.insertCell(1);
	var activeCell = row.insertCell(2);

	nameCell.innerHTML = "Name";
	eloCell.innerHTML = "Elo";
	activeCell.innerHTML = "Active";
}

function addPlayerToTable(player) {
	players.set(player.id, player);

	var table = document.getElementById("players");
	var row = table.insertRow(-1);

	var nameCell = row.insertCell(0);
	var eloCell = row.insertCell(1);
	var activeCell = row.insertCell(2);

	var active = "";
	var checkbox = "";
	if (player.active) {
		active = "active";
		checkbox = "src/checkbox_active.png";
	} else {
		active = "inactive";
		checkbox = "src/checkbox_inactive.png";
	}

	nameCell.innerHTML = player.name;
	eloCell.innerHTML = player.elo;

	activeCell.innerHTML = "<img id=\"activePlayer_" + player.id + "\" src=\""
			+ checkbox + "\" alt=\"" + active + "\" onClick=\"putPlayer('"
			+ player.id + "')\">";
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
	if (document.getElementById("activePlayer_" + playerId).alt == "active") {
		document.getElementById("activePlayer_" + playerId).alt = "inactive";
		player.active = false;
	} else {
		document.getElementById("activePlayer_" + playerId).alt = "active";
		player.active = true;
	}

	putContent("http://localhost:8081/player", player);
	fillPlayerTable();
}