package org.example.controller;

import jakarta.validation.Valid;
import org.example.config.TelefoneService;
import org.example.exceptions.RestNotFoundException;
import org.example.models.Telefone;
import org.example.repository.TelefoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/org/example/telefones")
public class TelefoneController {

    Logger log = LoggerFactory.getLogger(TelefoneController.class);

    @Autowired
    TelefoneRepository telefoneRepository;

    @Autowired
    TelefoneService telefoneService;

    @GetMapping()
    public List<Telefone> show(){
        return telefoneRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Telefone> show(@PathVariable Long id){
        log.info("detalhando telefone com id" + id);
        return ResponseEntity.ok(getTelefone(id));
    }

    @PostMapping()
    public ResponseEntity<Telefone> create(@RequestBody @Valid Telefone telefone, BindingResult result){
        log.info("cadastrando telefone" + telefone);
        telefoneRepository.save(telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefone);
    }

    @PutMapping("{id}")
    public ResponseEntity<Telefone> update(@PathVariable Long id, @RequestBody @Valid Telefone telefone){
        log.info("atualizando telefone" + id);

        getTelefone(id);

        telefone.setId(id);
        telefoneRepository.save(telefone);

        return ResponseEntity.ok(telefone);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Telefone> destroy(@PathVariable Long id){
        log.info("apagando telefone" + id);
        var telefone = getTelefone(id);
        telefone.setAtivo(false);
        telefoneRepository.save(telefone);
        return ResponseEntity.noContent().build();
    }



    private Telefone getTelefone(Long id) {
        var telefone = telefoneRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Telefone não encontrado"));
        return telefone;
    }



}
