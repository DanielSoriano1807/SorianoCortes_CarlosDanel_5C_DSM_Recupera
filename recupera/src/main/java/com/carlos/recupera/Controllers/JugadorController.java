package com.carlos.recupera.Controllers;

import com.carlos.recupera.Datos.Jugador;
import com.carlos.recupera.Datos.JugadorDTO;
import com.carlos.recupera.Services.JugadorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorService service;

    public JugadorController(JugadorService service) {
        this.service = service;
    }

    @PostMapping
    public Jugador registrar(@RequestBody JugadorDTO dto) {
        return service.registrar(dto);
    }

    @PutMapping("/{id}/recargar")
    public Jugador recargar(@PathVariable Long id,
                            @RequestParam double monto) {
        return service.recargarSaldo(id, monto);
    }
}