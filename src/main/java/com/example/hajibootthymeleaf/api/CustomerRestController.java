package com.example.hajibootthymeleaf.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.hajibootthymeleaf.domain.Customer;
import com.example.hajibootthymeleaf.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;
	
//	@GetMapping
//	List<Customer> getCustomers() {
//		List<Customer> customers = customerService.findAllOrderByName();
//		return customers;
//	}

	@GetMapping
	Page<Customer> getCustomers(@PageableDefault Pageable pageable) {
		Page<Customer> customers = customerService.findPageAllOrderByName(pageable);
		return customers;
	}

	
	@GetMapping(path = "{id}")
	Customer getCustomer(@PathVariable Integer id) {
		Customer customer = customerService.findOne(id);
		return customer;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Customer postCustomers(@RequestBody Customer customer) {
		return customerService.create(customer, null);
	}
	
	@PutMapping(path = "{id}")
	Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerService.update(customer, null);
	}
	
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteCustomer(@PathVariable Integer id) {
		customerService.delete(id);
	}
}
