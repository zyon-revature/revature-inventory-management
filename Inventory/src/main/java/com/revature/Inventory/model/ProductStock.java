package com.revature.Inventory.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="productstock")
public class ProductStock{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "productstock_id_seq", allocationSize = 1)
	private int id;

	@Column
	private Date transactiondate;
	@Column
	private String vendor;
	@Column
	private String batchcode;
	@Column
	private String invoicenumber;
	@Column
	private int quantity;
	@Column
	private String transactiontype;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productid")
	private @Getter @Setter Product product;
	
}
