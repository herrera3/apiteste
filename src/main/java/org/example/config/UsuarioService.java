package org.example.config;

import org.example.models.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public boolean login(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email) ;
        if (usuario == null) {
            return false;
        }
        else if (usuario.getSenha() == password){
            return true;
        }
        else{
            return false;
        }
    }
}
