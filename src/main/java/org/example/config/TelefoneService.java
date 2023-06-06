package org.example.config;
import org.example.models.Telefone;
import org.example.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public boolean numeroTele(int nrTelefone) {
        Telefone telefone = telefoneRepository.findByNrTelefone(nrTelefone) ;
        if (telefone == null) {
            return false;
        }
        else if (telefone.getNrTelefone() == nrTelefone){
            return true;
        }
        else{
            return false;
        }
    }
}
