package com.apcoders.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "TP_DESPESA")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class TipoDespesa implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tp_despesa_seq")
    @SequenceGenerator(initialValue = 1, name = "tp_despesa_seq", sequenceName = "tp_despesa_sequencia")
    private long id;

    @NotEmpty(message = "A descrição do tipo de despesa deve ser preenchida")
    @Size(max = 100)
    private String descricao;

}
