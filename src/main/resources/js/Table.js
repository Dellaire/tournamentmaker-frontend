var tables = new Map();

function fillTableTable() {
	document.getElementById("tables").innerHTML = "";
	addTableTableHeader();

	var tables = getContent("http://localhost:8085/table");
	for (var i = 0; i < tables.length; i++) {
		addTableToTable(tables[i]);
	}
}

function addTableTableHeader() {
	var table = document.getElementById("tables");
	table.innerHTML = "<tr><th>Name</th><th>Active</th></tr>";
}

function addTableToTable(tableToAdd) {
	tables.set(tableToAdd.id, tableToAdd);

	var table = document.getElementById("tables");
	var row = table.insertRow(-1);

	var nameCell = row.insertCell(0);
	var activeCell = row.insertCell(1);

	var active = "";
	var checkbox = "";
	if (tableToAdd.active) {
		active = "active";
		checkbox = "src/checkbox_active.png";
	} else {
		active = "inactive";
		checkbox = "src/checkbox_inactive.png";
	}

	nameCell.innerHTML = tableToAdd.name;

	activeCell.innerHTML = "<img id=\"activeTable_" + tableToAdd.id + "\" src=\""
			+ checkbox + "\" alt=\"" + active
			+ "\" style=\"cursor:pointer\" onClick=\"putTable('" + tableToAdd.id
			+ "')\">";
}

function postTable() {
	var body = {
		"name" : document.getElementById("tableName").value
	};

	postContent("http://localhost:8085/table", body);
}

function putTable(tableId) {
	var table = tables.get(tableId);
	if (document.getElementById("activeTable_" + tableId).alt == "active") {
		document.getElementById("activeTable_" + tableId).alt = "inactive";
		document.getElementById("activeTable_" + tableId).src = "src/checkbox_inactive.png";
		table.active = false;
	} else {
		document.getElementById("activeTable_" + tableId).alt = "active";
		document.getElementById("activeTable_" + tableId).src = "src/checkbox_active.png";
		table.active = true;
	}

	putContent("http://localhost:8085/table", table);
}