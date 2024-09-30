package org.example.javaadvanced.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.javaadvanced.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CustomerDAO {
    @PersistenceContext
    private EntityManager em;

    public void save(Customer customer) {
        em.persist(customer);
    }

    public void update(Customer customer) {
        em.merge(customer);
    }

    public List<Customer> findAll() {
//        em.createNativeQuery("select * from customer", Customer.class).getResultList();
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    public Customer findById(int id) {
        return em.find(Customer.class, id);
    }

    public void delete(int id) {
        em.remove(findById(id));
    }
}
