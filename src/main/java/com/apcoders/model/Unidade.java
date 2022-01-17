package com.apcoders.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "UNIDADES")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Unidade implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Identificação não pode estar em branco")
    @Size(max = 255)
    private String identificacao;

    @NotBlank(message = "Proprietario não pode estar em branco")
    @Size(max = 100)
    private String proprietario;

    @NotBlank(message = "Condomínio não pode estar em branco")
    @Size(max = 100)
    private String condominio;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

}
