package goya.daw2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import goya.daw2.entities.Partida;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
    // puedes añadir consultas personalizadas si quieres
}
