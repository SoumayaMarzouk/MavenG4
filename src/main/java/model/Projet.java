package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Projet")
public class Projet {
@Id @GeneratedValue
@Column(name = "id")
private int id;

@Column(name = "nom")
private String nom;

//Constructeur sans paramètres 

@ManyToMany(mappedBy="projets")
private List<Personne> personnes;

public Projet() {
	super();
	// TODO Auto-generated constructor stub
}

public Projet(String nom) {
	super();
	this.nom = nom;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public List<Personne> getPersonnes() {
	return personnes;
}

public void setPersonnes(List<Personne> personnes) {
	this.personnes = personnes;
}


}
