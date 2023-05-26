package com.example.ongk.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {
	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product2> products = new ArrayList<>();

	public Category() {
		super();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product2> getProducts() {
		return products;
	}

	public void setProducts(List<Product2> products) {
		this.products = products;
	}
}
