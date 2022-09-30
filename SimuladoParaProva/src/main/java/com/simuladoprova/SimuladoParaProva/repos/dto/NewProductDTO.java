package com.simuladoprova.SimuladoParaProva.repos.dto;

public class NewProductDTO {
	private String title;
	private String description;
	private float productionPrice;
	private String category;
	private boolean available;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getProductionPrice() {
		return productionPrice;
	}

	public void setProductionPrice(float productionPrice) {
		this.productionPrice = productionPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
