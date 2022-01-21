package com.apcoders.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Entidade JPA Unidade, utilizada para definição dos membros da classe, representando os dados que serão persistidos
 * em uma tabela denominada 'UNIDADES' do banco de dados H2.
 * A fim de evitar código clichê, foi utilizada a biblioteca 'Project Lombok', a qual automatiza a criação dos
 * métodos 'Setters' e 'Getters', construtores, toString, builders, etc.
 *
 * @author Jean C. Naumann
 */
@Entity
@Table(name = "UNIDADES")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Unidade implements Serializable {

    /**
     * Campo Id incrementado automaticamente.
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Campo validado 'identificacao' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Não aceita entrada em branco, propondo uma mensagem para validação desconforme.
     */
    @NotBlank(message = "Identificação não pode estar em branco")
    @Size(max = 255)
    private String identificacao;

    /**
     * Campo validado 'proprietario' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Não aceita entrada em branco, propondo uma mensagem para validação desconforme.
     * Utilizou-se a anotação '@Size' para limitar o número de caracteres em 100.
     */
    @NotBlank(message = "Proprietario não pode estar em branco")
    @Size(max = 100)
    private String proprietario;

    /**
     * Campo validado 'condominio' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Não aceita entrada em branco, propondo uma mensagem para validação desconforme.
     * Utilizou-se a anotação '@Size' para limitar o número de caracteres em 100.
     */
    @NotBlank(message = "Condomínio não pode estar em branco")
    @Size(max = 100)
    private String condominio;

    /**
     * Campo validado 'endereco' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Trata-se de um objeto da classe 'Endereco', relacionamento @OneToOne.
     * Utilizou-se a anotação '@JoinColumn' para ingressar em uma associação entre entidades.
     * Não aceita entrada nula, propondo uma mensagem para validação desconforme.
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

}
