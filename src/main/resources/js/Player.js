var players = new Map();

function fillPlayerTable() {
	document.getElementById("players").innerHTML = "";
	addPlayerTableHeader();

	var players;
	var func = function() {
		if (this.readyState == 4 && this.status == 200) {
			players = JSON.parse(this.responseText);
			for (var i = 0; i < players.length; i++) {
				addPlayerToTable(players[i]);
			}
			
			var token = this.getResponseHeader("X-CSRF-TOKEN")
			document.querySelector('meta[name="_csrf"]').setAttribute("content", token);
		}
	};
	getContentAsync("http://localhost:8085/player", func);
}

function addPlayerTableHeader() {
	var table = document.getElementById("players");
	table.innerHTML = "<tr><th>Name</th><th>Elo</th><th>Active</th></tr>";
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
			+ checkbox + "\" alt=\"" + active
			+ "\" style=\"cursor:pointer\" onClick=\"putPlayer('" + player.id
			+ "')\">";
}

function postPlayer() {
	var playerName = document.getElementById("playerName").value;
	var body = {
		"name" : playerName
	};
	
	postContentAsync("http://localhost:8085/player", body);
}

function putPlayer(playerId) {
	var player = players.get(playerId);
	if (document.getElementById("activePlayer_" + playerId).alt == "active") {
		document.getElementById("activePlayer_" + playerId).alt = "inactive";
		document.getElementById("activePlayer_" + playerId).src = "src/checkbox_inactive.png";
		player.active = false;
	} else {
		document.getElementById("activePlayer_" + playerId).alt = "active";
		document.getElementById("activePlayer_" + playerId).src = "src/checkbox_active.png";
		player.active = true;
	}

	putContentAsync("http://localhost:8085/player", player);
}