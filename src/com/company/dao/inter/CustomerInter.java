package com.company.dao.inter;

import com.company.entity.Customer;

import java.util.List;

public interface CustomerInter {
    public boolean addCustomer(Customer customer);
    public List<Customer> getAllCustomers();
    public Customer getByCustomerId(Integer id);
}
