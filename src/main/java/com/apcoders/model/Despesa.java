package com.apcoders.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "DESPESAS")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Despesa implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotEmpty(message = "A descrição deve ser preenchida")
    @Size(max = 100)
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_despesa_id", referencedColumnName = "id")
    @NotNull(message = "Escolha um tipo de despesa")
    private TipoDespesa tipoDespesa;

    @NotNull(message = "Valor inválido")
    private float valor;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Data de vencimento inválida")
    private LocalDate vencimentoFatura;

    @NotNull
    private boolean statusPagamento;

}
