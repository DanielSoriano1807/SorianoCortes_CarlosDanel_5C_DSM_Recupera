package com.carlos.recupera.Repositorio;

import com.carlos.recupera.Datos.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PartidaRepositorio extends JpaRepository<Partida, Long> {
    List<Partida> findByJugadorId(Long jugadorId);
}
