package com.hakney.votacao.repository;

import com.hakney.votacao.entity.Voto;
import org.springframework.data.repository.CrudRepository;

public interface VotoRepository extends CrudRepository<Voto, Long> {
}
