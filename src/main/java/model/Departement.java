
package model;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Departement")
public class Departement {
@Id @GeneratedValue
@Column(name = "id")
private int id;

@Column(name = "nom")
private String nom;

//Constructeur sans paramètres 

@OneToMany(mappedBy="department")
private List<Personne> personnes;

public Departement() {
	super();
	// TODO Auto-generated constructor stub
}

public Departement(String nom) {
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


