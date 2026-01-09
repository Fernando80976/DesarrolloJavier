package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity//esto quiere decir que es susceptible  a ir a base de datos
public class Cliente {
	 
	@Id//esto es decir que la variable de abajo sera el identificador
    @GeneratedValue(strategy=GenerationType.AUTO)
	//se genera automaticamente por el orm(producto que se encarga de generar el codigo de base d edatos)
	private Long id;
	    private String nombre;
	    private String apellido;
	    protected Cliente() {}
	    

	 public Cliente(String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}   
	    
		public Long getId() {
			return id;
		}
		public String getNombre() {
			return nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
		}
		
}
