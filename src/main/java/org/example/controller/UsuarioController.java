package org.example.controller;

import jakarta.validation.Valid;
import org.example.config.UsuarioService;
import org.example.exceptions.RestNotFoundException;
import org.example.models.Usuario;
import org.example.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/org/example/usuarios")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> show(){
        return usuarioRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        log.info("detalhando usuario com id" + id);
        return ResponseEntity.ok(getUsuario(id));
    }

    @PostMapping()
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario, BindingResult result){
        log.info("cadastrando usuario" + usuario);
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody @Valid Usuario usuario){
        log.info("atualizando usuario" + id);

        getUsuario(id);

        usuario.setId(id);
        usuarioRepository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> destroy(@PathVariable Long id){
        log.info("apagando usuario" + id);
        var usuario = getUsuario(id);
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        boolean authenticated = usuarioService.login(usuario.getEmail(),usuario.getSenha());
        if (authenticated) {
            return ResponseEntity.ok("Logado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválido");
        }
    }

    private Usuario getUsuario(Long id) {
        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrado"));
        return usuario;
    }



}
