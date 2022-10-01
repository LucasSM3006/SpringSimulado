package com.simuladoprova.SimuladoParaProva.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.simuladoprova.SimuladoParaProva.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query(value = "SELECT * FROM product WHERE available = true", nativeQuery = true)
	List<Product> findAllAvailableProducts();
	
	@Query("from Product where category = :category")
	List<Product> findAllByCategory(@Param("category") String category);
}
