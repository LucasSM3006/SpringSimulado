package com.simuladoprova.SimuladoParaProva.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.simuladoprova.SimuladoParaProva.model.Batch;
import com.simuladoprova.SimuladoParaProva.model.Product;
import com.simuladoprova.SimuladoParaProva.repos.BatchRepository;
import com.simuladoprova.SimuladoParaProva.repos.ProductRepository;
import com.simuladoprova.SimuladoParaProva.repos.dto.BatchDTO;
import com.simuladoprova.SimuladoParaProva.repos.dto.NewBatchDTO;

@Service
public class BatchService {
	
	private final BatchRepository batchRepository;
	private final ProductRepository productRepository;

	public BatchService(ProductRepository productRepository, BatchRepository batchRepository) {
		this.batchRepository = batchRepository;
		this.productRepository = productRepository;
	}
	
	private String message;
	
	public void save(NewBatchDTO newBatchDTO) {
		Optional<Product> product = productRepository.findById(newBatchDTO.getProduct_id());
		Optional<Batch> btch = batchRepository.findByName(newBatchDTO.getName());
		
		if(btch.isPresent()) {
			setMessage("Batch with name '" + newBatchDTO.getName() + "' already exists.");
		} else if(product.isPresent()) {
		Batch batch = new Batch();
		
		batch.setDate(newBatchDTO.getDate());
		batch.setName(newBatchDTO.getName());
		batch.setProduct(product.get());
		
		batchRepository.save(batch);
		} else {
			setMessage("Product with ID '" + newBatchDTO.getProduct_id() + "' does not exist. Create one.");
		}
	}
	
	public List<BatchDTO> getAllByName(String name) {
		Optional<Batch> batches = batchRepository.findByName(name);
		
		List<BatchDTO> batchDTO = batches.stream().map(batch -> {
			BatchDTO b = new BatchDTO();
			b.setBatch_id(batch.getBatch_id());
			b.setDate(batch.getDate());
			b.setName(batch.getName());
			b.setProduct_id(batch.getProduct().getProduct_id());
			return b;
		}).collect(Collectors.toList());
		
		return batchDTO;
	}
	
	public String getMessage() {
		String msg = message;
		message = ""; // Resets the message every time to not get repeated errors.
		return msg;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
