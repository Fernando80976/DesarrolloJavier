package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Email;



public interface RepositorioEmail extends CrudRepository<Email, Long>{

}
