package com.duxsoftware.pruebatecnica.repository;

import com.duxsoftware.pruebatecnica.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    List<Equipo> findByNombreContainingIgnoreCase(String nombre);

    List<Equipo> findByLigaContainingIgnoreCase(String liga);

    List<Equipo> findByPaisContainingIgnoreCase(String pais);

}