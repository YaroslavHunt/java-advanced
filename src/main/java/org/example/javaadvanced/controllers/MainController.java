package org.example.javaadvanced.controllers;

import org.example.javaadvanced.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    List<Customer> customers = new ArrayList<>();
    public MainController() {
        customers.add(new Customer(1, "Jack"));
        customers.add(new Customer(2, "Sara"));
        customers.add(new Customer(3, "Bob"));
        customers.add(new Customer(4, "Arnold"));
        customers.add(new Customer(5, "Mary"));
    }
    //localhost:8080 [GET]
    @GetMapping("/")
    public ResponseEntity<String> getIndex() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
    //localhost:8080 [POST]
    @PostMapping("/")
    public ResponseEntity<String> saveIndex() {
        return new ResponseEntity<>("Hello World", HttpStatus.CREATED);
    }
    //localhost:8080/customers [GET] - get all customers
//   @GetMapping("/customers")
//   @ResponseStatus(HttpStatus.OK)
//   public List<Customer> getCustomers() {
//       return this.customers;
//   }
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    //localhost:8080/customers [POST] - set customer
//    @PostMapping("/customers")
//    public ResponseEntity<List<Customer>> saveCustomer(
//            @RequestParam int id,
//            @RequestParam String name
//    ) {
//        this.customers.add(new Customer(id, name));
//        return new ResponseEntity<>(customers, HttpStatus.CREATED);
//    }
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomerJSONBody(@RequestBody Customer customer) {
        customers.add(customer);
        System.out.println(customers + "\nNEW:" + customer);
    }
    //localhost:8080/customers [DELETE] - delete customer
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable int id) {
        customers.removeIf(customer -> customer.getId() == id);
        return new ResponseEntity<>(customers, HttpStatus.ACCEPTED);
    }

}
