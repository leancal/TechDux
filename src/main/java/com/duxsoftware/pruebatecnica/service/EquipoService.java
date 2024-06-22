package com.duxsoftware.pruebatecnica.service;

import com.duxsoftware.pruebatecnica.model.Equipo;
import com.duxsoftware.pruebatecnica.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> getEquipoById(Long id) {
        return equipoRepository.findById(id);
    }

    public Equipo createEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }

    public List<Equipo> searchEquipos(String nombre, String liga, String pais) {
        if (nombre != null) {
            return equipoRepository.findByNombreContainingIgnoreCase(nombre);
        } else if (liga != null) {
            return equipoRepository.findByLigaContainingIgnoreCase(liga);
        } else if (pais != null) {
            return equipoRepository.findByPaisContainingIgnoreCase(pais);
        } else {
            return equipoRepository.findAll();
        }
    }
}
