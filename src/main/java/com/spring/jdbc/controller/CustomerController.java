package com.spring.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.jdbc.domain.Customer;
import com.spring.jdbc.exception.InvalidInputException;
import com.spring.jdbc.service.ICustomerService;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/getCustomers/{name}", method = RequestMethod.POST)
	public ResponseEntity<?> getCustomersByName(@PathVariable("name") String name) {
		List<Customer> customers = null;
		try {
			customers = customerService.getCustomersByName(name);
			if (CollectionUtils.isEmpty(customers)) {
				return new ResponseEntity<String>("no customer available", HttpStatus.NOT_FOUND);
			}

		} catch (InvalidInputException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>("Exception occrred " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

}
