package com.example.hajibootthymeleaf.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hajibootthymeleaf.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	// クエリの追加
	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
	List<Customer> findAllOrderByName();
	
	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
	Page<Customer> findPageAllOrderByName(Pageable pageable);
	
}
