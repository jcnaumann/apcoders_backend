package com.apcoders.service;

import com.apcoders.model.Despesa;

import java.util.List;

/**
 * Camada de serviço da classe Despesa.
 */
public interface DespesaService {

    /**
     * Método abstrato que retorna um objeto da classe 'Conta' para salvamento.
     * @param despesa parâmetro/objeto de salvamento.
     * @return Retorna um objeto Despesa.
     */
    Despesa createDespesa(Despesa despesa);

    /**
     * Método abstrato que método retorna um objeto da classe 'Despesa' para salvamento.
     * @param despesa parâmetro/objeto de salvamento.
     * @return Retorna um objeto Despesa.
     */
    Despesa updateDespesa(Despesa despesa);

    /**
     * Método abstrato que método retorna um objeto da classe 'Optional' para verificação se ele existe no banco de dados.
     * A referida classe é utilizada a fim de evitar NPE, ou seja, a mesma necessariamente conterá nada ou
     * uma valor não nulo.
     * @param id Código identificador do registro.
     * @return Retorna um objeto Optional vazio ou não nulo.
     */
    Despesa getDespesa(long id);

    /**
     * Método abstrato que remove uma depesa através do seu 'id'.
     * @param id Código identificador do registro.
     */
    void deleteDespesa(long id);

    /**
     * Método abstrato que retorna todas as despesas existentes na tabela correspondente (DESPESAS) do banco de dados.
     * @return Retorna uma coleção de todas as despesas existentes na base de dados.
     */
    List<Despesa> getAllDespesas();

}
