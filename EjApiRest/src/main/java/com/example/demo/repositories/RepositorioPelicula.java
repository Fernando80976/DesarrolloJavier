package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pelicula;


public interface RepositorioPelicula extends JpaRepository<Pelicula, Long> {

}