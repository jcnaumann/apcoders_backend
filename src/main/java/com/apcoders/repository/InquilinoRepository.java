package com.apcoders.repository;

import com.apcoders.model.Inquilino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de representação da camada de acesso ao banco de dados da classe Inquilino.
 */
@Repository
public interface InquilinoRepository extends CrudRepository<Inquilino, Long> {
}
