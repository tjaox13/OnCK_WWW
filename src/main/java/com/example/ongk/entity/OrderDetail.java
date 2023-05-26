package com.example.ongk.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderdetail")
public class OrderDetail extends BaseEntity {

	@Column(name = "detailquantity", nullable = false)
	private int detailQuantity;

	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	private Product2 product;

	public OrderDetail() {
		super();
	}

	public int getDetailQuantity() {
		return detailQuantity;
	}

	public void setDetailQuantity(int detailQuantity) throws Exception {
		if (detailQuantity <= product.getQuantity()) {
			this.detailQuantity = detailQuantity;
		} else {
			throw new Exception("Amount of product not applied");
		}

	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product2 getProduct() {
		return product;
	}

	public void setProduct(Product2 product) {
		this.product = product;
	}

}
