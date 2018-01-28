function getContent(url) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", url, false);
	xmlhttp.send();

	var token = xmlhttp.getResponseHeader("X-CSRF-TOKEN")
	document.querySelector('meta[name="_csrf"]').setAttribute("content", token);

	return JSON.parse(xmlhttp.responseText);
}

function getContentAsync(url, func) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = func;
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
}

function postContent(url, body) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST", url, false);

	var token = $("meta[name='_csrf']").attr("content");
	xmlhttp.setRequestHeader("X-CSRF-TOKEN", token);
	xmlhttp.setRequestHeader("Content-Type", "application/json");

	xmlhttp.send(JSON.stringify(body));
}

function postContentAsync(url, body) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST", url, true);
	var token = $("meta[name='_csrf']").attr("content");
	xmlhttp.setRequestHeader("X-CSRF-TOKEN", token);
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	xmlhttp.send(JSON.stringify(body));
}

function putContent(url, body) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("PUT", url, false);

	var token = $("meta[name='_csrf']").attr("content");
	xmlhttp.setRequestHeader("X-CSRF-TOKEN", token);
	xmlhttp.setRequestHeader("Content-Type", "application/json");

	xmlhttp.send(JSON.stringify(body));
}

function putContentAsync(url, body) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("PUT", url, true);
	var token = $("meta[name='_csrf']").attr("content");
	xmlhttp.setRequestHeader("X-CSRF-TOKEN", token);
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	xmlhttp.send(JSON.stringify(body));
}

function headRessource(url) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("HEAD", url, false);
	xmlhttp.send();

	return xmlhttp.status;
}

function headRessourceAsync(url, func) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = func;
	xmlhttp.open("HEAD", url, true);
	xmlhttp.send();
}