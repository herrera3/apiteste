package org.example.repository;
import org.example.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByEmail(String busca);

}
