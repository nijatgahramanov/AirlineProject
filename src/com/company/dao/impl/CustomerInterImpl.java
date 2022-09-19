package com.company.dao.impl;

import com.company.dao.inter.CustomerInter;
import com.company.entity.Customer;
import com.company.dao.inter.AbstractDao;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerInterImpl extends AbstractDao implements CustomerInter {
    @Override
    public boolean addCustomer(Customer customer) {
        Customer custom = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into customer (name,surname,phone,mail) values (?,?,?,?)");
            stmt.setString(1, custom.getName());
            stmt.setString(2, custom.getSurname());
            stmt.setString(3, custom.getPhone());
            stmt.setString(4, custom.getEmail());
            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }


    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerResult = new ArrayList<>();

        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("select*from customer");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Customer customer = getCustomer(rs);
                customerResult.add(customer);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customerResult;

    }

    @Override
    public Customer getByCustomerId(Integer id) {
        Customer customer = null;

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.executeQuery("select * from customer where id=" + id);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                customer = getCustomer(rs);
            }
            c.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }


    private Customer getCustomer(ResultSet rs) throws Exception {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");

        return new Customer( name, surname, phone, email);
    }
}
