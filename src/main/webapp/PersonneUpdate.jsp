<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,model.Personne" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<form action="PersonneController" method=post>
ID : <input type=text name=id value='${personne.id}'><br>
CIN : <input type=text name=cin value='${personne.cin}'><br>
Nom : <input type=text name=nom value='${personne.nom}'><br>
Prenom : <input type=text name=prenom value='${personne.prenom}'><br>
<input type=submit name=update value=Update ><br>
</form>
</body>
</html>  