package com.simuladoprova.SimuladoParaProva.services;

import org.springframework.stereotype.Service;

import com.simuladoprova.SimuladoParaProva.model.Product;
import com.simuladoprova.SimuladoParaProva.repos.ProductRepository;
import com.simuladoprova.SimuladoParaProva.repos.dto.NewProductDTO;
import com.simuladoprova.SimuladoParaProva.repos.dto.SetProductSellPriceDTO;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	String message;
	
	public void save(NewProductDTO newProductDTO) {
		System.out.println("Ok.");
		
		Product product = new Product();
		product.setTitle(newProductDTO.getTitle());
		product.setSalePrice(0);
		product.setProductionPrice(newProductDTO.getProductionPrice());
		product.setDescription(newProductDTO.getDescription());
		product.setCategory(newProductDTO.getCategory());
		product.setAvailable(newProductDTO.isAvailable());
		
		productRepository.save(product);
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return "Everything is working so far.";
	}

	public void setPrice(SetProductSellPriceDTO product) {
		// TODO Auto-generated method stub
		
	}
}
