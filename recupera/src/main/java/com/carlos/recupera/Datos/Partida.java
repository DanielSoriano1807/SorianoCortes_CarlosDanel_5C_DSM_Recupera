package com.carlos.recupera.Datos;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "partidas")
public class Partida {

    public enum Estado {
        CREADA, EN_JUEGO, FINALIZADA }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    private double apuesta;
}