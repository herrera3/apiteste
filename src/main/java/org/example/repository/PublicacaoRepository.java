package org.example.repository;

import org.example.models.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    Publicacao findByConteudo(String busca);

}
