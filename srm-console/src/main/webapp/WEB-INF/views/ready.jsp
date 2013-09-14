<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>

<P>  The time on the server is ${nowtime}</P>
<p>  Test userDao.countAll() == ${countAll}</p>
<p>  Test Pojo is ${pojo }</p>
</body>
</html>
