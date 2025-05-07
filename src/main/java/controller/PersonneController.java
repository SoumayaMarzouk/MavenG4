package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Departement;
import model.Personne;
import model.Projet;

import java.io.IOException;
import java.util.List;

import dao.DepartementDAO;
import dao.PersonneDAO;
import dao.ProjetDAO;

/**
 * Servlet implementation class PersonneController
 */
@WebServlet("/PersonneController")
public class PersonneController extends HttpServlet {

private static final long serialVersionUID = 1L;
private PersonneDAO pdao;
private ProjetDAO prDao;
private DepartementDAO deptDao;
public PersonneController() {
	super();
	pdao=new PersonneDAO();
	deptDao=new DepartementDAO();
	prDao=new ProjetDAO();
}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String message="";
if(request.getParameter("id")!=null) {
message="suppression impossible";
long id=Long.parseLong(request.getParameter("id"));
if(pdao.delete(id))
	message="suppression de la personne "+id+" avec succes";
}
if(request.getParameter("idUpdate")!=null) {
long id=Long.parseLong(request.getParameter("idUpdate"));
Personne p =pdao.findById(id);
request.setAttribute("personne",p);

RequestDispatcher rd=getServletContext().getRequestDispatcher("/PersonneUpdate.jsp");
rd.forward(request, response);
} else if(request.getParameter("createForm")!=null) {
	List<Departement> d = deptDao.findAll();
	List<Projet> pr = prDao.findAll();
	request.setAttribute("listDept",d);
	request.setAttribute("listProj",pr);
	RequestDispatcher rd=getServletContext().getRequestDispatcher("/createPersonne.jsp");
	rd.forward(request, response);
	}

else {
List<Personne> results = pdao.findAll();
request.setAttribute("listPersonne",results);
request.setAttribute("message",message);
RequestDispatcher rd=getServletContext().getRequestDispatcher("/PersonneView1.jsp");
rd.forward(request, response); 
}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String message="";
if(request.getParameter("create")!=null) {
message="creation impossible";
String cin=request.getParameter("cin");
String prenom=request.getParameter("prenom");
String nom=request.getParameter("nom");
long dept=Long.parseLong(request.getParameter("dept"));
String projet[]=request.getParameterValues("proj");
long[] pr=new long[10];
int i=0;
for(String x:projet) {
	pr[i]=Long.parseLong(x);
	i++;
}
Personne p=new Personne(cin,nom,prenom);
if(pdao.create(p,dept,pr))
	   message="personne "+cin+" cree avec succes";
}
else if(request.getParameter("update")!=null) {
message="mise a jour impossible";
long id=Long.parseLong(request.getParameter("id"));
String cin=request.getParameter("cin");
String prenom=request.getParameter("prenom");
String nom=request.getParameter("nom");
if(pdao.update(id,cin,nom,prenom)) 
	     message="personne "+cin+" mis a jour avec succes";
}
List<Personne> results;
if(request.getParameter("select")!=null) {
	message="Liste des Personne par projet";
	long id=Long.parseLong(request.getParameter("select"));
	results=pdao.getPersonnesByProjet(id);

	}
else {
results = pdao.findAll();
}
request.setAttribute("listPersonne",results);
request.setAttribute("message",message);
RequestDispatcher rd=getServletContext().getRequestDispatcher("/PersonneView1.jsp");
rd.forward(request, response); 

}


}
