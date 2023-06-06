package org.example.config;
import org.example.models.Publicacao;
import org.example.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    public boolean publi(String conteudo) {
        Publicacao publicacao = publicacaoRepository.findByConteudo(conteudo) ;
        if (publicacao == null) {
            return false;
        }
        else if (publicacao.getConteudo() == conteudo){
            return true;
        }
        else{
            return false;
        }
    }
}
