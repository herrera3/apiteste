package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
public class Publicacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacao")
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String conteudo;

    private byte anexo;
    @NotBlank
    private Date data;
    @NotBlank
    private LocalDateTime hora;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @JsonIgnore
    private boolean ativo = true;
}
