package com.revature.Inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@Entity (name="productstock")
public class ProductStock{


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName = "productstock_id_seq", allocationSize = 1)
	
	private int id;
//	@Column
//	private int productid;
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
	private Product product;
	
	public ProductStock() {
		super();
	}

	//public ProductStock(int Id, Date transactionDate, String Vendor, String batchCode, String invoiceNumber, int Quantity, String transactionType){
	public ProductStock(int Id, int productId, Date transactionDate, String Vendor, String batchCode, String invoiceNumber, int Quantity, String transactionType) {
		super();
		this.id = Id;
		this.product.setId(productId);
		this.transactiondate = transactionDate;
		this.vendor = Vendor;
		this.batchcode = batchCode;
		this.invoicenumber = invoiceNumber;
		this.quantity = Quantity;
		this.transactiontype = transactionType;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductid() {
		return product.getId();
	}

	public void setProductid(int productid) {
		product.setId(productid);
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
	

	@Override
	public String toString() {
		return "productstock [id=" + id + ", productid=" + product.getId() + ", transactiondate=" + transactiondate+ ", vendor=" + vendor + ", batchcode=" + batchcode + ", invoicenumber=" + invoicenumber + ", quantity=" + quantity + ", transactiontype=" + transactiontype + "]";
	}


}
