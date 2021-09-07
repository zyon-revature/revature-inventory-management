package com.revature.Inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="productstock")
public class ProductStock{


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName = "productstock_id_seq", allocationSize = 1)
	
	private int id;
	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "productid", nullable = false)
	private Product productid;
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
	
	public ProductStock() {}

	public ProductStock(int Id,Product productId, Date transactionDate, String Vendor, String batchCode, String invoiceNumber, int Quantity, String transactionType) {
		super();
		this.id = Id;
		this.productid = productId;
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

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
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
	
	public ProductStock(int id, String vendor, String batchcode,String invoicenumber, int quantity, String transactiontype) {
		this.batchcode = batchcode;
		this.invoicenumber = invoicenumber;
		this.productid.setId(id);
		this.quantity = quantity;
		this.transactiontype = transactiontype;
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "productstock [id=" + id + ", productid=" + productid + ", transactiondate=" + transactiondate+ ", vendor=" + vendor + ", batchcode=" + batchcode + ", invoicenumber=" + invoicenumber + ", quantity=" + quantity + ", transactiontype=" + transactiontype + "]";
	}


}
