package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.CustomerTicketInter;
import com.company.entity.Customer;
import com.company.entity.CustomerTicket;
import com.company.entity.Directory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerTicketInterImpl extends AbstractDao implements CustomerTicketInter {
    private CustomerTicket getCustomerTicket(ResultSet rs) throws Exception {
        Integer id = rs.getInt("id");
        String price = rs.getString("price");
        int customerId = rs.getInt("customer_id");
        String name = rs.getString("customer_name");
        String surname = rs.getString("customer_surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        Integer directoryId = rs.getInt("directory_id");
        String fromCity = rs.getString("from_city");
        String toCity = rs.getString("to_city");



        Directory directory = new Directory(fromCity, toCity, price);
        Customer customer = new Customer(name, surname, phone, email);
        return new CustomerTicket(customerId, directory, customer, price);
    }

    @Override
    public List<CustomerTicket> getAlLTickets() {
        List<CustomerTicket> list = new ArrayList<>();

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select ct.* ,d.from_city,d.to_city,\n" +
                    "c.name as customer_name,c.surname as customer_surname,c.phone, c.email from customer_ticket ct \n" +
                    "left join directory d on ct.directory_id = d.id\n" +
                    "left join customer c on ct.customer_id = c.id");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                CustomerTicket ct = getCustomerTicket(rs);
                list.add(ct);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
