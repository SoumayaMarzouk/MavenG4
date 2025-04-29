package model;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Personne")
public class Personne {
@Id @GeneratedValue
@Column(name = "id")
private int id;
@Column(name = "cin") 
private String cin;
@Column(name = "nom")
private String nom;
@Column(name = "prenom")
private String prenom;
@ManyToOne 
@JoinColumn(name = "department_id") 
private Departement department; 
//(fetch = FetchType.EAGER)
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "personne_projet", 
	joinColumns = @JoinColumn(name = "personne_id"), 
	inverseJoinColumns = @JoinColumn(name = "projet_id")) 
private List<Projet> projets; 

//Constructeur sans paramètres 
public Personne() {
	super();
}
public Personne(String cin, String nom, String prenom, Departement department) {
	super();
	this.cin = cin;
	this.nom = nom;
	this.prenom = prenom;
	this.department = department;
}
public List<Projet> getProjets() {
	return projets;
}
public void setProjets(List<Projet> projets) {
	this.projets = projets;
}
public Personne(String cin, String nom, String prenom) {
	super();
	this.cin = cin;
	this.nom = nom;
	this.prenom = prenom;
}
public Departement getDepartment() {
	return department;
}
public void setDepartment(Departement department) {
	this.department = department;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

//Constructeur avec paramètres (cin,nom,prenom)

//Ajouter les getters et les setters


}



