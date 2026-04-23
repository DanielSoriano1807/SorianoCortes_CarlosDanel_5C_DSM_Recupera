package com.example.examenrecu.service.Partida;

import com.example.examenrecu.controller.dto.Partidadto.CreatePartidaDto;
import com.example.examenrecu.model.Jugador.BeanJugador;
import com.example.examenrecu.model.Jugador.JugadorRepository;
import com.example.examenrecu.model.Partida.BeanPartida;
import com.example.examenrecu.model.Partida.PartidaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
/*import org.springframework.transaction.annotation.Transactional;*/

@Service
public class PartidaService {
    private PartidaRepository partidaRepository;
    private JugadorRepository jugadorRepository;
    public PartidaService(PartidaRepository partidaRepository,JugadorRepository jugadorRepository){
        this.partidaRepository = partidaRepository;
        this.jugadorRepository = jugadorRepository;
    }
    @Transactional
    public BeanPartida iniciarpartida(CreatePartidaDto data){
        BeanJugador jugador = jugadorRepository.findById(data.getJugadorId())
                .orElseThrow(() -> new IllegalArgumentException("no hay jugadoreps"));
        if (!jugador.getActivo()){
            throw new IllegalArgumentException("este jigiador ya etsa vactivo");
        }
        BeanPartida partida = new BeanPartida();
        partida.setJugador(jugador);
        partida.setFecha(LocalDate.now());
        return partidaRepository.save(partida);
    }

}
