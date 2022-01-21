package com.apcoders.repository;

import com.apcoders.model.Despesa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de representação da camada de acesso ao banco de dados da classe Despesa.
 */
@Repository
public interface DespesaRepository extends CrudRepository<Despesa, Long> {
}
