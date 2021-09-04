package com.revature.Inventory.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity (name="product")
public class Product{


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName = "product_id_seq", allocationSize = 1)
	private int id;
	@Column
	private String title;
	@Column
	private String category;
	@Column
	private String manufacturer;
	@Column
	private int minlimit;
	@OneToMany (mappedBy = "productid", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProductStock> productStocks = new HashSet<>();
	
	
	public void addProductStock(ProductStock productStock) {
		productStock.setProductId(this);
		productStocks.add(productStock);
	}

	public Product() {
		super();
	}
	
	public Product(int id, String title, String category, String manufacturer, int min, int boh,
			Set<ProductStock> productStocks) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.manufacturer = manufacturer;
		this.minlimit = min;

		this.productStocks = productStocks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getMin() {
		return minlimit;
	}

	public void setMin(int min) {
		this.minlimit = min;
	}



	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", title=" + title + ", category=" + category + ", manufacturer="
				+ manufacturer + ", min=" + minlimit + ", productStocks=" + productStocks + "]";
	}


}
