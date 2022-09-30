package com.simuladoprova.SimuladoParaProva.repos;

import org.springframework.data.repository.CrudRepository;

import com.simuladoprova.SimuladoParaProva.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
