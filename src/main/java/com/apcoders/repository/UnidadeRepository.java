package com.apcoders.repository;

import com.apcoders.model.Unidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de representação da camada de acesso ao banco de dados da classe Unidade.
 */
@Repository
public interface UnidadeRepository extends CrudRepository<Unidade, Long> {
}
