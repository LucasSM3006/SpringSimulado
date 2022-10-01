package com.simuladoprova.SimuladoParaProva.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.simuladoprova.SimuladoParaProva.model.Batch;

public interface BatchRepository extends CrudRepository<Batch, Integer> {
	
	@Query("from Batch where name = :name")
	Optional<Batch> findByName(@Param("name") String name);
	
	@Query("from Batch where date = :date")
	List<Batch> findByDate(@Param("date") LocalDate date);
}
