package com.carlos.recupera.Controllers;

import com.carlos.recupera.Datos.Partida;
import com.carlos.recupera.Datos.PartidaDTO;
import com.carlos.recupera.Datos.Tiro;
import com.carlos.recupera.Services.PartidaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    private final PartidaService service;

    public PartidaController(PartidaService service) {
        this.service = service;
    }

    @PostMapping("/iniciar")
    public Partida iniciar(@RequestBody PartidaDTO dto) {
        return service.iniciarPartida(dto.getJugadorId(), dto.getApuesta());
    }

    @PostMapping("/{id}/tiro")
    public Tiro tiro(@PathVariable Long id) {
        return service.realizarTiro(id);
    }

    @PutMapping("/{id}/finalizar")
    public Partida finalizar(@PathVariable Long id) {
        return service.finalizarManual(id);
    }

    @GetMapping("/historial/{jugadorId}")
    public List<Partida> historial(@PathVariable Long jugadorId) {
        return service.historial(jugadorId);
    }
}