package com.duxsoftware.pruebatecnica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duxsoftware.pruebatecnica.model.Equipo;
import com.duxsoftware.pruebatecnica.repository.EquipoRepository;

@Service
public class EquipoService {

    private EquipoRepository EquipoRepository;

    @Autowired
    public EquipoService(EquipoRepository EquipoRepository) {
        this.EquipoRepository = EquipoRepository;
    }

    public Equipo createEquipo(Equipo equipo) throws IllegalArgumentException {
        return EquipoRepository.save(equipo);
    }

    public Equipo updateEquipo(Equipo equipo) {
        return EquipoRepository.save(equipo);
    }

    public Optional<Equipo> findById(Integer id){
        return EquipoRepository.findById(id);
    }

    public List<Equipo> findEquipos(){
        return EquipoRepository.findAll();
    }

    public Optional<Equipo> findByNombre(String nombre){
        return EquipoRepository.findByNombre(nombre);
    }

    public List<Equipo> findByLiga(String liga){
        return EquipoRepository.findByLiga(liga);
    }

    public List<Equipo> findByPais(String pais)
    {
        return EquipoRepository.findByPais(pais);
    }

    public void deleteEquipoPorId(Integer id) {
        EquipoRepository.deleteById(id);
    }

}