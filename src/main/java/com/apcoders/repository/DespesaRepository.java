package com.apcoders.repository;

import com.apcoders.model.Despesa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends CrudRepository<Despesa, Long> {
}
