package com.duxsoftware.pruebatecnica.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duxsoftware.pruebatecnica.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    Optional<Equipo> findById(Integer id);

    Optional<Equipo> findByNombre(String nombre);

    List<Equipo> findByLiga(String liga);

    List<Equipo> findByPais(String pais);

    List<Equipo> findByNombreContaining(String nombre);
}
