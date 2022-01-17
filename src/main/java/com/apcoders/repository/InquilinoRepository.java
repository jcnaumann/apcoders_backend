package com.apcoders.repository;

import com.apcoders.model.Inquilino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquilinoRepository extends CrudRepository<Inquilino, Long> {
}
