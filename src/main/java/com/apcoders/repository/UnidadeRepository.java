package com.apcoders.repository;

import com.apcoders.model.Unidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends CrudRepository<Unidade, Long> {
}
