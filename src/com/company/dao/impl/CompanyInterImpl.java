package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.CompanyInter;
import com.company.entity.Company;
import com.company.entity.Directory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CompanyInterImpl extends AbstractDao implements CompanyInter {

    private Company getCompanyId(ResultSet rs) throws Exception {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        return new Company(id, name);
    }

    private Company getCompany(ResultSet rs) throws Exception {
        Integer id = rs.getInt("id"); //? problem
        String fromCity = rs.getString("from_city");
        String toCity = rs.getString("to_city");
        String price = rs.getString("price");
        String quantity = rs.getString("quantity");
        String name = rs.getString("name");

        return new Company(name, new Directory(fromCity, toCity, price, quantity));


    }


    @Override
    public boolean addCompany(Company company) {
        Company comp = null;
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("insert into company(name,directory_id) values(?,null)");
            stmt.setString(1, company.getName());
            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Company getByCompanyId(Integer id) {
        Company company = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select id,name from company where id=" + id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                company = getCompanyId(rs);
            }
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return company;
    }




    @Override
    public List<Company> getCompanyFlights() {
        List<Company> list = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT directory.*, company.name\n" +
                    "FROM company\n" +
                    "left JOIN directory ON directory.id = company.directory_id");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Company comp = getCompany(rs);
                list.add(comp);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
