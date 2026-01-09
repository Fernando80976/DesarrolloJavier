package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id; 
	String gmail;
	
	@ManyToOne
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;
	public Email() {
	}

	public Email(String gmail) {
		super();
		this.gmail = gmail;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	 
	

}
