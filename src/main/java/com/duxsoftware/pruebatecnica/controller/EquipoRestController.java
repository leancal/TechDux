package com.duxsoftware.pruebatecnica.controller;

import com.duxsoftware.pruebatecnica.model.Equipo;
import com.duxsoftware.pruebatecnica.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipos")
public class EquipoRestController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public ResponseEntity<List<Equipo>> getAllEquipos() {
        return ResponseEntity.ok(equipoService.getAllEquipos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getEquipoById(@PathVariable Long id) {
        Optional<Equipo> equipo = equipoService.getEquipoById(id);
        return equipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipo> createEquipo(@RequestBody Equipo equipo) {
        Equipo savedEquipo = equipoService.createEquipo(equipo);
        return ResponseEntity.ok(savedEquipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
        equipoService.deleteEquipo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Equipo>> searchEquipos(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "liga", required = false) String liga,
            @RequestParam(value = "pais", required = false) String pais) {
        return ResponseEntity.ok(equipoService.searchEquipos(nombre, liga, pais));
    }
}
