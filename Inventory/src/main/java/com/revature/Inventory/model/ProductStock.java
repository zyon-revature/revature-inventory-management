package com.revature.Inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity (name="productstock")
public class ProductStock {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "productstock_id_seq", allocationSize = 1)
	
	private int id;
	@Column
	private int productid;
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
	
	public ProductStock() {
		super();
	}
	
	public ProductStock(int id, int productid, Date transactiondate, String vendor, String batchcode,
			String invoicenumber, int quantity, String transactiontype) {
		super();
		
		this.id=id;
		this.productid=productid;
		this.transactiondate=transactiondate;
		this.vendor=vendor;
		this.batchcode=batchcode;
		this.invoicenumber=invoicenumber;
		this.quantity=quantity;
		this.transactiontype=transactiontype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getBatchcode() {
		return batchcode;
	}

	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}

	public String getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	
	
}
