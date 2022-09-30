package com.simuladoprova.SimuladoParaProva.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Batch {
	@Id
	private int batch_id;
	private String name;
	private Date date;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
