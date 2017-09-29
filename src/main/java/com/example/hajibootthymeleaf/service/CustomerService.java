package com.example.hajibootthymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.hajibootthymeleaf.domain.Customer;
import com.example.hajibootthymeleaf.domain.User;
import com.example.hajibootthymeleaf.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> findAllOrderByName() {
		return customerRepository.findAllOrderByName();
	}
	
	public Page<Customer> findPageAllOrderByName(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}
	
	public Customer findOne(Integer id) {
		return customerRepository.findOne(id);
	}
	
	public Customer create(Customer customer, User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}
	
	public Customer update(Customer customer,User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}
	
	public void delete(Integer id) {
		customerRepository.delete(id);
	}
}
