<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,model.Projet,model.Departement" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="PersonneController" method=post>
CIN : <input type=text name=cin><br>
Nom : <input type=text name=nom><br>
Prenom : <input type=text name=prenom><br>
Liste Departement

<select name=dept>
	      	<c:forEach items="${listDept}" var="d" varStatus="status">
				<option value=${d.id} > ${d.nom}  </option>
			</c:forEach>
</select><br>
Liste des projets<br>

	      	<c:forEach items="${listProj}" var="pr" varStatus="status">
				<input type=checkbox value='${pr.id}' name=proj> ${pr.nom}<br>
			</c:forEach>
<input type=submit name=create value=Ajouter ><br>
</form>
</body>
</html>