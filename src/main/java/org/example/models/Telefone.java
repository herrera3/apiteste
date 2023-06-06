package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private Long id;

    @NotBlank(message = "EX: 55")
    private int numeroDDD;

    @NotBlank(message = "EX: 11")
    private int numeroDDI;

    @NotBlank(message = "EX: 999999999")
    private int nrTelefone;
    @JsonIgnore
    private boolean ativo = true;

}
