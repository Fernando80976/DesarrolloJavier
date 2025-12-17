package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.Email;
import com.example.demo.entities.Profesor;
import com.example.demo.repositories.RepositorioEmail;
import com.example.demo.repositories.RepositorioProfesor;
@Controller
public class Controlador1aN {
	RepositorioProfesor repositorioProfesor;
	RepositorioEmail repositorioEmail;
	public Controlador1aN (RepositorioProfesor repositorioProfesor,RepositorioEmail repositorioEmail) {
		this.repositorioEmail=repositorioEmail;
		this.repositorioProfesor=repositorioProfesor;
	}
@GetMapping("/crear")
public String creaObjetos(Model modelo){
	
	 
	Profesor p1=new Profesor("Javier puche");
	Profesor p2=new Profesor("Agusin aguilera");
	Email e1=new Email("javeir@edua.com");
	Email e2=new Email("javeir@.com");

	p1.AddEmail(e1);
	p1.AddEmail(e2);
//	repositorioEmail.save(e1);
//	repositorioEmail.save(e2);
	repositorioProfesor.save(p1);
	repositorioProfesor.save(p2);
modelo.addAttribute("profesor",repositorioProfesor.findAll());
	return "plantilla";
}
}
