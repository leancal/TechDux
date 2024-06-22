package com.duxsoftware.pruebatecnica.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.duxsoftware.pruebatecnica.model.Equipo;
import com.duxsoftware.pruebatecnica.model.RespuestaError;
import com.duxsoftware.pruebatecnica.service.EquipoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/")
@Tag(name = "Controlador Equipos", description = "Operaciones CRUD Equipos")
public class EquipoRestController {

    private EquipoService equipoService;

    @Autowired
    public EquipoRestController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @Operation(summary = "Listar Equipos", description = "Devuelve un archivo JSON con los Equipos")
    @GetMapping(value = "equipos", headers="Accept=application/json")
    public List<Equipo> listarEquipos(){
        return equipoService.findEquipos();
    }

    @Operation(summary = "Crear Equipo", description = "Recibe un archivo JSON con el equipo a crear en la BD")
    @PostMapping(value="equipos", headers="Accept=application/json")
    public Object createEquipo(@RequestBody Equipo equipo) {
        try {
            Equipo e = equipoService.createEquipo(equipo);
            return ResponseEntity.status(HttpStatus.CREATED).body(e);

        } catch (DataAccessException e3) {
            RespuestaError rpError =  new RespuestaError("La solicitud es inválida", 400);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpError);
        }
    }

    @Operation(summary = "Buscar Equipo por ID", description = "Recibe el parámetro ID para realizar la búsqueda")
    @GetMapping(value="equipos/{id}", headers="Accept=application/json")
    public Object buscarPorId(@PathVariable Integer id){
        try {
            Optional<Equipo> equipo = equipoService.findById(id);
            if ( !equipo.isEmpty() ) {
                return equipo;
            } else {
                RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rpError);
            }
        } catch (EmptyResultDataAccessException e2) {
            RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpError);
        } catch (DataAccessException e3) {
            RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpError);
        }
    }

    @Operation(summary = "Buscar Equipo por Nombre", description = "Recibe el parámetro Nombre para realizar la búsqueda")
    @GetMapping(value="equipos/buscar", headers="Accept=application/json")
    @ResponseBody
    public Object buscarPorNombre(@RequestParam (name="nombre", required=true) String nombre){
        try {
            Optional<Equipo> equipo = equipoService.findByNombre(nombre);
            if (!equipo.isEmpty()) {
                return equipo;
            } else {
                RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rpError);
            }
        } catch (EmptyResultDataAccessException e2) {
            RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpError);
        } catch (DataAccessException e3) {
            RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpError);
        }
    }

    @Operation(summary = "Actualizar Equipo por ID", description = "Recibe un archivo JSON para actualizar un Equipo")
    @PutMapping(value= "equipos/{id}", headers="Accept=application/json")
    public Object actualizarAuto(@RequestBody Equipo equipo) {
        try {
            return equipoService.updateEquipo(equipo);
        }catch (IllegalArgumentException e1){
            RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rpError);
        } catch (ConstraintViolationException e2) {
            RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpError);
        } catch (DataAccessException e3) {
            RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpError);
        }
    }

    @Operation(summary = "Eliminar Equipo por ID", description = "Recibe el parámetro ID para Eliminar un equipo")
    @DeleteMapping(value= "equipos/{id}", headers="Accept=application/json")
    public Object eliminarEquipoPorId(@PathVariable Integer id) {
        try {
            Optional<Equipo> equipo = equipoService.findById(id);
            if ( !equipo.isEmpty() ) {
                equipoService.deleteEquipoPorId(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
            } else {
                RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpError);
            }

        }catch (IllegalArgumentException e1){
            RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rpError);
        } catch (EmptyResultDataAccessException e2) {
            RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpError);
        } catch (DataAccessException e3) {
            RespuestaError rpError =  new RespuestaError("Equipo no encontrado", 404);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rpError);
        }
    }
}