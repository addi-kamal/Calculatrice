<%@page import="web.SumModel"%>
<%
 SumModel model=(SumModel)request.getAttribute("sumModel");
%>

<!-- com -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Calculatrice</title>
</head>
<body>
	<div>
		<form action="calculer.do" method="post">
			<table>
				<tr>
					<td>nombre 1 :</td>
					<td><input type="number" name="nombre 1" value="<%=model.getNombre1()%>"></td>
				</tr>
				<tr>
					<td>nombre 2 :</td>
					<td><input type="number" name="nombre 2" value="<%=model.getNombre2()%>"></td>
				</tr>
			</table>
			<button type="submit">Calculer</button>
		</form>
	</div>
	<p></p>
	<div>
		somme = <% out.print(model.getSomme()); %>
	</div>
</body>
</html>