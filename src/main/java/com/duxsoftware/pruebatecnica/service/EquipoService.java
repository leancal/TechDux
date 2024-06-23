package com.duxsoftware.pruebatecnica.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duxsoftware.pruebatecnica.model.Equipo;
import com.duxsoftware.pruebatecnica.repository.EquipoRepository;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    @Autowired
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public Equipo createEquipo(Equipo equipo) throws IllegalArgumentException {
        return equipoRepository.save(equipo);
    }

    public Equipo updateEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Optional<Equipo> findById(Integer id) {
        return equipoRepository.findById(id);
    }

    public List<Equipo> findEquipos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> findByNombre(String nombre) {
        return equipoRepository.findByNombre(nombre);
    }

    public List<Equipo> findByNombreContaining(String nombre) {
        return equipoRepository.findByNombreContaining(nombre);
    }

    public List<Equipo> findByLiga(String liga) {
        return equipoRepository.findByLiga(liga);
    }

    public List<Equipo> findByPais(String pais) {
        return equipoRepository.findByPais(pais);
    }

    public void deleteEquipoPorId(Integer id) {
        equipoRepository.deleteById(id);
    }
}
