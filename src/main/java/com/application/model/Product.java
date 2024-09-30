package com.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ProductId;
	private String name;
	private String ManufacturingDate;
	private long Price;
	private String ExpDate;

	@ManyToOne()
	@JoinColumn(name = "categories_id", nullable = false)
	private Categories categories;

	public long getProductId() {
		return ProductId;
	}

	public void setProductId(long productId) {
		ProductId = productId;
	}

	public String getManufacturingDate() {
		return ManufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		ManufacturingDate = manufacturingDate;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

	public String getExpDate() {
		return ExpDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExpDate(String expDate) {
		ExpDate = expDate;
	}

	public Product(String productName, String manufacturingDate, long price, String expDate, Categories categories) {
		super();
		name = name;
		ManufacturingDate = manufacturingDate;
		Price = price;
		ExpDate = expDate;
		this.categories = categories;
	}

	public Product() {

	}

	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + name + ", ManufacturingDate="
				+ ManufacturingDate + ", Price=" + Price + ", ExpDate=" + ExpDate + "]";
	}

}
