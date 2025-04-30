package com.solix.demo.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "REVIEWS")
@NoArgsConstructor
@Data
public class ProductReview {

	@Id
	@Column(name = "REVIEW_ID")
	private Integer id;
	

	private Integer productId;
	

	private Double rating;

	// ProductReview owns the relationship...
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")     // FOREIGN KEY...
	private Customer customer;
}
