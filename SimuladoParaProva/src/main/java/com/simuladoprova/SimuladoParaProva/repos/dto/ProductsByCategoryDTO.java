package com.simuladoprova.SimuladoParaProva.repos.dto;

public class ProductsByCategoryDTO {
	private int product_id;
	private String title;
	private String description;
	private float productionPrice;
	private float salePrice;
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

	public float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
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

	public int getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

}