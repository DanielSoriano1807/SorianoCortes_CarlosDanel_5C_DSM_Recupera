package com.example.examenrecu.controller.dto.Jugadordto;

import lombok.Data;

@Data
public class CreateJugadorDto {
    private String nombre;
    private Double saldo;
    private Boolean activo;
}
