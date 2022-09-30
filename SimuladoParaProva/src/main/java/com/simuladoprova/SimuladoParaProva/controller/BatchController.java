package com.simuladoprova.SimuladoParaProva.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simuladoprova.SimuladoParaProva.services.BatchService;

@RestController
@RequestMapping("batch")
public class BatchController {
	
	private final BatchService batchService;
	
	public BatchController(BatchService batchService) {
		this.batchService = batchService;
	}
	
	public void createBatch() {

	}

	public void updateBatch() {

	}

	public void readBatch() {

	}

	public void deleteBatch() {

	}
}
