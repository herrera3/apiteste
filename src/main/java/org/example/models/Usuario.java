package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Email
    @NotBlank(message = "Insira um email válido")
    private String email;

    @NotBlank(message = "Insira uma senha válida")
    private String senha;

    @NotBlank
    private String nome;

    @NotBlank
    private String estado;
    @NotBlank
    private String cidade;

    @JsonIgnore
    private boolean ativo = true;
}