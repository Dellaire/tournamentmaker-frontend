function getContent(url) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", url, false);
	xmlhttp.send();

	return JSON.parse(xmlhttp.responseText);
}

function postContent(url, body) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST", url, false);
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	xmlhttp.send(JSON.stringify(body));
}

function putContent(url, body) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("PUT", url, false);
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	xmlhttp.send(JSON.stringify(body));
}

function headRessource(url) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("HEAD", url, false);
	xmlhttp.send();

	return xmlhttp.status;
}