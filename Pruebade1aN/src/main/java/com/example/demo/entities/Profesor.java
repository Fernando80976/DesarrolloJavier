package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Profesor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 Long id;
 String nombre;
 
 @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)

 Set<Email> emails= new HashSet<Email>();
 
 public Profesor() {
	super();
}
 public  void AddEmail(Email email) {
	 emails.add(email);
	 email.setProfesor(this);
 }
 public void delEmail(Email email) {
	    emails.remove(email);
	    email.setProfesor(null);
	}

 public Profesor(String nombre) {
	super();
	this.nombre = nombre;
}
 public Long getId() {
	return id;
 }
 public void setId(Long id) {
	this.id = id;
 }
 public String getNombre() {
	return nombre;
 }
 public void setNombre(String nombre) {
	this.nombre = nombre;
 }
 
 
 
 
}
