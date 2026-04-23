package com.example.examenrecu.service.Jugador;

import com.example.examenrecu.controller.dto.Jugadordto.CreateJugadorDto;
import com.example.examenrecu.model.Jugador.BeanJugador;
import com.example.examenrecu.model.Jugador.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {
    private JugadorRepository jugadorRepository;
    public JugadorService(JugadorRepository jugadorRepository){
        this.jugadorRepository = jugadorRepository;
    }
    public List<BeanJugador> findAll(){
        return jugadorRepository.findAll();
    }
    public BeanJugador save(CreateJugadorDto Data){
        BeanJugador beanJugador = new BeanJugador();
        if(data.getName() == null){
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        beanJugador.setNombre(data.getNombre());
        beanJugador.setSaldo(data.getSaldo());
        beanJugador.setActivo(data.getActivo());
        return jugadorRepository.save(beanJugador);
    }


}
