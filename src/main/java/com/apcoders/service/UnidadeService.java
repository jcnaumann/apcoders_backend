package com.apcoders.service;

import com.apcoders.model.Unidade;
import java.util.List;

/**
 * Camada de serviço da classe Unidade.
 */
public interface UnidadeService {

    /**
     * Método abstrato que método retorna um objeto da classe 'Conta' para salvamento.
     * @param inquilino parâmetro/objeto de salvamento.
     * @return Retorna um objeto Unidade.
     */
    Unidade createUnidade(Unidade unidade);

    /**
     * Método abstrato que método retorna um objeto da classe 'Unidade' para salvamento.
     * @param inquilino parâmetro/objeto de salvamento.
     * @return Retorna um objeto Unidade.
     */
    Unidade updateUnidade(Unidade unidade);

    /**
     * Método abstrato que método retorna um objeto da classe 'Optional' para verificação se ele existe no banco de dados.
     * A referida classe é utilizada a fim de evitar NPE, ou seja, a mesma necessariamente conterá nada ou
     * uma valor não nulo.
     * @param id Código identificador do registro.
     * @return Retorna um objeto Optional vazio ou não nulo.
     */
    Unidade getUnidade(long id);

    /**
     * A função desta método é remover uma depesa através do seu 'id'.
     * @param id Código identificador do registro.
     */
    void deleteUnidade(long id);

    /**
     * Método abstrato que que retorna todas as inquilinos existentes na tabela correspondente (UNIDADES) do banco de dados.
     * @return Retorna uma coleção de todas as inquilinos existentes na base de dados.
     */
    List<Unidade> getAllUnidades();

}
