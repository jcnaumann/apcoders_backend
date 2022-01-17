package com.apcoders.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ENDERECOS")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Endereco implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
    @SequenceGenerator(initialValue = 1, name = "endereco_seq", sequenceName = "endereco_sequencia")
    private long id;

    @NotBlank(message = "Endereço não poder estar em branco")
    @Size(max = 255)
    private String endereco;

    @Size(max = 50)
    private String complemento;

    @Size(max = 50)
    private String bairro;

    @Size(max = 50)
    private String cidade;

    @Size(max = 2)
//    @Enumerated(EnumType.STRING)
    private String estado;

    @Size(max = 9)
    private String cep;

    @Getter
    @AllArgsConstructor
    enum Estado {
        AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG,
        PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO
    }

}
