package com.solix.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	
	@Id
	@Column(name = "CUSTOMER_ID")
	private Integer id;
	
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	
	// Whenever the relation is Bi-Directional, then we need to use 'mappedBy' value...
	// 'mappedBy' attribute is used to represent the INVERSE SIDE of Bi-Directional Relationship....
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "customer")
	List<ProductReview> reviews = new ArrayList<>();
}
