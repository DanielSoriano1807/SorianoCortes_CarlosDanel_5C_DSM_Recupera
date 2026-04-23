package com.carlos.recupera.Datos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tiros")
public class Tiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;

    private int valorDado1;
    private int valorDado2;
    private int suma;
    private boolean esGanador;
}