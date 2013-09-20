function getParam(href, paramName) {
	var args = href.split("?");
	if (args[0] == href) {
		return "";
	}
	var str = args[1];
	args = str.split('&');
	for ( var i = 0; i < args.length; i++) {
		str = args[i];
		var arg = str.split('=');
		if (arg.length <= 1) {
			continue;
		} else if (args[0] == paramName) {
			return arg[1];
		}
	}
}

function jumpTo(str){
window.location.href = str;
}
