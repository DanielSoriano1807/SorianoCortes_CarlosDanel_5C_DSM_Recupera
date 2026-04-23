package com.example.examenrecu.model.Partida;

import com.example.examenrecu.model.Jugador.BeanJugador;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table (name="partida")
@NoArgsConstructor
@Getter
@Setter

public class BeanPartida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private estadopartida estado;
    @ManyToOne
    @JoinColumn(name = "idjugador")
    private BeanJugador jugador;
    public enum estadopartida{
        creada,en_juego,finalizada
    }

}
