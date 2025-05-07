<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head> <meta charset="utf-8"> <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> </head> 
<h1> Liste des personnes</h1>
<div class="container mt-4">
<c:if test="${message!='' }" >
<div class="alert alert-dismissible alert-secondary">
<strong> ${message} </strong>.
</div>
</c:if>
<a href='PersonneController?createForm=ok' class="btn btn-success">Create</a>
<form action=PersonneController method=post>
Select Project <input type=text name=select>
<input type=submit></form>
<table class="table table-hover">
<tr class="table-primary"><th>Id</th><th>Cin</th><th>Nom</th><th>Prenom</th><th>Departement</th><th>Projets</th> <th>Actions</th></tr>

<c:forEach items="${listPersonne}" var="p" varStatus="status">

	<tr><td> ${p.id} </td><td> ${p.cin}
	      </td> <td>${p.nom}</td> <td>${p.prenom}</td>  <td>${p.department.nom}</td>
	      <td>
	      	<c:forEach items="${p.projets}" var="pr" varStatus="status">
				${pr.nom}<br>
			</c:forEach>
			</td>
	       <td><a href='PersonneController?idUpdate=${p.id}' class="btn btn-success">Editer</a> 
	              <a href='PersonneController?id=${p.id}' class="btn btn-danger">supprimer</a></td>
	</tr>
</c:forEach></table></div>
