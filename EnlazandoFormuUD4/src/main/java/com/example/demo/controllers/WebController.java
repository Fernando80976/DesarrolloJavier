package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Categoria;
import com.example.demo.entities.Partida;
import com.example.demo.entities.Participantes;
import com.example.demo.repositories.RepositorioPartida;
import com.example.demo.repositories.RepositorioParticipantes;

@Controller
public class WebController {

    private final RepositorioParticipantes repositorioParticipantes;
    private final RepositorioPartida repositorioPartida;

    public WebController(RepositorioParticipantes repositorioPa, RepositorioPartida repositorioP) {
        this.repositorioParticipantes = repositorioPa;
        this.repositorioPartida = repositorioP;
    }

    // -------------------- ETAPA 1 --------------------
    @GetMapping("/")
    public String etapa1(Model modelo) {
        modelo.addAttribute("errores", "");
        return "etapa1";
    }

    @PostMapping("/")
    public String procesarEtapa1(@RequestParam(name="nombre") String nombre,
                                 Model modelo,
                                 HttpSession session) {
        if (!compNom(nombre)) {
            modelo.addAttribute("errores", "Error: Nombre entre 2 y 30, no vacío ni numérico");
            return "etapa1";
        }

        session.setAttribute("nombre", nombre);

        // Preparar datos para etapa2
        List<String> signos = List.of(" Aries", " Tauro", " Géminis", " Cáncer");
        modelo.addAttribute("signos", signos);
        modelo.addAttribute("numEtapa", 2);
        modelo.addAttribute("errores", "");

        return "etapa2";
    }

    // -------------------- ETAPA 2 --------------------
    @PostMapping("/etapa2")
    public String procesarEtapa2(@RequestParam(required = false,name="signo") String signo,
                                 Model modelo,
                                 HttpSession session) {
        if (signo == null || signo.trim().isEmpty()) {
            modelo.addAttribute("errores", "Error: elige un signo");
            List<String> signos = List.of(" Aries", " Tauro", " Géminis", " Cáncer");
            modelo.addAttribute("signos", signos);
            modelo.addAttribute("numEtapa", 2);
            return "etapa2";
        }

        session.setAttribute("signo", signo);

        // Preparar datos para etapa3
        List<String> aficcionesLista = List.of("Deporte", "Lectura", "Videojuegos", "Música");
        modelo.addAttribute("aficciones", aficcionesLista);
        modelo.addAttribute("numEtapa", 3);
        modelo.addAttribute("errores", "");

        return "etapa3";
    }

    // -------------------- ETAPA 3 --------------------
    @PostMapping("/etapa3")
    public String procesarEtapa3(@RequestParam(required = false,name="aficciones") List<String> aficciones,
                                 Model modelo,
                                 HttpSession session) {

        if (aficciones == null || aficciones.isEmpty()) {
            aficciones = List.of("Ninguna seleccionada");
        }

        session.setAttribute("aficciones", aficciones);

        // Guardar participante y partida
        LocalDateTime ahora = LocalDateTime.now();
        String nombreUsuario = (String) session.getAttribute("nombre");
        Participantes participante = new Participantes(nombreUsuario);

        int puntos = aficciones.size();
        Categoria cat = puntos > 2 ? Categoria.EXCELENTE : Categoria.BIEN;
        Partida partida = new Partida(ahora.toString(), puntos, cat);
        participante.addPartida(partida);

        repositorioParticipantes.save(participante);
        repositorioPartida.save(partida);

        // Preparar datos para etapa4
        List<String> respuestas = new ArrayList<>();
        respuestas.add("Nombre: " + session.getAttribute("nombre"));
        respuestas.add("Signo: " + session.getAttribute("signo"));
        respuestas.add("Aficciones: " + aficciones);
        modelo.addAttribute("respuestas", respuestas);

        return "etapa4";
    }

    // -------------------- INFORMES --------------------
    @GetMapping("/reporte")
    public String reporte(Model modelo) {
        modelo.addAttribute("Puntos", repositorioPartida.findAllByOrderByPuntuacionDesc());
        modelo.addAttribute("Jugadores", repositorioParticipantes.findAllByOrderByNombreAsc());
        return "reporte";
    }

    @GetMapping("/partida/borrar")
    public String borrarPartida(@RequestParam("fecha") String fecha) {
        repositorioPartida.deleteById(fecha);
        return "redirect:/reporte";
    }

    // -------------------- UTIL --------------------
    private boolean compNom(String nom) {
        String numeros = ".*[0-9].*";
        return !(nom == null || nom.isEmpty() || nom.length() < 2 || nom.length() > 30 || nom.matches(numeros));
    }
}
