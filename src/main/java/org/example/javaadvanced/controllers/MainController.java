package org.example.javaadvanced.controllers;

import lombok.AllArgsConstructor;
import org.example.javaadvanced.dao.CustomerDAO;
import org.example.javaadvanced.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class MainController {

    private CustomerDAO customerDAO;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> all = customerDAO.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        return new ResponseEntity<>(customerDAO.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public void saveCustomerJSONBody(@RequestBody Customer customer) {
        customerDAO.save(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable int id) {
        customerDAO.delete(id);
        return new ResponseEntity<>(customerDAO.findAll(), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer) {
        customerDAO.update(customer);
        return new ResponseEntity<>(customerDAO.findAll(), HttpStatus.OK);
    }

}
