package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Pelicula;
import com.example.demo.repositories.RepositorioPelicula;

@Service
public class ServicioPeliculas {

    private final RepositorioPelicula repositorioPelicula;

    public ServicioPeliculas(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }

    public List<Pelicula> findAll() {
        return repositorioPelicula.findAll();
    }

    public Optional<Pelicula> findById(Long id) {
        return repositorioPelicula.findById(id);
    }

    public Pelicula save(Pelicula pelicula) {
        return repositorioPelicula.save(pelicula);
    }

    public void delete(Pelicula pelicula) {
        repositorioPelicula.delete(pelicula);
    }
}
