package com.senescyt.app.repository;

import com.senescyt.app.model.Funciones;
import com.senescyt.app.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionesRepository extends GenericRepository<Funciones,Long> {

}
