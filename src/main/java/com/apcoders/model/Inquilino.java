package com.apcoders.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * Entidade JPA Inquilino, utilizada para definição dos membros da classe, representando os dados que serão persistidos
 * em uma tabela denominada 'INQUILINOS' do banco de dados H2.
 * A fim de evitar código clichê, foi utilizada a biblioteca 'Project Lombok', a qual automatiza a criação dos
 * métodos 'Setters' e 'Getters', construtores, toString, builders, etc.
 *
 * @author Jean C. Naumann
 */
@Entity
@Table(name = "INQUILINOS")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Inquilino implements Serializable {

    /**
     * Campo Id incrementado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Campo validado 'nome' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Não aceita entrada em branco, propondo uma mensagem para validação desconforme.
     */
    @NotEmpty(message = "O nome do inquilino não pode estar vazio")
    private String nome;

    /**
     * Campo validado 'idade' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Utilizou-se a anotação '@Min' e '@Max' para configurar limitar o intervalo númerico aceito.
     * Não aceita entrada nula, propondo uma mensagem para validação desconforme.
     */
    @NotNull(message = "A idade não pode ser nula")
    @Min(0) @Max(110)
    private int idade;

    /**
     * Campo validado 'sexo' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Não aceita entrada nula, propondo uma mensagem para validação desconforme.
     */
    @NotNull(message = "O campo sexo deve ser preenchido")
    private Sexo sexo;

    /**
     * Campo validado 'telefone' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Utilizou-se a anotação '@Min' para configurar limitar o intervalo númerico aceito.
     * Não aceita entrada em branco, propondo uma mensagem para validação desconforme.
     */
    @NotEmpty(message = "É necessário entrar com um número de telefone para contato")
    @Size(max = 25)
    private String telefone;

    /**
     * Campo validado 'email' cujo nome da coluna na tabela do banco de dados será o mesmo.
     * Utilizou-se a anotação '@Email' para validar o endereço de e-mail.
     */
    @Email(message = "Entre com um endereço de e-mail válido")
    private String email;

    /**
     * Classe enum 'Sexo', contendo suas constantes imutáveis do tipo 'final'.
     */
    @Getter
    public enum Sexo {
        MASCULINO, FEMININO, NAO_BINARIO
    }

}
