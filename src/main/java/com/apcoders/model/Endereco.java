package com.apcoders.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Entidade JPA Endereço, utilizada para definição dos membros da classe, representando os dados que serão persistidos
 * em uma tabela denominada 'ENDERECOS' do banco de dados H2.
 * A fim de evitar código clichê, foi utilizada a biblioteca 'Project Lombok', a qual automatiza a criação dos
 * métodos 'Setters' e 'Getters', construtores, toString, builders, etc.
 *
 * @author Jean C. Naumann
 */
@Entity
@Table(name = "ENDERECOS")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Endereco implements Serializable {

    /**
     * Campo Id incrementado automaticamente, uniciando no 1.
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
    @SequenceGenerator(initialValue = 1, name = "endereco_seq", sequenceName = "endereco_sequencia")
    private long id;

    /**
     * Campo validado 'endereco' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Utilizou-se a anotação '@Size' para limitar o número de caracteres a 255.
     * Não aceita entrada em branco, propondo uma mensagem para validação desconforme.
     */
    @NotBlank(message = "Endereço não poder estar em branco")
    @Size(max = 255)
    private String endereco;

    /**
     * Campo validado 'complemento' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Utilizou-se a anotação '@Size' para limitar o número de caracteres a 50.
     */
    @Size(max = 50)
    private String complemento;

    /**
     * Campo validado 'bairro' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Utilizou-se a anotação '@Size' para limitar o número de caracteres a 50.
     */
    @Size(max = 50)
    private String bairro;

    /**
     * Campo validado 'cidade' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Utilizou-se a anotação '@Size' para limitar o número de caracteres a 50.
     */
    @Size(max = 50)
    private String cidade;

    /**
     * Campo validado 'estado' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Utilizou-se a anotação '@Size' para limitar o número de caracteres a 50.
     */
    @Size(max = 2)
//    @Enumerated(EnumType.STRING)
    private String estado;

    /**
     * Campo validado 'complemento' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Utilizou-se a anotação '@Size' para limitar o número de caracteres a 50.
     */
    @Size(max = 9)
    private String cep;

    /**
     * Classe Enum ainda não utilizada na codificação.
     * A ideia numa versão posterior é condicionar ao uso das siglas dos estados.
     */
    @Getter
    @AllArgsConstructor
    enum Estado {
        AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG,
        PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO
    }

}
