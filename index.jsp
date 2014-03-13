<!DocType html>
<% String title = "test"; %>
<html>
	<head>
		<title><%= title %></title>
	</head>
	<body>
		<ul>
			<% for (int i = 1; i < 6; i++){ %>
			<li><%= i %></li>
			<% } %>
		</ul>
	</body>
</html>