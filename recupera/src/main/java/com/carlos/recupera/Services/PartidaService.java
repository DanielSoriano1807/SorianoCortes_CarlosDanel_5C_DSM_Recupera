package com.carlos.recupera.Services;

import com.carlos.recupera.Datos.*;
import com.carlos.recupera.Repositorio.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class PartidaService {

    private final PartidaRepositorio partidaRepositorio;
    private final JugadorRepositorio jugadorRepositorio;
    private final TiroRepositorio tiroRepositorio;

    public PartidaService(PartidaRepositorio partidaRepositorio,
                          JugadorRepositorio jugadorRepositorio,
                          TiroRepositorio tiroRepositorio) {
        this.partidaRepositorio = partidaRepositorio;
        this.jugadorRepositorio = jugadorRepositorio;
        this.tiroRepositorio = tiroRepositorio;
    }

    public Partida iniciarPartida(Long jugadorId, double apuesta) {
        Jugador j = jugadorRepositorio.findById(jugadorId)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

        if (!j.isActivo())
            throw new RuntimeException("Jugador inactivo");

        if (j.getSaldo() < apuesta)
            throw new RuntimeException("Saldo insuficiente");

        j.setSaldo(j.getSaldo() - apuesta);
        jugadorRepositorio.save(j);

        Partida p = new Partida();
        p.setJugador(j);
        p.setApuesta(apuesta);
        p.setFecha(LocalDateTime.now());
        p.setEstado(Partida.Estado.EN_JUEGO);
        return partidaRepositorio.save(p);
    }

    public Tiro realizarTiro(Long partidaId) {
        Partida p = partidaRepositorio.findById(partidaId)
                .orElseThrow(() -> new RuntimeException("Partida no encontrada"));

        Random r = new Random();
        int d1 = r.nextInt(6) + 1;
        int d2 = r.nextInt(6) + 1;
        int suma = d1 + d2;

        Tiro t = new Tiro();
        t.setPartida(p);
        t.setValorDado1(d1);
        t.setValorDado2(d2);
        t.setSuma(suma);

        if (suma == 7 || suma == 11) {
            t.setEsGanador(true);
            p.setEstado(Partida.Estado.FINALIZADA);
            Jugador j = p.getJugador();
            j.setSaldo(j.getSaldo() + (p.getApuesta() * 2));
            jugadorRepositorio.save(j);
        } else if (suma == 2 || suma == 3 || suma == 12) {
            t.setEsGanador(false);
            p.setEstado(Partida.Estado.FINALIZADA);
        } else {
            t.setEsGanador(false);
        }

        partidaRepositorio.save(p);
        return tiroRepositorio.save(t);
    }

    public Partida finalizarManual(Long partidaId) {
        Partida p = partidaRepositorio.findById(partidaId)
                .orElseThrow(() -> new RuntimeException("Partida no encontrada"));
        p.setEstado(Partida.Estado.FINALIZADA);
        return partidaRepositorio.save(p);
    }

    public List<Partida> historial(Long jugadorId) {
        return partidaRepositorio.findByJugadorId(jugadorId);
    }
}