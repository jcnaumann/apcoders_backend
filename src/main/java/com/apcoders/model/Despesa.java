package com.apcoders.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Entidade JPA Despesa, utilizada para definição dos membros da classe, representando os dados que serão persistidos
 * em uma tabela denominada 'DESPESAS' do banco de dados H2.
 * A fim de evitar código clichê, foi utilizada a biblioteca 'Project Lombok', a qual automatiza a criação dos
 * métodos 'Setters' e 'Getters', construtores, toString, builders, etc.
 *
 * @author Jean C. Naumann
 */
@Entity
@Table(name = "DESPESAS")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Despesa implements Serializable {

    /**
     * Campo Id incrementado automaticamente.
     */
    @Id
    @GeneratedValue
    private long id;

    /**
     * Campo validado 'descricao' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Não aceita entrada em branco, propondo uma mensagem para validação desconforme.
     */
    @NotEmpty(message = "A descrição deve ser preenchida")
    @Size(max = 100)
    private String descricao;

    /**
     * Campo validado 'tipoDespesa' cujo nome da coluna na tabela do banco de dados será 'tp_despesa'.
     * Trata-se de um objeto da classe 'TipoDespesa', relacionamento @ManyToOne.
     * Utilizou-se a anotação '@JoinColumn' para ingressar em uma associação entre entidades.
     * Não aceita entrada nula, propondo uma mensagem para validação desconforme.
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_despesa_id", referencedColumnName = "id")
    @NotNull(message = "Escolha um tipo de despesa")
    private TipoDespesa tipoDespesa;

    /**
     * Campo validado 'valor' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Não aceita entrada nula, propondo uma mensagem para validação desconforme.
     */
    @NotNull(message = "Valor inválido")
    private float valor;

    /**
     * Campo validado 'vencimentoFatura' cujo nome da coluna na tabela do banco de dados será 'vecto_fat'.
     * Utilizou-se a anotação '@JsonFormat' para configurar como as datas devem ser serializadas.
     * Não aceita entrada nula, propondo uma mensagem para validação desconforme.
     */
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Data de vencimento inválida")
    @Column(name = "vecto_fat")
    private LocalDate vencimentoFatura;

    /**
     * Campo validado 'statusPagamento' cujo nome da coluna na tabela do banco de dados será 'status_pagto'.
     * Não aceita entrada nula, propondo uma mensagem para validação desconforme.
     */
    @NotNull
    @Column(name = "status_pagto")
    private boolean statusPagamento;

}
