package com.example.examenrecu.model.Jugador;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name="jugador")
@NoArgsConstructor
@Getter
@Setter
public class BeanJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double saldo;
    private Boolean activo;
}
