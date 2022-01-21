package com.apcoders.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Entidade JPA TipoDespesa, utilizada para definição dos membros da classe, representando os dados que serão persistidos
 * em uma tabela denominada 'TP_DESPESA' do banco de dados H2.
 * A fim de evitar código clichê, foi utilizada a biblioteca 'Project Lombok', a qual automatiza a criação dos
 * métodos 'Setters' e 'Getters', construtores, toString, builders, etc.
 *
 * @author Jean C. Naumann
 */
@Entity
@Table(name = "TP_DESPESA")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class TipoDespesa implements Serializable {

    /**
     * Campo Id incrementado automaticamente.
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tp_despesa_seq")
    @SequenceGenerator(initialValue = 1, name = "tp_despesa_seq", sequenceName = "tp_despesa_sequencia")
    private long id;

    /**
     * Campo validado 'descricao' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Não aceita entrada em branco, propondo uma mensagem para validação desconforme.
     */
    @NotEmpty(message = "A descrição do tipo de despesa deve ser preenchida")
    @Size(max = 100)
    private String descricao;

}
