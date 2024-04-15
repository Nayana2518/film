<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.Film"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<%
	List<Film> list = (List<Film>) request.getAttribute("list");
	Film mo=new Film();
	%>
	<h1 align="center">FILM DETAILS</h1>
	<br>
	<div align="center">
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Image</th>
				<th>Language</th>
				<th>Genre</th>
				<th>Rating</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<%
			for (Film film : list) {
			%>
			<tr>
				<th><%=film.getName()%></th>
				<th><img height="75px" width="75px" alt="<%=film.getName()%>"
					src="data:image/jpeg;base64,<%=Base64.encodeBase64String(film.getPicture())%>"></th>
			
				<th><%=film.getLanguage()%></th>
				<th><%=film.getGenre()%></th>
				<th><%=film.getRating()%></th>
				<th><button>Edit</button></th>
				<th><button>Delete</button></th>
			</tr>
			<%
			}
			%>

		</table>
		<br> <a href="home.html"><button>EXIT</button></a>
	</div>
</body>

</html>