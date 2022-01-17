package com.apcoders.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "INQUILINOS")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Inquilino implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "O nome do inquilino não pode estar vazio")
    private String nome;

    @NotNull(message = "A idade não pode ser nula")
    @Min(0) @Max(110)
    private int idade;

    @NotNull(message = "O campo sexo deve ser preenchido")
    private Sexo sexo;

    @NotEmpty(message = "É necessário entrar com um número de telefone para contato")
    @Size(max = 25)
    private String telefone;

    @Email(message = "Entre com um endereço de e-mail válido")
    private String email;

    @Getter
    public enum Sexo {
        MASCULINO, FEMININO, NAO_BINARIO
    }

}
