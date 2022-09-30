package com.simuladoprova.SimuladoParaProva.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simuladoprova.SimuladoParaProva.repos.dto.NewProductDTO;
import com.simuladoprova.SimuladoParaProva.repos.dto.SetProductSellPriceDTO;
import com.simuladoprova.SimuladoParaProva.services.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	
	private final ProductService productService;
	//private final BatchService batchService;
	
	public ProductController(ProductService productService/*, BatchService batchService*/) {
		this.productService = productService;
		//this.batchService = batchService;
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public String createNewProduct(@RequestBody NewProductDTO product) {
		productService.save(product);
		return(productService.getMessage());
	}
	
	@PutMapping("/salePrice/{id}")
	public String setProductPrice(@RequestBody SetProductSellPriceDTO product, @PathVariable("id") int id) {
		productService.setPrice(product);
		return(productService.getMessage());
	}

	public void updateProduct() {

	}

	public void readProduct() {

	}

	public void deleteProduct() {

	}
}
