package com.simuladoprova.SimuladoParaProva.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simuladoprova.SimuladoParaProva.repos.dto.BatchDTO;
import com.simuladoprova.SimuladoParaProva.repos.dto.NewBatchDTO;
import com.simuladoprova.SimuladoParaProva.services.BatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {
	
	private final BatchService batchService;
	
	public BatchController(BatchService batchService) {
		this.batchService = batchService;
	}
	
	@PostMapping("/add")
	public String addBatch(@RequestBody NewBatchDTO batch) {
		batchService.save(batch);
		return batchService.getMessage();
	}

	@GetMapping("/listByName/{name}")
	public ResponseEntity<List<BatchDTO>> listByName(@PathVariable("name") String name) {
		
		return new ResponseEntity<>(batchService.getAllByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/listByDate/{date}")
	public ResponseEntity<List<BatchDTO>> listByDate(@PathVariable("date") String date) {
		return new ResponseEntity<>(batchService.getAllByDate(date), HttpStatus.OK);
	}
}
