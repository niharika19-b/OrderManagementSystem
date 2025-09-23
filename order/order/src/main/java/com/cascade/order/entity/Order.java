package com.cascade.order.entity;
import java.util.*;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.Data;


@Entity
@Table(name = "orders")
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="customer_name", nullable=false)
	private String customerName;
	
	@Column(name="email_id")
	private String emailId;
	
	@OneToMany(mappedBy="order",cascade= CascadeType.ALL,orphanRemoval = true)
	private List<Item> items = new ArrayList<>();
	
	public Order() {}
	
	public Order(String customerName,String emailId) {
		this.customerName = customerName;
        this.emailId = emailId;
	}

	 public void addItem(Item item) {
	        items.add(item);
	        item.setOrder(this);
	    }
	 public void removeItem(Item item) {
	        items.remove(item);
	        item.setOrder(null);
	
}

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getCustomerName() {
		 return customerName;
	 }

	 public void setCustomerName(String customerName) {
		 this.customerName = customerName;
	 }

	 public String getEmailId() {
		 return emailId;
	 }

	 public void setEmailId(String emailId) {
		 this.emailId = emailId;
	 }

	 public List<Item> getItems() {
		 return items;
	 }

	 public void setItems(List<Item> items) {
		 this.items = items;
	 }
}
