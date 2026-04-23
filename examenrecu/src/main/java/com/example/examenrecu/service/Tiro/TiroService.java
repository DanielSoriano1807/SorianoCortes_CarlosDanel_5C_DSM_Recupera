package com.example.examenrecu.service.Tiro;

import com.example.examenrecu.model.Jugador.BeanJugador;
import com.example.examenrecu.model.Jugador.JugadorRepository;
import com.example.examenrecu.model.Partida.BeanPartida;
import com.example.examenrecu.model.Partida.PartidaRepository;
import com.example.examenrecu.model.Tiro.BeanTiro;
import com.example.examenrecu.model.Tiro.TiroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TiroService {
    private TiroRepository tiroRepository;
    private PartidaRepository partidaRepository;
    private JugadorRepository jugadorRepository;
    public TiroService(TiroRepository tiroRepository,PartidaRepository partidaRepository,
                       JugadorRepository jugadorRepository){
        this.partidaRepository = partidaRepository;
        this.jugadorRepository = jugadorRepository;
        this.tiroRepository  = tiroRepository;
    }
    @Transactional
    public BeanTiro hacertiro(Long PartidaId){
        BeanJugador jugador = jugadorRepository.findById(data.getJugadorId())
                .orElseThrow(() -> new IllegalArgumentException("no hay jugadoreps"));
        if (!jugador.getActivo()){
            throw new IllegalArgumentException("este jigiador ya etsa vactivo");
    }
        BeanPartida partida = partidaRepository.findById(data.getPatidaId())
                .orElseThrow(()-> new IllegalArgumentException("no  hay partridas"));
        if(partida.getEstado()!=BeanPartida.estadopartida.en_juego){
            throw new IllegalArgumentException("la partida aun no esta en juegpo");
        }
        }
}
