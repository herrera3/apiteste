package org.example.repository;
import org.example.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

    Telefone findByNrTelefone(int busca);

}