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
<% List<Projet> pr=(List<Projet>)request.getAttribute("listProj");
List<Departement> d=(List<Departement>)request.getAttribute("listDept");%>
<form action="PersonneController" method=post>
CIN : <input type=text name=cin><br>
Nom : <input type=text name=nom><br>
Prenom : <input type=text name=prenom><br>
Liste Departement

<select name=dept>
<% for(Departement x:d){ %>
<option value=<%=x.getId() %>> <%=x.getNom() %> </option>
<% } %>
</select><br>
Liste des projets<br>
<% for(Projet x:pr){ %>
<input type=checkbox value=<%=x.getId() %> name=proj> <%=x.getNom() %><br>
<% } %>

<input type=submit name=create value=Ajouter ><br>
</form>
</body>
</html>