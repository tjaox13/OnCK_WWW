package com.example.ongk.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product2 extends BaseEntity {
	@Column(name = "product_name", nullable = false)
	private String productName;
	@Column(name = "product_img", nullable = false)
	private String productImage;
	@Column(name = "product_price", nullable = false)
	private float productPrice;
	@Column(name = "product_stock", nullable = false)
	private int quantity;
	@Column(name = "product_desc", nullable = false, length = 700)
	private String productDesc;
	@Column(name = "status", nullable = false)
	private int statusSell;

	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderDetail> orderDetails = new ArrayList<>();

	public Product2() {
		super();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrince) {
		this.productPrice = productPrince;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getStatusSell() {
		return statusSell;
	}

	public void setStatusSell(int statusSell) {
		this.statusSell = statusSell;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
