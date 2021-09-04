package com.revature.Inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
	@JoinColumn(name = "productid", nullable = false)
	private Product productId;
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
	
	public ProductStock() {}

	public ProductStock(int productid, Date transactiondate, String vendor, String batchcode, String invoicenumber, int quantity, String transactiontype) {
		super();
		this.productid = productid;
		this.transactiondate = transactiondate;
		this.vendor = vendor;
		this.batchcode = batchcode;
		this.invoicenumber = invoicenumber;
		this.quantity = quantity;
		this.transactiontype = transactiontype;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int product_id) {
		this.productid = product_id;
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

<<<<<<< Updated upstream
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productid")
	private Product product;
	
	public ProductStock(int id, String vendor, String batchCode,String invoiceNumber,
		int quantity, String transactionType) {
		this.batchcode = batchCode;
		this.invoicenumber = invoiceNumber;
		this.productId.setId(id);
		this.quantity = quantity;
		this.transactiontype = transactionType;
		this.vendor = vendor;
	}


	@Override
	public String toString() {
		return "ProductStock [id=" + id + ", productId=" + productId + ", transactionDate=" + transactiondate
				+ ", vendor=" + vendor + ", batchCode=" + batchcode + ", invoiceNumber=" + invoicenumber + ", quantity="
				+ quantity + ", transactionType=" + transactiontype + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Product getProductId() {
		return productId;
	}


	public void setProductId(Product productId) {
		this.productId = productId;
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


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}



=======
	@Override
	public String toString() {
		return "ProductStock [id=" + id + ", productid=" + productid + ", transactiondate=" + transactiondate
				+ ", vendor=" + vendor + ", batchcode=" + batchcode + ", invoicenumber=" + invoicenumber
				+ ", quantity=" + quantity + ", transactiontype=" + transactiontype + "]";
	}
	
	
	
	
>>>>>>> Stashed changes

}
