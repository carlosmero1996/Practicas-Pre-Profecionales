package com.senescyt.app.service;

import com.senescyt.app.model.Asistencia;
import com.senescyt.app.model.Vacaciones;
import com.senescyt.app.repository.VacacionesRepository;
import com.senescyt.app.service.genericService.GenericService;
import com.senescyt.app.service.genericService.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class VacacionesService extends GenericServiceImpl<Vacaciones, Long> implements GenericService<Vacaciones, Long> {
    @Autowired
    VacacionesRepository vacacionesRepository;

    @Override
    public CrudRepository<Vacaciones, Long> getDao() {
        return vacacionesRepository;
    }
}
