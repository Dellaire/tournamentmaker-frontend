function getContent(url) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", url, false);
	xmlhttp.send();

	return JSON.parse(xmlhttp.responseText);
}

function postContent(url, content) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST", url, false);
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	xmlhttp.send(JSON.stringify(content));
}

function putContent(url) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("PUT", url, false);
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	xmlhttp.send();
}