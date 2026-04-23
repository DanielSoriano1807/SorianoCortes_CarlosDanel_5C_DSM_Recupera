package com.carlos.recupera.Services;

import com.carlos.recupera.Datos.Jugador;
import com.carlos.recupera.Datos.JugadorDTO;
import com.carlos.recupera.Repositorio.JugadorRepositorio;
import org.springframework.stereotype.Service;

@Service
public class JugadorService {

    private final JugadorRepositorio repositorio;

    public JugadorService(JugadorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Jugador registrar(JugadorDTO dto) {
        Jugador j = new Jugador();
        j.setNombre(dto.getNombre());
        j.setSaldo(dto.getSaldo());
        j.setActivo(dto.isActivo());
        return repositorio.save(j);
    }

    public Jugador recargarSaldo(Long id, double monto) {
        Jugador j = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        j.setSaldo(j.getSaldo() + monto);
        return repositorio.save(j);
    }
}