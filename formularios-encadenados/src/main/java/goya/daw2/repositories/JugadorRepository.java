package goya.daw2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import goya.daw2.entities.Jugador;
import java.util.Optional;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    Optional<Jugador> findByNombre(String nombre);
}

