package org.example.repository;

import org.example.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    Comentario findByConteudo(String busca);
}
