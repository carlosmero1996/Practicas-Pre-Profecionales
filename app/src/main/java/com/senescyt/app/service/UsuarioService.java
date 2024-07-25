package com.senescyt.app.service;

import com.senescyt.app.model.Usuario;
import com.senescyt.app.repository.UsuarioRepository;
import com.senescyt.app.service.genericService.GenericService;
import com.senescyt.app.service.genericService.GenericServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UsuarioService extends GenericServiceImpl<Usuario, Long> implements GenericService<Usuario, Long> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getByUsuarioOrEmail(String nombreOrEmail) {
        return usuarioRepository.findByUsernameOrEmail(nombreOrEmail, nombreOrEmail);
    }

    @Override
    public CrudRepository<Usuario, Long> getDao() {
        return usuarioRepository;
    }

    public Usuario findByPersonaCorreo(String email){
        return usuarioRepository.findByUsuCorreo(email);
    }

    public Usuario findByUsuTokenPassword(String token){
        return  usuarioRepository.findByUsuTokenPassword(token);
    }

}
