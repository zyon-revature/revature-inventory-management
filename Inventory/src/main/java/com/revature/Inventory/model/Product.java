package com.revature.Inventory.model;

import lombok.*;

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


}
