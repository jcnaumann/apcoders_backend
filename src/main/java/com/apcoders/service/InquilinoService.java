package com.apcoders.service;

import com.apcoders.model.Inquilino;

import java.util.List;

/**
 * Camada de serviço da classe Inquilino.
 */
public interface InquilinoService {

    /**
     * Método abstrato que método retorna um objeto da classe 'Conta' para salvamento.
     * @param inquilino parâmetro/objeto de salvamento.
     * @return Retorna um objeto Inquilino.
     */
    Inquilino createInquilino(Inquilino inquilino);

    /**
     * Método abstrato que método retorna um objeto da classe 'Inquilino' para salvamento.
     * @param inquilino parâmetro/objeto de salvamento.
     * @return Retorna um objeto Inquilino.
     */
    Inquilino updateInquilino(Inquilino inquilino);

    /**
     * Método abstrato que método retorna um objeto da classe 'Optional' para verificação se ele existe no banco de dados.
     * A referida classe é utilizada a fim de evitar NPE, ou seja, a mesma necessariamente conterá nada ou
     * uma valor não nulo.
     * @param id Código identificador do registro.
     * @return Retorna um objeto Optional vazio ou não nulo.
     */
    Inquilino getInquilino(long id);

    /**
     * A função desta método é remover uma depesa através do seu 'id'.
     * @param id Código identificador do registro.
     */
    void deleteInquilino(long id);

    /**
     * Método abstrato que que retorna todas as inquilinos existentes na tabela correspondente (INQUILINOS) do banco de dados.
     inquilinos     */
    List<Inquilino> getAllInquilinos();

}
