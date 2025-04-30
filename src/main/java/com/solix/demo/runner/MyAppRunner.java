package com.solix.demo.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.solix.demo.entity.Customer;
import com.solix.demo.entity.ProductReview;
import com.solix.demo.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Component
public class MyAppRunner implements ApplicationRunner {

	// Since the relation is Bi-Directional, we can perform Customer-To-Review AND Review-To-Customer, and both of TWO Entities are aware of their entities...
	
	// 1. Customer-To-Review(One Customer can give multiple reviews for multiple products)
	// 2. Review-To-Customer(Assignment)
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setEmailAddress("John@gmail.com");
		
		ProductReview review1 = new ProductReview();
		review1.setId(1001); review1.setProductId(90101); review1.setRating(4.7);
		
		ProductReview review2 = new ProductReview();
		review2.setId(1002); review2.setProductId(90102); review2.setRating(4.2);
		
		ProductReview review3 = new ProductReview();
		review3.setId(1003); review3.setProductId(90103); review3.setRating(3.5);
		
		review1.setCustomer(customer);
		review2.setCustomer(customer);
		review3.setCustomer(customer);
		
		List<ProductReview> reviews = Arrays.asList(review1, review2, review3);
		customer.setReviews(reviews);
		
		
		
		customerRepository.save(customer);
	}

}
