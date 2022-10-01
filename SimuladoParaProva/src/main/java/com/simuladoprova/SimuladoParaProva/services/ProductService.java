package com.simuladoprova.SimuladoParaProva.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.simuladoprova.SimuladoParaProva.model.Product;
import com.simuladoprova.SimuladoParaProva.repos.ProductRepository;
import com.simuladoprova.SimuladoParaProva.repos.dto.AvailableProductsDTO;
import com.simuladoprova.SimuladoParaProva.repos.dto.ListProductsDTO;
import com.simuladoprova.SimuladoParaProva.repos.dto.NewProductDTO;
import com.simuladoprova.SimuladoParaProva.repos.dto.ProductsByCategoryDTO;
import com.simuladoprova.SimuladoParaProva.repos.dto.SetProductSellPriceDTO;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	private String message;

	public void save(NewProductDTO newProductDTO) {
		Product product = new Product();
		product.setTitle(newProductDTO.getTitle());
		product.setSalePrice(0);
		product.setProductionPrice(newProductDTO.getProductionPrice());
		product.setDescription(newProductDTO.getDescription());
		product.setCategory(newProductDTO.getCategory());
		product.setAvailable(newProductDTO.isAvailable());

		productRepository.save(product);
		setMessage("Everything is working.");
	}

	public void setPrice(int id, SetProductSellPriceDTO product) {
		Optional<Product> findProduct = productRepository.findById(id);

		if (findProduct.isPresent()) {
			Product existingProduct = findProduct.get();

			existingProduct.setSalePrice(product.getSalePrice());
			productRepository.save(existingProduct);
			setMessage("Product with ID '" + id + "' Changed successfully.");
		} else {
			setMessage("Product with ID '" + id + "' Does not exist.");
		}
	}

	public List<ListProductsDTO> getAll() {
		List<Product> products = (List<Product>) productRepository.findAll();
		List<ListProductsDTO> stream = products.stream().map(product -> {
			ListProductsDTO productDTO = new ListProductsDTO();
			productDTO.setProduct_id(product.getProduct_id());
			productDTO.setAvailable(product.isAvailable());
			productDTO.setCategory(product.getCategory());
			productDTO.setDescription(product.getDescription());
			productDTO.setProductionPrice(product.getProductionPrice());
			productDTO.setSalePrice(product.getSalePrice());
			productDTO.setTitle(product.getTitle());
			return productDTO;
		}).collect(Collectors.toList());

		return stream;
	}

	public List<AvailableProductsDTO> getAllAvailableProducts() {
		List<Product> products = (List<Product>) productRepository.findAllAvailableProducts();

		List<AvailableProductsDTO> stream = products.stream().map(product -> {
			AvailableProductsDTO productDTO = new AvailableProductsDTO();
			productDTO.setProduct_id(product.getProduct_id());
			productDTO.setAvailable(product.isAvailable());
			productDTO.setCategory(product.getCategory());
			productDTO.setDescription(product.getDescription());
			productDTO.setProductionPrice(product.getProductionPrice());
			productDTO.setSalePrice(product.getSalePrice());
			productDTO.setTitle(product.getTitle());
			return productDTO;
		}).collect(Collectors.toList());

		return stream;
	}

	public List<ProductsByCategoryDTO> getAllByCategory(String category) {
		List<Product> products = (List<Product>) productRepository.findAllByCategory(category);
		
		List<ProductsByCategoryDTO> stream = products.stream().map(product -> {
			ProductsByCategoryDTO productDTO = new ProductsByCategoryDTO();
			productDTO.setProduct_id(product.getProduct_id());
			productDTO.setAvailable(product.isAvailable());
			productDTO.setCategory(product.getCategory());
			productDTO.setDescription(product.getDescription());
			productDTO.setProductionPrice(product.getProductionPrice());
			productDTO.setSalePrice(product.getSalePrice());
			productDTO.setTitle(product.getTitle());
			return productDTO;
		}).collect(Collectors.toList());
		
		return stream;
	}

	public void setMessage(String msg) {
		message = msg;
	}

	public String getMessage() {
		String msg = message;
		message = ""; // Resets the message every time to not get repeated errors.
		return msg;
	}

}
