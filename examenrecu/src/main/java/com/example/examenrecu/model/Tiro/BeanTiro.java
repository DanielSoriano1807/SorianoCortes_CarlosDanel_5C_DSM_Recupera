package com.example.examenrecu.model.Tiro;

import com.example.examenrecu.model.Partida.BeanPartida;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table (name="tiro")
@NoArgsConstructor
@Getter
@Setter
public class BeanTiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="idpartida")
    private BeanPartida partida;
    private Integer valorDado1;
    private Integer valorDado2;
    private Integer suma;
    private Boolean esGanador;
}
