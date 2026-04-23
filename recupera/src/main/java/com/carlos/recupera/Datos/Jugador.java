package com.carlos.recupera.Datos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double saldo;
    private boolean activo;
}